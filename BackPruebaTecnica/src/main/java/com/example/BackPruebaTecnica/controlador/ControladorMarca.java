package com.example.BackPruebaTecnica.controlador;

import com.example.BackPruebaTecnica.servicio.ServicioMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/marcas")
public class ControladorMarca {

    @Autowired
    private ServicioMarca servicioMarca;

    @GetMapping("/listar")
    public ResponseEntity<?> listarMarcas() {
        try {
            return ResponseEntity.ok(servicioMarca.listarMarcas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
