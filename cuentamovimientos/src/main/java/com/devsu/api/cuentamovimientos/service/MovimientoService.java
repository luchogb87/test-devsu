package com.devsu.api.cuentamovimientos.service;


import com.devsu.api.cuentamovimientos.entity.Movimiento;
import com.devsu.api.cuentamovimientos.entity.RespuestaMovimiento;

public interface MovimientoService {

    Iterable<Movimiento> listarMovimientos();
    RespuestaMovimiento crearMovimiento(Movimiento movimiento);

    Movimiento obtenerMovimientoPorId(Long id);

    Movimiento editarMovimiento(Long id, Movimiento movimiento);

    void eliminarMovimiento(Long id);
}
