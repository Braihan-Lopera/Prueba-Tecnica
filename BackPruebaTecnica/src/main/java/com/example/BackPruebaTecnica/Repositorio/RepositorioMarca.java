package com.example.BackPruebaTecnica.Repositorio;

import com.example.BackPruebaTecnica.Modelos.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMarca extends JpaRepository <Marca, Integer> {
}
