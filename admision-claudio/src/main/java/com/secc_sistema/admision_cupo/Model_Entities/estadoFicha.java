package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estadoFichas")
public class estadoFicha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detenido", columnDefinition = "boolean default false")
    private Boolean detenido = false;

    @Column(name = "datosJudiciales", columnDefinition = "boolean default false")
    private Boolean datosJudiciales = false;

    @Column(name = "datosCriminologicos", columnDefinition = "boolean default false")
    private Boolean datosCriminologicos = false;

    @OneToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitudes solicitud;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDatosJudiciales() {
        return datosJudiciales;
    }

    public void setDatosJudiciales(Boolean datosJudiciales) {
        this.datosJudiciales = datosJudiciales;
    }

    public Boolean getDatosCriminologicos() {
        return datosCriminologicos;
    }

    public void setDatosCriminologicos(Boolean datosCriminologicos) {
        this.datosCriminologicos = datosCriminologicos;
    }

    public Solicitudes getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitudes solicitud) {
        this.solicitud = solicitud;
    }

    public Boolean getDetenido() {
        return detenido;
    }

    public void setDetenido(Boolean detenido) {
        this.detenido = detenido;
    }

    
}
