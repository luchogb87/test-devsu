package com.devsu.api.cuentamovimientos.dao;


import com.devsu.api.cuentamovimientos.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<Cuenta, Long> {
    Cuenta findByNumeroCuenta(String numeroCuenta);
}
