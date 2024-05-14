package com.devsu.api.clientepersona.service;
import com.devsu.api.clientepersona.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
}
