package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(name = "detenidos")
public class Detenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 80)
    @NotBlank(message = "Este campo es Obligatorio")
    private String nombreApellido;

    @Column(name = "dni", length = 8, unique = true)
    private String dni;

    @NotBlank(message = "Este campo es Obligatorio")
    private String ultimoDomicilio;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "situacionLaboral")
    private String situacionLaboral;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "nombrePadre")
    private String nombrePadre;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "apellidoPadre")
    private String apellidoPadre;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "nombreMadre")
    private String nombreMadre;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "apellidoMadre")
    private String apellidoMadre;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "situacionEducativaIngreso")
    private String situacionEducativaIngreso;

    @NotBlank(message = "Este campo es requerido.")
    private String puebloOriginario;

    @Column(name = "imagen")    
    private String imagen;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "fuerza")
    private String fuerza;
    
    @Column(name = "activo", columnDefinition = "boolean default 1")
    private Boolean activo;      
   

    @OneToOne(mappedBy = "detenido", fetch = FetchType.LAZY)
    private DatosJudiciales datosJudiciales;

    @OneToOne(mappedBy = "detenido", fetch = FetchType.LAZY)
    private DatosCriminologico datosCriminologico;

    public Detenido() {
        activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUltimoDomicilio() {
        return ultimoDomicilio;
    }

    public void setUltimoDomicilio(String ultimoDomicilio) {
        this.ultimoDomicilio = ultimoDomicilio;
    }

    public String getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(String situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getApellidoPadre() {
        return apellidoPadre;
    }

    public void setApellidoPadre(String apellidoPadre) {
        this.apellidoPadre = apellidoPadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getApellidoMadre() {
        return apellidoMadre;
    }

    public void setApellidoMadre(String apellidoMadre) {
        this.apellidoMadre = apellidoMadre;
    }

    public String getSituacionEducativaIngreso() {
        return situacionEducativaIngreso;
    }

    public void setSituacionEducativaIngreso(String situacionEducativaIngreso) {
        this.situacionEducativaIngreso = situacionEducativaIngreso;
    }

    public String getPuebloOriginario() {
        return puebloOriginario;
    }

    public void setPuebloOriginario(String puebloOriginario) {
        this.puebloOriginario = puebloOriginario;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public DatosJudiciales getDatosJudiciales() {
        return datosJudiciales;
    }

    public void setDatosJudiciales(DatosJudiciales datosJudiciales) {
        this.datosJudiciales = datosJudiciales;
    }

    public DatosCriminologico getDatosCriminologico() {
        return datosCriminologico;
    }

    public void setDatosCriminologico(DatosCriminologico datosCriminologico) {
        this.datosCriminologico = datosCriminologico;
    }
   
    public boolean isActivo() {
        return activo;
    }

    public String getFuerza() {
        return fuerza;
    }

    public void setFuerza(String fuerza) {
        this.fuerza = fuerza;
    }

        

}
