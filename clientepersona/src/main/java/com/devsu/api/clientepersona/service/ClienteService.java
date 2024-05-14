package com.devsu.api.clientepersona.service;


import com.devsu.api.clientepersona.entity.Cliente;

public interface ClienteService {

    Iterable<Cliente> listarClientes();
    Cliente crearCliente(Cliente cliente);

    Cliente obtenerClientePorId(Long id);

    Cliente editarCliente(Long id, Cliente cliente);

    void eliminarCliente(Long id);
}
