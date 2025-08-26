package com.example.BackPruebaTecnica.controlador;
import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.Modelos.Usuario;
import com.example.BackPruebaTecnica.servicio.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario servicioUsuario;

    // Registrar usuario
    @PostMapping("/guardar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario nuevoUsuario = servicioUsuario.guardarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        } catch (IllegalArgumentException e) {
            // conflicto por correo/documento duplicado
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            // error inesperado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar usuario");
        }
    }

    // Buscar por correo
    @GetMapping("/buscarPorCorreo")
    public List<Usuario> buscarPorCorreo(@RequestParam String correo) {
        return servicioUsuario.buscarPorCorreo(correo);
    }

    // Buscar por nombre
    @GetMapping("/buscarPorNombre")
    public List<Usuario> buscarPorNombre(@RequestParam String nombre) {
        return servicioUsuario.buscarPorNombre(nombre);
    }

    // Buscar por número de documento
    @GetMapping("/buscarPorNumeroDocumento")
    public List<Usuario> buscarPorNumeroDocumento(@RequestParam String numeroDocumento) {
        return servicioUsuario.buscarPorNumeroDocumento(numeroDocumento);
    }

    // Buscar por id de usuario
    @GetMapping("/buscarPorIdUsuario")
    public List<Usuario> buscarPorIdUsuario(@RequestParam int idUsuario) {
        return servicioUsuario.buscarPorIdUsuario(idUsuario);
    }

    // Listar todos
    @GetMapping("/listar")
    public List<Usuario> listar() {
        return servicioUsuario.listarTodos();
    }
}