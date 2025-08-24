package com.example.BackPruebaTecnica.Modelos;

import jakarta.persistence.*;

@Entity
@Table (name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_departamento")
    private Integer idDepartamento;
    private String departamento;

    //claves foraneas
    @ManyToOne
    @JoinColumn(name ="id_pais")
    private Pais pais;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento, String departamento, Pais pais) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
        this.pais = pais;
    }

    public Integer getIdDepartamento() {return idDepartamento;}

    public void setIdDepartamento(Integer idDepartamento) {this.idDepartamento = idDepartamento;}

    public String getDepartamento() {return departamento;}

    public void setDepartamento(String departamento) {this.departamento = departamento;}

    public Pais getPais(){return pais;}

    public void setPais(Pais pais){this.pais = pais;}

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", departamento='" + departamento + '\'' +
                ", pais=" + pais +
                '}';
    }
}
