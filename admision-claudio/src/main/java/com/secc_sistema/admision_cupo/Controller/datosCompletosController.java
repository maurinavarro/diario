package com.secc_sistema.admision_cupo.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;
import com.secc_sistema.admision_cupo.Service.ISolicitudesService;

@Controller

public class datosCompletosController {

    @Autowired
    IDetenidoService detenidoService;

    @Autowired
    ISolicitudesService solicitudesService;

    private Solicitudes solicitud = new Solicitudes();

    @PostMapping("/detenidos/{idDetenido}/enviarSolicitud")
    public String enviarSolicitud(@PathVariable Long idDetenido) {
        Detenido detenido = detenidoService.buscarPorId(idDetenido);
    
        if (detenido != null && detenido.getDatosJudiciales() != null && detenido.getDatosCriminologico() != null) {
    
            // Buscar la solicitud asociada al detenido
            Solicitudes solicitud = solicitudesService.buscarPorDetenido(detenido);
    
            // Verificar si la solicitud existe
            if (solicitud != null) {
                solicitud.setEstado(true);
                solicitud.setFechaSolicitud(LocalDateTime.now());
    
                // Guardar la solicitud actualizada en la base de datos
                solicitudesService.guardar(solicitud);
            } else {
                return "redirect:/error";
            }
    
           
            return "redirect:/home";
        } else {
            // Si alguno de los datos es nulo, redirigir a una página de error 
            return "redirect:/error";
        }
    }
    
}
