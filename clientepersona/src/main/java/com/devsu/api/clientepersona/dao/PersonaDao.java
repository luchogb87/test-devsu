package com.devsu.api.clientepersona.dao;


import com.devsu.api.clientepersona.entity.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}
