package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "datosCriminologicos")
public class DatosCriminologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    @NotBlank(message = "Este campo es obligatorio.")
    private String aliasApodo;

    @NotBlank(message = "Este campo es obligatorio.")
    private String reincidencia;

    @Size(max = 30)
    @NotBlank(message = "Este campo es obligatorio.")
    private String permanenciaTransito;

    @Size(max = 30)
    @NotBlank(message = "Este campo es obligatorio.")
    private String condenadoProcesado;

    @Size(max = 30)
    @NotBlank(message = "Este campo es obligatorio.")
    private String beneficios;

    @Size(max = 250)
    @NotBlank(message = "Este campo es obligatorio.")
    private String salidaTransitoriaModalidad;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detenido_id", referencedColumnName = "id")
    private Detenido detenido;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getAliasApodo() {
        return aliasApodo;
    }

    public void setAliasApodo(String aliasApodo) {
        this.aliasApodo = aliasApodo;
    }

    public String getReincidencia() {
        return reincidencia;
    }

    public void setReincidencia(String reincidencia) {
        this.reincidencia = reincidencia;
    }

    public String getPermanenciaTransito() {
        return permanenciaTransito;
    }

    public void setPermanenciaTransito(String permanenciaTransito) {
        this.permanenciaTransito = permanenciaTransito;
    }

    public String getCondenadoProcesado() {
        return condenadoProcesado;
    }

    public void setCondenadoProcesado(String condenadoProcesado) {
        this.condenadoProcesado = condenadoProcesado;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getSalidaTransitoriaModalidad() {
        return salidaTransitoriaModalidad;
    }

    public void setSalidaTransitoriaModalidad(String salidaTransitoriaModalidad) {
        this.salidaTransitoriaModalidad = salidaTransitoriaModalidad;
    }

    public Detenido getDetenido() {
        return detenido;
    }

    public void setDetenido(Detenido detenido) {
        this.detenido = detenido;
    }

}
