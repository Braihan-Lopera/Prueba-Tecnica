package com.example.BackPruebaTecnica.Repositorio;

import com.example.BackPruebaTecnica.Modelos.Tipo_Identificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTipoDocumento extends JpaRepository <Tipo_Identificacion, Integer> {
}
