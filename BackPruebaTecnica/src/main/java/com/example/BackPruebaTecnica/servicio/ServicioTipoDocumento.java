package com.example.BackPruebaTecnica.servicio;


import com.example.BackPruebaTecnica.Modelos.Tipo_Identificacion;
import com.example.BackPruebaTecnica.Repositorio.RepositorioTipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTipoDocumento{
    @Autowired
    RepositorioTipoDocumento repositorioTipoDocumento;

    public List<Tipo_Identificacion>listarTipoDocumento(){
    return repositorioTipoDocumento.findAll();
    }
}
