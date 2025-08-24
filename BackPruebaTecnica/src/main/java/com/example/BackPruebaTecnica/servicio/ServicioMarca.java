package com.example.BackPruebaTecnica.servicio;

import com.example.BackPruebaTecnica.Modelos.Marca;
import com.example.BackPruebaTecnica.Repositorio.RepositorioMarca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMarca {

    @Autowired
    private RepositorioMarca repositorioMarca;

    public List<Marca> listarMarcas() {
        return repositorioMarca.findAll();
    }
}



