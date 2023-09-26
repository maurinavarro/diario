package com.secc_sistema.admision_cupo.Model_Entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "solicitudes")
public class Solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm z")
    @Column(name = "fechaSolicitud")
    private LocalDateTime fechaSolicitud;

    @Column(name = "estado", columnDefinition = "boolean default 0")
    private boolean estado;

    @Column(name = "estadoCorreo", columnDefinition = "int default 0")
    private int estadoCorreo;

    private String numeroRegistro;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detenido_id", referencedColumnName = "id")
    private Detenido detenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne(mappedBy = "solicitud")
    private estadoFicha estadoFicha;

    public Solicitudes() {
        estado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Detenido getDetenido() {
        return detenido;
    }

    public void setDetenido(Detenido detenido) {
        this.detenido = detenido;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public estadoFicha getEstadoFicha() {
        return estadoFicha;
    }

    public void setEstadoFicha(estadoFicha estadoFicha) {
        this.estadoFicha = estadoFicha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getEstadoCorreo() {
        return estadoCorreo;
    }

    public void setEstadoCorreo(int estadoCorreo) {
        this.estadoCorreo = estadoCorreo;
    }

   

}
