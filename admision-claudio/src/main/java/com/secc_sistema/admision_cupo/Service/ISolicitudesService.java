package com.secc_sistema.admision_cupo.Service;

import java.util.List;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;

public interface ISolicitudesService {

    public void guardar(Solicitudes solicitudes);

    public List<Solicitudes> buscarTodos();

    public List<Solicitudes> buscarPor(String criterio);

    public Solicitudes buscarPorId(Long id);

    Solicitudes buscarPorDetenido(Detenido detenido);

    public void aceptarSolicitud(Long idSolicitud);

    public void rechazarSolicitud(Long idSolicitud);

}
