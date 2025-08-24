package com.example.BackPruebaTecnica.Modelos;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuario_marca")
@IdClass(UsuarioMarcaId.class) // clave compuesta
public class UsuarioMarca {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    public UsuarioMarca() {}

    public UsuarioMarca(Usuario usuario, Marca marca) {
        this.usuario = usuario;
        this.marca = marca;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }

    @Override
    public String toString() {
        return "UsuarioMarca{" +
                "usuario=" + usuario +
                ", marca=" + marca +
                '}';
    }
}

