package com.secc_sistema.admision_cupo.Controller;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.nio.file.Files;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Model_Entities.Usuario;
import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;
import com.secc_sistema.admision_cupo.Service.IEstadoFichaService;
import com.secc_sistema.admision_cupo.Service.ISolicitudesService;
import com.secc_sistema.admision_cupo.Service.IUploadFileService;
import com.secc_sistema.admision_cupo.Service.IUsuarioService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/detenidos")
@SessionAttributes("detenido")
public class internoController {

    @Autowired
    IDetenidoService detenidoService;

    @Autowired
    ISolicitudesService solicitudesService;

    @Autowired
    IEstadoFichaService estadoFichaService;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IUploadFileService uploadFileService;

    @GetMapping("/listado")
    public String listado(Model model) {

        model.addAttribute("titulo", "Listado de Detenidos");
        model.addAttribute("detenidos", detenidoService.buscarTodo());

        return "detenidos/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("titulo", "CARGAR NUEVO DETENIDO");
        model.addAttribute("detenido", new Detenido());

        return "detenidos/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Detenido detenido, BindingResult result,
            Model model,
            @NotNull @RequestParam("file") MultipartFile imagen,
            RedirectAttributes msgFlash, SessionStatus status) {

        if (imagen.isEmpty()) {
            // Mostrar mensaje de error en el formulario actual
            model.addAttribute("titulo", "CARGAR NUEVO DETENIDO");
            model.addAttribute("errorArchivos", "la Carga de la Foto es obligatoria.");
            return "detenidos/form";
        }

        if (result.hasErrors()) {
            model.addAttribute("danger", "Corrija los Errores...");
            return "detenidos/form";
        }

        try {
            Detenido detenidoGuardado = detenidoService.guardar(detenido);

            Long idDetenido = detenidoGuardado.getId();
            String nombreDetenido = detenido.getNombreApellido();
            String idDetenidoStr = String.valueOf(idDetenido);

            // Nueva ruta de almacenamiento de imágenes
            String carpetaDetenido = "documentos/" + nombreDetenido + "-" + idDetenidoStr;
            Files.createDirectories(Paths.get(carpetaDetenido));

            if (!imagen.isEmpty()) {
                String nombreImagen = uploadFileService.guardarArchivo(imagen, nombreDetenido, idDetenido);
                detenidoGuardado.setImagen(nombreImagen);
                detenidoService.guardar(detenidoGuardado);
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String nombreUsuario = authentication.getName();

            Usuario usuario = usuarioService.buscarPorNombre(nombreUsuario);

            Solicitudes solicitud = new Solicitudes();
            solicitud.setDetenido(detenidoGuardado);
            solicitud.setUsuario(usuario);
            solicitud.setFechaSolicitud(LocalDateTime.now());

            solicitudesService.guardar(solicitud);

            estadoFicha estadoFicha = new estadoFicha();
            estadoFicha.setSolicitud(solicitud);
            estadoFicha.setDetenido(true);

            estadoFichaService.guardar(estadoFicha);

            msgFlash.addFlashAttribute("success", "Guardado Correctamente.");
            status.setComplete();

            return "redirect:/detenidos/" + detenidoGuardado.getId() + "/datosJudiciales/nuevo";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("danger", "Ocurrió un error al guardar los archivos.");
            return "detenidos/form";
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {

        Detenido detenido = detenidoService.buscarPorId(id);

        model.addAttribute("titulo", "Nuevo Detenido");
        model.addAttribute("detenido", detenido);

        return "detenidos/form";
    }

   
}
