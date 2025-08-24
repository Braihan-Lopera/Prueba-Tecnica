package com.example.BackPruebaTecnica.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_identificacion")
public class Tipo_Identificacion {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoIdentificacion")
    private Integer idTipoIdentificacion;
    @Column(name = "tipo_documento")
    private String tipoDocumento;//Cedula, tarjeta identidad, cedula extranjeta, pasaporte
    @Column(name = "abreviatura")
    private String abreviatura; //cc,ce,ti,pa

    public Tipo_Identificacion(){}

    public Tipo_Identificacion(Integer idTipoIdentificacion, String tipoDocumento, String abreviatura){
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.tipoDocumento = tipoDocumento;
        this.abreviatura = abreviatura;
    }

    public Integer getIdTipoIdentificacion(){return idTipoIdentificacion;}
    public String getTipoDocumento() {return tipoDocumento;}
    public String getAbreviatura(){return abreviatura;}
    public void setIdTipoIdentificacion(Integer idTipoIdentificacion){this.idTipoIdentificacion = idTipoIdentificacion;}
    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}
    public void setAbreviatura(String abreviatura){this.abreviatura = abreviatura;}

    @Override
    public String toString() {
        return "Tipo_Identificacion{" +
                "idTipoIdentificacion=" + idTipoIdentificacion +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                '}';
    }
}
