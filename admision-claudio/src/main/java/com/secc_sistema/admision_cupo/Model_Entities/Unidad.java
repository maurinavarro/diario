package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "unidades")
public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es requerido")
    private String nombre;

    @NotBlank(message = "El nombre es requerido")
    private Long cantidad;

    @NotBlank(message = "El nombre es requerido")
    private Long cupo;

     @NotBlank(message = "El nombre es requerido")
    private Long plaza;

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

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCupo() {
        return cupo;
    }

    public void setCupo(Long cupo) {
        this.cupo = cupo;
    }

    public Long getPlaza() {
        return plaza;
    }

    public void setPlaza(Long plaza) {
        this.plaza = plaza;
    }

    
    

}
