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
@RequestMapping("/Tipo_documento")
public class ControladorTipoDocumento {
    @Autowired
    ServicioTipoDocumento servicioTipoDocumento;
    @GetMapping("/Listar")
    public ResponseEntity<?>listarTipoDocumento(){
        try{
            return ResponseEntity.ok(servicioTipoDocumento.listarTipoDocumento());
        }catch (Exception error){
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
