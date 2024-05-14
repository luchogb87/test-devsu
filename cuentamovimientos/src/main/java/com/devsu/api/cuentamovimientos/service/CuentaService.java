package com.devsu.api.cuentamovimientos.service;

import com.devsu.api.cuentamovimientos.entity.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaService {
    public List<Cuenta> findAll();
    public Optional<Cuenta> findById(Long id);

    public Cuenta findByAccountNumber(String numeroCuenta);
}
