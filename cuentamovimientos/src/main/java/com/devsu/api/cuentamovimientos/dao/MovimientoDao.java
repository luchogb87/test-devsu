package com.devsu.api.cuentamovimientos.dao;

import com.devsu.api.cuentamovimientos.entity.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface MovimientoDao extends CrudRepository<Movimiento, Long> {
}
