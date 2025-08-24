package com.example.BackPruebaTecnica.Repositorio;


import com.example.BackPruebaTecnica.Modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCiudad extends JpaRepository<Ciudad, Integer>{
}
