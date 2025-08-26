package com.example.BackPruebaTecnica.servicio;

import com.example.BackPruebaTecnica.Modelos.Ciudad;
import com.example.BackPruebaTecnica.Repositorio.RepositorioCiudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCiudad {
@Autowired
    RepositorioCiudad repositorioCiudad;
    public List <Ciudad> listarCiudades(){
        return repositorioCiudad.findAll();
    }
    public List<Ciudad>listarPorDepartamento(int idDepartamento){
        return repositorioCiudad.findByDepartamento_IdDepartamento(idDepartamento);
    }
}
