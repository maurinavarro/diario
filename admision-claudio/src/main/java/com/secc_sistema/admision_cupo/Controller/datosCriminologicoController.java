package com.secc_sistema.admision_cupo.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secc_sistema.admision_cupo.Model_Entities.DatosCriminologico;
import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;
import com.secc_sistema.admision_cupo.Service.IDatosCriminologicosService;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;
import com.secc_sistema.admision_cupo.Service.IEstadoFichaService;
import com.secc_sistema.admision_cupo.Service.ISolicitudesService;

@Controller
@RequestMapping("detenidos/{id}/datosCriminologicos")
@SessionAttributes("datoCriminologico")
public class datosCriminologicoController {

    @Autowired
    IDatosCriminologicosService datosCriminologicosService;

    @Autowired
    IDetenidoService detenidoService;

    @Autowired
    ISolicitudesService solicitudesService;

    @Autowired
    IEstadoFichaService estadoFichaService;

    
    @GetMapping("/listado")
    public String listado(Model model) {

        model.addAttribute("titulo", "Datos Criminologicos");
        model.addAttribute("datosCriminologicos", datosCriminologicosService.buscarTodo());

        return "datosCriminologicos/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(@PathVariable("id") Long detenidoId, Model model) {
        System.out.println("ID del detenido recibido en el controlador Criminologico nuevo: " + detenidoId);

        Detenido detenido = detenidoService.buscarPorId(detenidoId);
        if (detenido == null) {
            throw new IllegalArgumentException("Detenido no válido");
        }

        // Verificar si los datos judiciales están completos antes de permitir el acceso
        Solicitudes solicitud = solicitudesService.buscarPorDetenido(detenido);
        if (solicitud != null && solicitud.getEstadoFicha() != null
                && !solicitud.getEstadoFicha().getDatosJudiciales()) {
            model.addAttribute("datosJudicialesIncompletos", true);

            return "redirect:/detenidos/" + detenidoId + "/datosJudiciales/nuevo";
        }

        DatosCriminologico datosCriminologicos = new DatosCriminologico();
        datosCriminologicos.setDetenido(detenido);

        model.addAttribute("titulo", "CARGAR DATOS CRIMINOLOGICOS");
        model.addAttribute("datoCriminologico", datosCriminologicos);
        model.addAttribute("yourDetenidoId", detenidoId);

        return "datosCriminologicos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@PathVariable("id") Long detenidoId,
            @ModelAttribute("datoCriminologico") @Valid DatosCriminologico datosCriminologico,
            BindingResult result, RedirectAttributes msgFlash, SessionStatus status,
            Model model) {

        if (result.hasErrors()) {
            // Si hay errores de validación, regresamos al formulario con los mensajes de
            // error
            model.addAttribute("titulo", "CARGAR DATOS CRIMINOLOGICOS");
            model.addAttribute("yourDetenidoId", detenidoId);
            return "datosCriminologicos/form";
        }

        // Asignar el detenido al objeto DatosCriminologico
        Detenido detenido = detenidoService.buscarPorId(detenidoId);
        datosCriminologico.setDetenido(detenido);

        // Guardar los datos criminológicos
        datosCriminologicosService.guardar(datosCriminologico);

        // Después de guardar los datos criminológicos
        Solicitudes solicitud = solicitudesService.buscarPorDetenido(detenido);
        if (solicitud != null && solicitud.getEstadoFicha() != null) {
            estadoFicha estadoFicha = solicitud.getEstadoFicha();
            estadoFicha.setDatosCriminologicos(true);
            estadoFichaService.guardar(estadoFicha);
        }

        msgFlash.addFlashAttribute("success", "Guardado Correctamente.");
        status.setComplete();

      
        return "redirect:/detenidos/" + detenidoId + "/detalle";
    }

    
}
