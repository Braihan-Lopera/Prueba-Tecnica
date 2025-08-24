package com.example.BackPruebaTecnica.Modelos;
import jakarta.persistence.*;

@Entity
@Table (name = "marca")
public class Marca {//marcas segun mi persona no tiene claves foraneas :V
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca")
    private Integer idMarca;
    @Column(name = "nombre_marca")
    private String nombreMarca;



    public Marca() {
    }

    public Marca (Integer idMarca, String nombreMarca){
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    public Integer getIdMarca() {return idMarca;}

    public void setIdMarca(Integer idMarca) {this.idMarca = idMarca;}

    public String getNombreMarca() {return nombreMarca;}

    public void setNombreMarca(String nombreMarca) {this.nombreMarca = nombreMarca;}



    @Override
    public String toString() {
        return "Marca{" +
                "idMarca=" + idMarca +
                ", nombreMarca='" + nombreMarca + '\'' +
                '}';
    }
}
