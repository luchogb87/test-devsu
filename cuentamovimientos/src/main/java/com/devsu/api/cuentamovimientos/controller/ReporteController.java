package com.devsu.api.cuentamovimientos.controller;

import com.devsu.api.cuentamovimientos.entity.Movimiento;
import com.devsu.api.cuentamovimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public Iterable<Movimiento> listar(){
        //Aquí listamos todos los movimientos para poder armar el EECC.
        return movimientoService.listarMovimientos();
    }

    @GetMapping("/test")
    public String Health(){
        return "Probando servicio";
    }

}
