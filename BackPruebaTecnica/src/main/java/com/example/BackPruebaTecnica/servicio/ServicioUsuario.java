package com.example.BackPruebaTecnica.servicio;

import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.Modelos.Usuario;
import com.example.BackPruebaTecnica.Repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario guardarUsuario(Usuario usuario) {



        // Validar correo único
        if (repositorioUsuario.existsByCorreoUsuarioIgnoreCase(usuario.getCorreoUsuario())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // Validar documento único (combinación tipo+numero)
        if (repositorioUsuario.existsByNumeroDocumentoAndTipoIdentificacion_IdTipoIdentificacion(
                usuario.getNumeroDocumento(), usuario.getTipoIdentificacion().getIdTipoIdentificacion())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese tipo y número de documento.");
        }
        return repositorioUsuario.save(usuario);

    }
    //buscar por correo
    public List<Usuario> buscarPorCorreo(String correo){
        return repositorioUsuario.findByCorreoUsuarioContainingIgnoreCase(correo);
    }
    //buscar por nombre
    public List<Usuario>buscarPorNombre(String nombre){
        return repositorioUsuario.findByNombreUsuarioContainingIgnoreCase(nombre);
    }
    //buscar por numero de documento
    public List<Usuario>buscarPorNumeroDocumento(String numeroDocumento){
        return repositorioUsuario.findByNumeroDocumentoContainingIgnoreCase(numeroDocumento);
    }
    //buscar por id de usuario
    public List<Usuario>buscarPorIdUsuario(int idUsuario){
        return repositorioUsuario.findByIdUsuario(idUsuario);
    }

    //ver usuarios registrados
    public List<Usuario>listarTodos(){
        return repositorioUsuario.findAll();
    }
}