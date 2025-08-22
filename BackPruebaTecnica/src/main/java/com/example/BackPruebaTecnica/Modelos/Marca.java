package com.example.BackPruebaTecnica.Modelos;
import jakarta.persistence.*;

@Entity
@Table (name = "marca")
public class Marca {//marcas segun mi persona no tiene claves foraneas :V
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMarca;
    private String nombreMarca;
    private String empresaMarca;//comodin, ilogistic, etc...



    public Marca() {
    }

    public Marca (Integer idMarca, String nombreMarca, String empresaMarca){
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.empresaMarca = empresaMarca;
    }

    public Integer getIdMarca() {return idMarca;}

    public void setIdMarca(Integer idMarca) {this.idMarca = idMarca;}

    public String getNombreMarca() {return nombreMarca;}

    public void setNombreMarca(String nombreMarca) {this.nombreMarca = nombreMarca;}

    public String getEmpresaMarca() {return empresaMarca;}

    public void setEmpresaMarca(String empresaMarca) {this.empresaMarca = empresaMarca;}

    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", nombreMarca='" + nombreMarca + '\'' +
                ", empresaMarca='" + empresaMarca + '\'' +
                '}';
    }
}
