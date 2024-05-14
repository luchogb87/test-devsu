package com.devsu.api.cuentamovimientos.service.impl;
import com.devsu.api.cuentamovimientos.dao.CuentaDao;
import com.devsu.api.cuentamovimientos.dao.MovimientoDao;
import com.devsu.api.cuentamovimientos.entity.Cuenta;
import com.devsu.api.cuentamovimientos.entity.Movimiento;
import com.devsu.api.cuentamovimientos.entity.RespuestaMovimiento;
import com.devsu.api.cuentamovimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
    private MovimientoDao movimientoDao;

    @Autowired
    private CuentaDao cuentaDao;


    @Override
    public List<Movimiento> listarMovimientos() {
        return (List<Movimiento>) movimientoDao.findAll();
    }

    @Override
    public RespuestaMovimiento crearMovimiento(Movimiento movimiento) {
        Movimiento movimientoGuardado = new Movimiento();
        HttpStatus httpStatus;
        Cuenta cuenta = cuentaDao.findByNumeroCuenta(movimiento.getNumeroCuenta());
        BigDecimal nuevoSaldo = cuenta.getSaldoInicial().add(movimiento.getValor());
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            return new RespuestaMovimiento(movimientoGuardado,HttpStatus.BAD_REQUEST);
        } else{
            cuenta.setSaldoInicial(nuevoSaldo);
            cuentaDao.save(cuenta);
            //movimiento.setId(cuenta.getId());
            movimiento.setCuenta(cuenta);
            movimiento.setSaldo(nuevoSaldo);
            movimientoGuardado =movimientoDao.save(movimiento);
            httpStatus = HttpStatus.OK;
            return new RespuestaMovimiento(movimientoGuardado,HttpStatus.OK);
        }

    }

    @Override
    public Movimiento obtenerMovimientoPorId(Long id) {
        return movimientoDao.findById(id).orElse(null);
    }

    @Override
    public Movimiento editarMovimiento(Long id, Movimiento movimiento) {
        return null;
    }


    @Override
    public void eliminarMovimiento(Long id) {
        movimientoDao.deleteById(id);
    }

}
