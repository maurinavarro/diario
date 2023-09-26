package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "fuezas")
public class Fuerza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank(message = "Este campo es Obligatorio.")
    private String nombre;

     @Column(name = "activo", columnDefinition = "boolean default 1")
    private Boolean activo;    
    
    
    public Fuerza() {
        activo=true;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

     @Override
    public String toString() {
        return nombre;
    }
    
}
