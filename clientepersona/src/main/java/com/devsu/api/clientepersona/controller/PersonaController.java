package com.devsu.api.clientepersona.controller;
import com.devsu.api.clientepersona.entity.Persona;
import com.devsu.api.clientepersona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> listarPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.findById(id);
    }
}
