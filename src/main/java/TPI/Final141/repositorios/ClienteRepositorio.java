
package TPI.Final141.repositorios;

import TPI.Final141.dominio.Cliente;
import java.util.List;


public interface ClienteRepositorio {
    
    Cliente obtenerClientePorDNI(int dniCliente);
    void guardarCliente(Cliente cliente);
    void eliminarCliente(int idCliente);
    
}
