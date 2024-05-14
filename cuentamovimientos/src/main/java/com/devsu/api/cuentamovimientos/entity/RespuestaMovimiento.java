package com.devsu.api.cuentamovimientos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class RespuestaMovimiento {
    private Movimiento movimiento;
    private HttpStatus status;

    public RespuestaMovimiento(Movimiento movimiento, HttpStatus status) {
        this.movimiento = movimiento;
        this.status = status;
    }
}
