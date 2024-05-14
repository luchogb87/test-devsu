package com.devsu.api.cuentamovimientos.service.impl;
import com.devsu.api.cuentamovimientos.dao.CuentaDao;
import com.devsu.api.cuentamovimientos.entity.Cuenta;
import com.devsu.api.cuentamovimientos.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaDao cuentaDao;
    @Override
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaDao.findAll();
    }

    @Override
    public Optional<Cuenta> findById(Long id) {
        return cuentaDao.findById(id);
    }

    @Override
    public Cuenta findByAccountNumber(String numeroCuenta) {
        return cuentaDao.findByNumeroCuenta(numeroCuenta);
    }
}
