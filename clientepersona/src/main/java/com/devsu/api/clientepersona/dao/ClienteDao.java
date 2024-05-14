package com.devsu.api.clientepersona.dao;
import com.devsu.api.clientepersona.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
