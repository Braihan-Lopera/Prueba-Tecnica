package com.example.BackPruebaTecnica.controlador;

import com.example.BackPruebaTecnica.Modelos.Pais;
import com.example.BackPruebaTecnica.servicio.ServicioPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/paises")
public class ControladorPais {
    @Autowired
    ServicioPais servicioPais;
    @GetMapping ("/listar")
    public ResponseEntity<?>listarPaises(){
        try{
        return ResponseEntity.ok(servicioPais.listarPaises());
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
