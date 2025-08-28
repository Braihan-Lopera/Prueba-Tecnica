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
@RequestMapping ("/ciudad") //mi endpoint para que encuentre las ciudades
public class ControladorCiudad {

    @Autowired
    ServicioCiudad servicioCiudad;


    //mi endpoint para listar las ciudades (igual y creo que me sobra, de por si se muestran las ciudades dependiendo el id del departamento. lo dejo ahi por si acaso :V)
    @GetMapping("/listar")
    public ResponseEntity<List<Ciudad>> listarCiudades() {
        return ResponseEntity.ok(servicioCiudad.listarCiudades());
    }

    //para listar las ciudades dependiendo del id del departamento
    @GetMapping("/listar/{idDepartamento}")
    public ResponseEntity<List<Ciudad>>listarPorDepartamento(@PathVariable int idDepartamento){
        return ResponseEntity.ok(servicioCiudad.listarPorDepartamento(idDepartamento));
    }
}
