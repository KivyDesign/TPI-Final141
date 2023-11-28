package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Cliente;
import org.tpi_arg_prog.entities.repository.dao.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JpaClienteRepositorio implements ClienteRepositorio {

    private DAO dao;

    public JpaClienteRepositorio(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        System.out.println("Salvando el cliente en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cliente);
            entityManager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        System.out.println("Actualizando el cliente en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManager.flush();
        }
    }

    @Override
    public Cliente traerPorId(Long id) {
        System.out.println("Trayendo el cliente desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.find(Cliente.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        System.out.println("Actualizando el cliente en la DB");
        EntityManager entityManager = dao.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Cliente> traerTodosClientes() {

        System.out.println("Trayendo el cliente desde la DB");
        EntityManager entityManager = dao.getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Cliente e").getResultList();
        } finally {
            entityManager.close();
        }
    }
}
