package TPI.Final141.servicios;

import TPI.Final141.config.HibernateUtil;
import TPI.Final141.dominio.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import TPI.Final141.repositorios.ClienteRepositorio;
import org.hibernate.cfg.Configuration;

public class ClienteServicio implements ClienteRepositorio {

    @Override
    public Cliente obtenerClientePorDNI(int dniCliente) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Cliente cliente = null;

        try {
            session.beginTransaction();

            cliente = session.createQuery("FROM Cliente WHERE dniCliente = :dni", Cliente.class)
                    .setParameter("dni", dniCliente)
                    .uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("El cliente no se encuentra");
        } finally {
            session.close();
        }

        System.out.println(cliente);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(cliente);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public void eliminarCliente(int idCliente) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Cliente cliente = session.get(Cliente.class, idCliente);

        if (cliente != null) {
            session.delete(cliente);
            session.getTransaction().commit();
        } else {
            System.out.println("No existe este cliente");
        }

        session.close();
    }
}
