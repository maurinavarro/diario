package com.secc_sistema.admision_cupo.Model_Entities;

public class UnificarDatos {
    
    private Detenido detenido;

    private DatosJudiciales datosJudiciales;

    private Solicitudes solicitudes;  

    private String nombreUsuario;

    private String unidadSolicitante;

    private String rutaImagen;

    private int estadoCorreo;

    private boolean estado;

    public Detenido getDetenido() {
        return detenido;
    }
    public void setDetenido(Detenido detenido) {
        this.detenido = detenido;
    }
    public DatosJudiciales getDatosJudiciales() {
        return datosJudiciales;
    }
    public void setDatosJudiciales(DatosJudiciales datosJudiciales) {
        this.datosJudiciales = datosJudiciales;
    }
    
    public Solicitudes getSolicitudes() {
        return solicitudes;
    }
    public void setSolicitudes(Solicitudes solicitudes) {
        this.solicitudes = solicitudes;
    }
   
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public String getRutaImagen() {
        return rutaImagen;
    }
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    public String getUnidadSolicitante() {
        return unidadSolicitante;
    }
    public void setUnidadSolicitante(String unidadSolicitante) {
        this.unidadSolicitante = unidadSolicitante;
    }

    public int getEstadoCorreo() {
        return estadoCorreo;
    }
    public void setEstadoCorreo(int estadoCorreo) {
        this.estadoCorreo = estadoCorreo;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
