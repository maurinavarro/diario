package com.secc_sistema.admision_cupo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Service.IDatosJudicialesService;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;

@RestController
@RequestMapping("/api/detenidos")
public class apiDetenidosController {

    @Autowired
    private IDetenidoService detenidoService;

    @Autowired
    IDatosJudicialesService datosJudicialesService;

  
    @GetMapping(value = "/graficos", produces = { "application/json" })
    public @ResponseBody Map<String, Object> obtenerGraficos() {
        Map<String, Object> graficos = new HashMap<>();

        // Obtener datos para el primer gráfico (fuerza de Detenido)
        List<Detenido> detenidos = detenidoService.buscarTodo();
        List<Integer> fuerzas = detenidos.stream()
                .map(detenido -> {
                    if ("si".equalsIgnoreCase(detenido.getFuerza())) {
                        return 1; 
                    } else {
                        return 0; 
                    }
                })
                .collect(Collectors.toList());
        graficos.put("graficoFuerza", fuerzas);

        // Obtener datos para el segundo gráfico (situacionLegal de DatosJudiciales)
        List<DatosJudiciales> datosJudiciales = datosJudicialesService.buscarTodo();
        List<Integer> situacionesLegales = datosJudiciales.stream()
                .map(dj -> {
                    if ("condenado".equalsIgnoreCase(dj.getSituacionLegal())) {
                        return 1; 
                    } else {
                        return 2; 
                    }
                })
                .collect(Collectors.toList());
        graficos.put("graficoSituacionLegal", situacionesLegales);

        return graficos;
    }

}