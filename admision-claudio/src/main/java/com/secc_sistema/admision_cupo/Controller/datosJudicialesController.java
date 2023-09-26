package com.secc_sistema.admision_cupo.Controller;

import java.nio.file.Paths;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;
import com.secc_sistema.admision_cupo.Service.IDatosJudicialesService;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;
import com.secc_sistema.admision_cupo.Service.IEstadoFichaService;
import com.secc_sistema.admision_cupo.Service.ISolicitudesService;
import com.secc_sistema.admision_cupo.Service.IUploadFileService;

@Controller
@RequestMapping("/detenidos/{id}/datosJudiciales")
@SessionAttributes("datoJudicial")
public class datosJudicialesController {

    @Autowired
    private IDatosJudicialesService datosJudicialesService;

    @Autowired
    private IDetenidoService detenidoService;

    @Autowired
    ISolicitudesService solicitudesService;

    @Autowired
    IEstadoFichaService estadoFichaService;

    @Autowired
    IUploadFileService uploadFileService;

    @GetMapping("/nuevo")
    public String nuevo(@PathVariable("id") Long detenidoId, Model model) {
        System.out.println("ID del detenido recibido en el controlador nuevo: " + detenidoId);

        Detenido detenido = detenidoService.buscarPorId(detenidoId);
        if (detenido == null) {
            throw new IllegalArgumentException("Detenido no válido");
        }

        DatosJudiciales datosJudiciales = new DatosJudiciales();
        datosJudiciales.setDetenido(detenido);

        model.addAttribute("titulo", "CARGAR DATOS JUDICIALES");
        model.addAttribute("datoJudicial", datosJudiciales);
        model.addAttribute("yourDetenidoId", detenidoId);

        return "datosJudiciales/form";
    }

    @PostMapping("/guardar")
    public String guardarDatosJudiciales(@PathVariable("id") Long detenidoId, @Valid DatosJudiciales datosJudiciales,
            RedirectAttributes msgFlash, SessionStatus status, BindingResult result, Model model,
            @NotNull @RequestParam("file") MultipartFile archivoOficio,
            @RequestParam("file_1") MultipartFile archivoSentencia,
            @RequestParam("file_3") MultipartFile archivoComputo,
            @RequestParam("situacionLegal") String situacionLegal) {
        

        if (situacionLegal.equals("condenado") && (archivoSentencia.isEmpty() || archivoComputo.isEmpty())) {

            model.addAttribute("titulo", "CARGAR DATOS JUDICIALES");
            model.addAttribute("yourDetenidoId", detenidoId);
            model.addAttribute("errorArchivos",
                    "Los archivos de sentencia y computo son obligatorios para los condenados.");
            return "datosJudiciales/form";
        }

        if (archivoOficio.isEmpty()) {
            // Siempre se requiere el archivo de oficio.
            model.addAttribute("titulo", "CARGAR DATOS JUDICIALES");
            model.addAttribute("yourDetenidoId", detenidoId);
            model.addAttribute("errorArchivos", "El archivo de oficio es obligatorio.");
            return "datosJudiciales/form";
        }

        if (result.hasErrors()) {

            model.addAttribute("titulo", "CARGAR DATOS JUDICIALES");
            model.addAttribute("yourDetenidoId", detenidoId);
            return "datosJudiciales/form";
        }

        try {
            Detenido detenido = detenidoService.buscarPorId(detenidoId);
            datosJudiciales.setDetenido(detenido);

            // Obtener la carpeta del detenido
            String carpetaDetenido = detenido.getNombreApellido() + "-" + detenidoId;

            String subcarpeta = "datosJudiciales";
            String rutaCompletaSubcarpeta = Paths.get(carpetaDetenido, subcarpeta).toString();

            // Guardar los archivos PDF en la subcarpeta usando uploadFileService
            String nombreArchivoOficio = uploadFileService.guardarArchivo(archivoOficio, rutaCompletaSubcarpeta,
                    detenidoId);
            String nombreArchivoSentencia = uploadFileService.guardarArchivo(archivoSentencia, rutaCompletaSubcarpeta,
                    detenidoId);
            String nombreArchivoComputo = uploadFileService.guardarArchivo(archivoComputo, rutaCompletaSubcarpeta,
                    detenidoId);

            // Guardar los nombres de los archivos en la base de datos
            datosJudiciales.setArchivoOficio(nombreArchivoOficio);
            datosJudiciales.setArchivoSentencia(nombreArchivoSentencia);
            datosJudiciales.setArchivoComputo(nombreArchivoComputo);

            datosJudicialesService.guardar(datosJudiciales);

            Solicitudes solicitud = solicitudesService.buscarPorDetenido(detenido);
            if (solicitud != null && solicitud.getEstadoFicha() != null) {
                estadoFicha estadoFicha = solicitud.getEstadoFicha();
                estadoFicha.setDatosJudiciales(true);
                estadoFichaService.guardar(estadoFicha);
            }

            msgFlash.addFlashAttribute("success", "Guardado Correctamente.");
            status.setComplete();

            return "redirect:/detenidos/" + detenidoId + "/datosCriminologicos/nuevo";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("danger", "Ocurrió un error al guardar los datos judiciales.");
            return "datosJudiciales/form";
        }
    }

}
