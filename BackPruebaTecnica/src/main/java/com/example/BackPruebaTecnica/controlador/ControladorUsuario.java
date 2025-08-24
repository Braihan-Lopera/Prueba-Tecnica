package com.example.BackPruebaTecnica.controlador;
import com.example.BackPruebaTecnica.Modelos.Usuario;
import com.example.BackPruebaTecnica.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicio;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody Usuario usuario) {
        try {
            Usuario guardado = servicio.guardarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}