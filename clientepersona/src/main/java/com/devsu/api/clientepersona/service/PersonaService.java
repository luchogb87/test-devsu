package com.devsu.api.clientepersona.service;

import com.devsu.api.clientepersona.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    public List<Persona> findAll();
    public Optional<Persona> findById(Long id);
}
