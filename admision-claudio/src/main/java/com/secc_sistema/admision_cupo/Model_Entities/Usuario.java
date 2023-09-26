package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "usuarios")
public class Usuario  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30, min = 5)
    @NotBlank(message = "El nombre es requerido.")
    private String nombre;

    @Size(max = 70, min = 6, message = "La contraseña debe contener al menos 6 caracteres.")
    private String clave;

    // @Email(message = "El correo no es válido.")
    @Pattern(regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$", message="Escribe nuevamente tu email")
    private String email;

    @Column(name = "activo", columnDefinition = "boolean default 1")
    private Boolean activo;

    @Column(name = "dni", length = 8, nullable = false)
    @Size(max = 8, min = 6)
    @NotBlank(message = "Este campo es Obligatorio.")
    private String dni;

    @Size(max = 30)
    @NotBlank(message = "Este campo es Obligatorio.")
    private String jerarquia;

    @Size(max = 30, min = 5)
    @NotBlank(message = "Este campo es Obligatorio.")
    private String funcion;

    @NotBlank(message = "Este campo es Obligatorio.")
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    
     @Size(max = 50, min = 5)
    @NotBlank(message = "Este campo es Obligatorio.")
    private String unidadSoliciante;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fuerza", referencedColumnName = "id")
    private Fuerza fuerza;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permiso", referencedColumnName = "id")
    private Permiso permiso;

    public Usuario() {
        activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    public String getEmail() {
        return email;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUnidadSoliciante() {
        return unidadSoliciante;
    }

    public void setUnidadSoliciante(String unidadSoliciante) {
        this.unidadSoliciante = unidadSoliciante;
    }

    public Fuerza getFuerza() {
        return fuerza;
    }

    public void setFuerza(Fuerza fuerza) {
        this.fuerza = fuerza;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
   
    
}
