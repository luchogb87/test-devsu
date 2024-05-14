package com.devsu.api.clientepersona.service.impl;
import com.devsu.api.clientepersona.dao.ClienteDao;
import com.devsu.api.clientepersona.entity.Cliente;
import com.devsu.api.clientepersona.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteDao clienteDao;


    @Override
    public List<Cliente> listarClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    public Cliente editarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = obtenerClientePorId(id);
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());
            clienteExistente.setGenero(cliente.getGenero());
            clienteExistente.setEdad(cliente.getEdad());
            clienteExistente.setIdentificacion(cliente.getIdentificacion());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setTelefono(cliente.getTelefono());
            // Puedes actualizar otros atributos aquí según sea necesario
            return clienteDao.save(clienteExistente);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteDao.deleteById(id);
    }
}
