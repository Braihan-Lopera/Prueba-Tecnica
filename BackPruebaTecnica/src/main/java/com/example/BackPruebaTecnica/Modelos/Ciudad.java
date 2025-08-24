package com.example.BackPruebaTecnica.Modelos;

import jakarta.persistence.*;
@Entity
@Table (name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_ciudad")
    private Integer idCiudad;
    private String ciudad;
    //claves foraneas
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad, String ciudad, Departamento departamento) {
        this.idCiudad = idCiudad;
        this.ciudad = ciudad;
        this.departamento = departamento;
    }

    public Integer getIdCiudad() {return idCiudad;}

    public void setIdCiudad(Integer idCiudad) {this.idCiudad = idCiudad;}

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {this.ciudad = ciudad;}

    public void setDepartamento(Departamento departamento){this.departamento = departamento;}

    @Override
    public String toString() {
        return "Ciudad{" +
                "idCiudad=" + idCiudad +
                ", ciudad='" + ciudad + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}
