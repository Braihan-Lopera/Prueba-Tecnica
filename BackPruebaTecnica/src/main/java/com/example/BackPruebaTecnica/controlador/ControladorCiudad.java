package com.example.BackPruebaTecnica.controlador;


import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.Repositorio.RepositorioCiudad;
import com.example.BackPruebaTecnica.servicio.ServicioCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ciudad")
public class ControladorCiudad {

    @Autowired
    ServicioCiudad servicioCiudad;

    @GetMapping("/listar")
    public ResponseEntity<List<Ciudad>> listarCiudades() {
        return ResponseEntity.ok(servicioCiudad.listarCiudades());
    }

    @GetMapping("/listar/{idDepartamento}")
    public ResponseEntity<List<Ciudad>>listarPorDepartamento(@PathVariable int idDepartamento){
        return ResponseEntity.ok(servicioCiudad.listarPorDepartamento(idDepartamento));
    }
}
