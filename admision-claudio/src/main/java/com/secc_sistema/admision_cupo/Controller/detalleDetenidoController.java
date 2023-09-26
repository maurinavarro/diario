package com.secc_sistema.admision_cupo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Service.IDatosCriminologicosService;
import com.secc_sistema.admision_cupo.Service.IDatosJudicialesService;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;


@Controller
public class detalleDetenidoController {


    @Autowired
    IDetenidoService detenidoService;

    @Autowired
    IDatosCriminologicosService datosCriminologicosService;

    @Autowired
    IDatosJudicialesService datosJudicialesService;

    @GetMapping("/detenidos/{idDetenido}/detalle")
    public String mostrarDetalleDetenido(@PathVariable Long idDetenido, Model model) {
       
        Detenido detenido = detenidoService.buscarPorId(idDetenido);
    
        // Asegurarse de que el Detenido y sus relaciones (datos judiciales y criminológicos) no sean nulos
        if (detenido != null && detenido.getDatosJudiciales() != null && detenido.getDatosCriminologico() != null) {
            model.addAttribute("detenido", detenido);
            return "detalleDetenido";
        } else {
            // Si alguno de los datos es nulo, redirigir a una página de error o manejar el caso en consecuencia
            return "redirect:/error";
        }
    }

    
}
