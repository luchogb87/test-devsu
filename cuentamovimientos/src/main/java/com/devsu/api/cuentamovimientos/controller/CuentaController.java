package com.devsu.api.cuentamovimientos.controller;
import com.devsu.api.cuentamovimientos.entity.Cuenta;
import com.devsu.api.cuentamovimientos.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> listar() {
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cuenta> obtenerClientePorId(@PathVariable Long id) {
        return cuentaService.findById(id);
    }

    @GetMapping("/cuenta/{numeroCuenta}")
    public ResponseEntity<Cuenta> ObtenerCuentaPorNumeroDeCuenta(@PathVariable String numeroCuenta) {
        Cuenta cuentaBuscada = cuentaService.findByAccountNumber(numeroCuenta);
        if (cuentaBuscada != null) {
            return new ResponseEntity<>(cuentaBuscada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
