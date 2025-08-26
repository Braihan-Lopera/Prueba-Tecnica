package com.example.BackPruebaTecnica.Repositorio;

import com.example.BackPruebaTecnica.Modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioDepartamento extends JpaRepository <Departamento, Integer> {
    List<Departamento>findByPais_IdPais(int idpais);
}
