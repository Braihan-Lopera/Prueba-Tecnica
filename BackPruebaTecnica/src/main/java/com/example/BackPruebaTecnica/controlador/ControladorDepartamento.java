package com.example.BackPruebaTecnica.controlador;


import com.example.BackPruebaTecnica.Modelos.Departamento;
import com.example.BackPruebaTecnica.servicio.ServicioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class ControladorDepartamento {

    @Autowired
    private ServicioDepartamento servicioDepartamento;
    @GetMapping("/listar")
    public ResponseEntity<List<Departamento>> listarDepartamentos() {
        List<Departamento> departamentos = servicioDepartamento.listarDepartamentos();
        return ResponseEntity.ok(departamentos);
    }
}

