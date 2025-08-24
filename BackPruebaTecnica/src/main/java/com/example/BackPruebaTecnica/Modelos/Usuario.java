package com.example.BackPruebaTecnica.Modelos;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Column(name = "correo_usuario")
    private String correoUsuario;
    @Column(name = "telefono_usuario")
    private String telefonoUsuario;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "direccion_usuario")
    private String direccionUsuario;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @ManyToOne
    @JoinColumn(name = "id_tipoIdentificacion")
    private Tipo_Identificacion tipoIdentificacion;
    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private Ciudad ciudad;

    public Usuario(){}

    public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario, String telefonoUsuario, LocalDate fechaNacimiento, String direccionUsuario, String numeroDocumento, Tipo_Identificacion tipoIdentificacion, Marca marca, Pais pais, Departamento departamento, Ciudad ciudad) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionUsuario = direccionUsuario;
        this.numeroDocumento = numeroDocumento;
        this.tipoIdentificacion = tipoIdentificacion;
        this.marca = marca;
        this.pais = pais;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Tipo_Identificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Tipo_Identificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", apellidoUsuario='" + apellidoUsuario + '\'' +
                ", correoUsuario='" + correoUsuario + '\'' +
                ", telefonoUsuario=" + telefonoUsuario +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccionUsuario='" + direccionUsuario + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", tipoIdentificacion=" + tipoIdentificacion +
                ", marca=" + marca +
                ", pais=" + pais +
                ", departamento=" + departamento +
                ", ciudad=" + ciudad +
                '}';
    }
}
