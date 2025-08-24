package com.example.BackPruebaTecnica.servicio;

import com.example.BackPruebaTecnica.Modelos.Usuario;
import com.example.BackPruebaTecnica.Repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repo;

    public Usuario guardarUsuario(Usuario usuario) {
        // Validar correo único
        if (repo.existsByCorreoUsuarioIgnoreCase(usuario.getCorreoUsuario())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Validar documento único (combinación tipo+numero)
        if (repo.existsByNumeroDocumentoAndTipoIdentificacion_IdTipoIdentificacion(
                usuario.getNumeroDocumento(), usuario.getTipoIdentificacion().getIdTipoIdentificacion())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese tipo y número de documento.");
        }
        return repo.save(usuario);
    }
}