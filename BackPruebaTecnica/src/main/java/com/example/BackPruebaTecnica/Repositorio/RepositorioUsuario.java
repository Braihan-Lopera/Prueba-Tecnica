package com.example.BackPruebaTecnica.Repositorio;

import com.example.BackPruebaTecnica.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    boolean existsByCorreoUsuarioIgnoreCase(String correoUsuario);
    boolean existsByNumeroDocumentoAndTipoIdentificacion_IdTipoIdentificacion(String numeroDocumento, Integer idTipoIdentificacion);
}

