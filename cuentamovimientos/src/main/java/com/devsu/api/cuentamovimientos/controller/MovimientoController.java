package com.devsu.api.cuentamovimientos.controller;
import com.devsu.api.cuentamovimientos.entity.Movimiento;
import com.devsu.api.cuentamovimientos.entity.RespuestaMovimiento;
import com.devsu.api.cuentamovimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public Iterable<Movimiento> listar(){
        return movimientoService.listarMovimientos();
    }

    @PostMapping
    public ResponseEntity<?> crearMovimiento(@RequestBody Movimiento movimiento) {
        RespuestaMovimiento nuevoMovimiento = movimientoService.crearMovimiento(movimiento);
        if(nuevoMovimiento.getStatus() == HttpStatus.OK){
            return new ResponseEntity<>(nuevoMovimiento.getMovimiento(), nuevoMovimiento.getStatus());
        }else{
            return ResponseEntity
                    .badRequest()
                    .body("¡Saldo no disponible!");
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable Long id) {
        Movimiento movimiento = movimientoService.obtenerMovimientoPorId(id);
        if (movimiento != null) {
            return new ResponseEntity<>(movimiento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> editarMovimiento(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        Movimiento movimientoEditado = movimientoService.editarMovimiento(id, movimiento);
        if (movimientoEditado != null) {
            return new ResponseEntity<>(movimientoEditado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        movimientoService.eliminarMovimiento(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public String Health(){
        return "Probando servicio";
    }
}
