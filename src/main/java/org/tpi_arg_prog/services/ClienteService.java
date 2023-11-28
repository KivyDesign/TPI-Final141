package org.tpi_arg_prog.services;

import org.tpi_arg_prog.entities.Cliente;
import org.tpi_arg_prog.entities.repository.ClienteRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClienteService {

    private ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public void agregarCliente(Cliente cliente) {
        clienteRepositorio.agregarCliente(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        clienteRepositorio.actualizarCliente(cliente);
    }

    public Cliente traerPorId(Long id) {
        return clienteRepositorio.traerPorId(id);
    }

    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.eliminarCliente(cliente);
    }

    public List<Cliente> traerTodosClientes() {
        return clienteRepositorio.traerTodosClientes();
    }

}
