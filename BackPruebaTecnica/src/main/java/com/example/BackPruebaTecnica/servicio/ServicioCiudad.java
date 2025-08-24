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
    public List <Ciudad> listarCiudades(Ciudad datosCiudad)throws Exception {
        try {
            return repositorioCiudad.findAll();

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
