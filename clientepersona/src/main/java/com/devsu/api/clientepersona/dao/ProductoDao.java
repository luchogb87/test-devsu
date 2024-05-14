package com.devsu.api.clientepersona.dao;


import com.devsu.api.clientepersona.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}
