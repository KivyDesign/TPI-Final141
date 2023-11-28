package org.tpi_arg_prog.entities.repository;

import org.tpi_arg_prog.entities.Cliente;

import java.util.List;
import java.util.Map;

public interface ClienteRepositorio {

    void agregarCliente(Cliente cliente);

    void actualizarCliente(Cliente cliente);

    Cliente traerPorId(Long id);

    void eliminarCliente(Cliente cliente);

    List<Cliente> traerTodosClientes();

}
