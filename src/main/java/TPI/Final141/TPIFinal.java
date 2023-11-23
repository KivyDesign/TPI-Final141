package TPI.Final141;

import TPI.Final141.dominio.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import TPI.Final141.servicios.ClienteServicio;

public class TPIFinal {

    public static void main(String[] args) {
        // Creo un nuevo cliente y lo guardarlo utilizando persistencia
        Cliente cliente = new Cliente();

        cliente.setDniCliente(55555555);
        cliente.setDireccionCliente("Córdoba s/n");
        cliente.setNombreCliente("Commisión 141");
        cliente.setEmailCliente("comision141@gmail.com");

        ClienteServicio clienteServicio = new ClienteServicio();
        clienteServicio.guardarCliente(cliente);

        // Eliminar un cliente
//        clienteServicio.eliminarCliente(4);

        // obtenerClientePorDNI
//        clienteServicio.obtenerClientePorDNI(33333333);
    }
}
