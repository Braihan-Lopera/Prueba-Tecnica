package com.example.BackPruebaTecnica.controlador;


import com.example.BackPruebaTecnica.Modelos.Tipo_Identificacion;
import com.example.BackPruebaTecnica.servicio.ServicioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo-identificacion")
public class ControladorTipoDocumento {
    @Autowired
    ServicioTipoDocumento servicioTipoDocumento;

    @GetMapping("/listar")
    public ResponseEntity<?>listarTipoDocumento(){
        return ResponseEntity.ok(servicioTipoDocumento.listarTipoDocumento());
    }
}
