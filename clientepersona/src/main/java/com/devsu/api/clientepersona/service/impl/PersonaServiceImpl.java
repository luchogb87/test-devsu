package com.devsu.api.clientepersona.service.impl;
import com.devsu.api.clientepersona.dao.PersonaDao;
import com.devsu.api.clientepersona.entity.Persona;
import com.devsu.api.clientepersona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;
    @Override
    public List<Persona> findAll() {
        return (List<Persona>)personaDao.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaDao.findById(id);
    }
}
