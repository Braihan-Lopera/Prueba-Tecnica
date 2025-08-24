package com.example.BackPruebaTecnica.servicio;
import com.example.BackPruebaTecnica.Modelos.Pais;
import com.example.BackPruebaTecnica.Repositorio.RepositorioPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPais {
    @Autowired
    RepositorioPais repositorioPais;
    public List<Pais>listarPaises(){
        return repositorioPais.findAll();
    }
}
