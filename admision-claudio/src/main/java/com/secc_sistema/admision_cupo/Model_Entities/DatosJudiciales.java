package com.secc_sistema.admision_cupo.Model_Entities;

import javax.persistence.Column;
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


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "datosJudiciales")
public class DatosJudiciales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Este campo es Obligatorio")
    @Size(max = 15)
    @Column(name = "oficio")
    private String oficio;

    @NotBlank(message = "Este campo es Obligatorio")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String fechaDetencion;

    @NotBlank(message = "Este campo es Obligatorio")
    private String causa;

    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "juzgadoInterviniente")
    private String juzgadoInterviniente;

    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "circunscripcionJudicial")
    private String circunscripcionJudicial;

    @NotBlank(message = "Este campo es Obligatorio")
    @Column(name = "situacionLegal")
    private String situacionLegal;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    @Column(name = "camaraCondenatoria")
    private String camaraCondenatoria;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fechaCondena")
    private String fechaCondena;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    @Column(name = "condenaImpuesta")
    private String condenaImpuesta;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String sentencia;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String ReduccionPena;

    @NotBlank(message = "Este campo es Obligatorio")
    private String reincidente;

    @NotBlank(message = "Este campo es Obligatorio")
    private String otraCausa;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String fechaLibertadAgotamiento;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String libertadCondicional;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String libertadAsistida;

    @NotBlank(message = "Este campo es Obligatorio", groups = { ProcesadoGroup.class, NoProcesadoGroup.class })
    private String suspencionBeneficio;

    @Column(name = "archivoOficio")
    private String archivoOficio;

    @Column(name = "archivoSentencia")
    private String archivoSentencia;

    @Column(name = "archivoComputo")
    private String archivoComputo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detenido_id", referencedColumnName = "id")
    private Detenido detenido;

    public interface ProcesadoGroup {
        // Grupo para campos que deben ser validados cuando la situación legal es "procesado"
    }

    public interface NoProcesadoGroup {
        // Grupo para campos que deben ser validados cuando la situación legal es "no procesado"
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public String getFechaDetencion() {
        return fechaDetencion;
    }

    public void setFechaDetencion(String fechaDetencion) {
        this.fechaDetencion = fechaDetencion;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getJuzgadoInterviniente() {
        return juzgadoInterviniente;
    }

    public void setJuzgadoInterviniente(String juzgadoInterviniente) {
        this.juzgadoInterviniente = juzgadoInterviniente;
    }

    public String getCircunscripcionJudicial() {
        return circunscripcionJudicial;
    }

    public void setCircunscripcionJudicial(String circunscripcionJudicial) {
        this.circunscripcionJudicial = circunscripcionJudicial;
    }

    public String getCamaraCondenatoria() {
        return camaraCondenatoria;
    }

    public void setCamaraCondenatoria(String camaraCondenatoria) {
        this.camaraCondenatoria = camaraCondenatoria;
    }

    public String getCondenaImpuesta() {
        return condenaImpuesta;
    }

    public void setCondenaImpuesta(String condenaImpuesta) {
        this.condenaImpuesta = condenaImpuesta;
    }

    public String getSentencia() {
        return sentencia;
    }

    public void setSentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    public String getReduccionPena() {
        return ReduccionPena;
    }

    public void setReduccionPena(String reduccionPena) {
        ReduccionPena = reduccionPena;
    }

    public String getReincidente() {
        return reincidente;
    }

    public void setReincidente(String reincidente) {
        this.reincidente = reincidente;

    }

    public String getOtraCausa() {
        return otraCausa;
    }

    public void setOtraCausa(String otraCausa) {
        this.otraCausa = otraCausa;
    }

    public String getFechaLibertadAgotamiento() {
        return fechaLibertadAgotamiento;
    }

    public void setFechaLibertadAgotamiento(String fechaLibertadAgotamiento) {
        this.fechaLibertadAgotamiento = fechaLibertadAgotamiento;
    }

    public String getLibertadCondicional() {
        return libertadCondicional;
    }

    public void setLibertadCondicional(String libertadCondicional) {
        this.libertadCondicional = libertadCondicional;
    }

    public String getLibertadAsistida() {
        return libertadAsistida;
    }

    public void setLibertadAsistida(String libertadAsistida) {
        this.libertadAsistida = libertadAsistida;
    }

    public String getSuspencionBeneficio() {
        return suspencionBeneficio;
    }

    public void setSuspencionBeneficio(String suspencionBeneficio) {
        this.suspencionBeneficio = suspencionBeneficio;
    }

    public Detenido getDetenido() {
        return detenido;
    }

    public void setDetenido(Detenido detenido) {
        this.detenido = detenido;
    }

    public String getFechaCondena() {
        return fechaCondena;
    }

    public void setFechaCondena(String fechaCondena) {
        this.fechaCondena = fechaCondena;
    }

    public String getArchivoOficio() {
        return archivoOficio;
    }

    public void setArchivoOficio(String archivoOficio) {
        this.archivoOficio = archivoOficio;
    }

    public String getArchivoSentencia() {
        return archivoSentencia;
    }

    public void setArchivoSentencia(String archivoSentencia) {
        this.archivoSentencia = archivoSentencia;
    }

    public String getArchivoComputo() {
        return archivoComputo;
    }

    public void setArchivoComputo(String archivoComputo) {
        this.archivoComputo = archivoComputo;
    }

    public String getSituacionLegal() {
        return situacionLegal;
    }

    public void setSituacionLegal(String situacionLegal) {
        this.situacionLegal = situacionLegal;
    }

}
