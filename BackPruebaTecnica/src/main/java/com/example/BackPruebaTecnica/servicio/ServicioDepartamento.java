package com.example.BackPruebaTecnica.servicio;
import com.example.BackPruebaTecnica.Modelos.Departamento;
import com.example.BackPruebaTecnica.Repositorio.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServicioDepartamento {

    @Autowired
    private RepositorioDepartamento repositorioDepartamento;

    public List<Departamento> listarDepartamentos() {
        return repositorioDepartamento.findAll();
    }

    public List<Departamento>listarPorPais(int idPais){
        return repositorioDepartamento.findByPais_IdPais(idPais);
    }
}

