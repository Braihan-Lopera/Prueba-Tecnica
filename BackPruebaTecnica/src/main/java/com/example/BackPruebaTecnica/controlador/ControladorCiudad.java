package com.example.BackPruebaTecnica.controlador;


import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.servicio.ServicioCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/ciudad")
public class ControladorCiudad {
    @Autowired
    ServicioCiudad Ciudad;
    @GetMapping("/listar")
    public ResponseEntity<?>listarCiudades(@RequestBody Ciudad datosDelFront){
    try{
        return ResponseEntity.status(HttpStatus.OK).body(Ciudad.listarCiudades(datosDelFront));
    }catch (Exception error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
    }
    }
}
