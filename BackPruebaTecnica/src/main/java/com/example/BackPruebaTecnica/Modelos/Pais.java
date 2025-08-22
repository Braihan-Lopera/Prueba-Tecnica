package com.example.BackPruebaTecnica.Modelos;
import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPais;
    private String pais;


    public Pais(){
    }

    public Pais(Integer idPais, String pais){
        this.idPais = idPais;
        this.pais = pais;
    }

    public Integer getIdPais() {return idPais;}

    public void setIdPais(Integer idPais) {this.idPais = idPais;}

    public String getPais() {return pais;}

    public void setPais(String pais) {this.pais = pais;}

    @Override
    public String toString() {
        return "Pais{" +
                "idPais=" + idPais +
                ", pais='" + pais + '\'' +
                '}';
    }
}
