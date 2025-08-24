package com.example.BackPruebaTecnica.Modelos;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioMarcaId implements Serializable {
    private Integer usuario;
    private Integer marca;

    public UsuarioMarcaId() {}

    public UsuarioMarcaId(Integer usuario, Integer marca) {
        this.usuario = usuario;
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioMarcaId that = (UsuarioMarcaId) o;
        return Objects.equals(usuario, that.usuario) && Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, marca);
    }
}

