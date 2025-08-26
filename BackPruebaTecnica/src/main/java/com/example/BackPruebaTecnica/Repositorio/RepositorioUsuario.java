package com.example.BackPruebaTecnica.Repositorio;

import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    boolean existsByCorreoUsuarioIgnoreCase(String correoUsuario);

    boolean existsByNumeroDocumentoAndTipoIdentificacion_IdTipoIdentificacion(String numeroDocumento, Integer idTipoIdentificacion);

    List<Usuario> findByCorreoUsuarioContainingIgnoreCase(String correoUsuario);

    List<Usuario> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);

    List<Usuario> findByApellidoUsuarioContainingIgnoreCase(String apellidoUsuario);

    List<Usuario> findByNumeroDocumentoContainingIgnoreCase(String numeroDocumento);

    List<Usuario> findByIdUsuario(int idUsuario);
}

