package com.secc_sistema.admision_cupo.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.secc_sistema.admision_cupo.Model_Entities.DatosJudiciales;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.EstadoFormulario;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Model_Entities.UnificarDatos;
import com.secc_sistema.admision_cupo.Model_Entities.Usuario;
import com.secc_sistema.admision_cupo.Model_Entities.estadoFicha;
import com.secc_sistema.admision_cupo.Service.IDatosJudicialesService;
import com.secc_sistema.admision_cupo.Service.IDetenidoService;
import com.secc_sistema.admision_cupo.Service.IEstadoFichaService;
import com.secc_sistema.admision_cupo.Service.ISolicitudesService;
import com.secc_sistema.admision_cupo.Service.IUnidadService;
import com.secc_sistema.admision_cupo.Service.IUsuarioService;

@Controller
public class homeController {

    @Autowired
    IUnidadService unidadService;

    @Autowired
    IDetenidoService detenidoService;

    @Autowired
    IDatosJudicialesService datosJudicialesService;

    @Autowired
    ISolicitudesService solicitudesService;

    @Autowired
    IEstadoFichaService estadoFichaService;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    private JavaMailSender mail;

    @GetMapping({ "/", "/home" })
    public String home(Model model) {

        model.addAttribute("titulo", "Admisión de Detenidos");
        model.addAttribute("unidades", unidadService.buscarTodo());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (!authorities.isEmpty()) {
            String rolUsuario = authorities.iterator().next().getAuthority();
            model.addAttribute("rolUsuario", rolUsuario);
        } else {
            model.addAttribute("rolUsuario", "rol_por_defecto");
        }

        List<Detenido> detenidos = detenidoService.buscarTodo();
        List<DatosJudiciales> datosJudiciales = datosJudicialesService.buscarTodo();
        List<Solicitudes> solicitudes = solicitudesService.buscarTodos();
        List<Usuario> usuarios = usuarioService.buscarTodos();

        List<UnificarDatos> dataList = new ArrayList<>();

        for (Detenido detenido : detenidos) {
            UnificarDatos unificarDatos = new UnificarDatos();
            unificarDatos.setDetenido(detenido);

            DatosJudiciales datosJudicialesMatched = datosJudiciales.stream()
                    .filter(dj -> dj.getDetenido().getId().equals(detenido.getId()))
                    .findFirst().orElse(null);
            unificarDatos.setDatosJudiciales(datosJudicialesMatched);

            // Obtener la solicitud relacionada con el detenido actual
            Solicitudes solicitudMatched = solicitudes.stream()
                    .filter(s -> s.getDetenido().getId().equals(detenido.getId()))
                    .findFirst().orElse(null);

            if (solicitudMatched != null && solicitudMatched.getUsuario() != null) {
                String nombreUsuarioGenerador = solicitudMatched.getUsuario().getNombre();
                unificarDatos.setNombreUsuario(nombreUsuarioGenerador);

                String unidadSolicitante = solicitudMatched.getUsuario().getUnidadSoliciante();
                unificarDatos.setUnidadSolicitante(unidadSolicitante);
                int estadoCorreo = solicitudMatched.getEstadoCorreo();
                unificarDatos.setEstadoCorreo(estadoCorreo);
                boolean estado = solicitudMatched.isEstado();
                unificarDatos.setEstado(estado);
            }

            String nombreDetenido = detenido.getNombreApellido();
            String idDetenido = detenido.getId().toString();
            String urlImagen = "/documentos/" + nombreDetenido + "-" + idDetenido + "/" + detenido.getImagen();
            unificarDatos.setRutaImagen(urlImagen);
            dataList.add(unificarDatos);
        }

        model.addAttribute("dataList", dataList);
        model.addAttribute("authentication", authentication);

        List<estadoFicha> estadosFichas = estadoFichaService.buscarTodo();
        List<EstadoFormulario> estadoFormularios = new ArrayList<>();

        for (estadoFicha estado : estadosFichas) {
            EstadoFormulario estadoFormulario = new EstadoFormulario();

            Detenido detenido = estado.getSolicitud().getDetenido();

            if (detenido != null) {
                estadoFormulario.setIdDetenido(detenido.getId());
                estadoFormulario.setNombreDetenido(detenido.getNombreApellido());
            } else {
                estadoFormulario.setIdDetenido(-1L); // ID alternativo
                estadoFormulario.setNombreDetenido("Detenido no encontrado");
            }

            estadoFormulario.setEstadoDetenido(estado.getDetenido() ? "Completado" : "Pendiente");
            estadoFormulario.setEstadoDatosJudiciales(estado.getDatosJudiciales() ? "Completado" : "Pendiente");
            estadoFormulario.setEstadoDatosCriminologicos(estado.getDatosCriminologicos() ? "Completado" : "Pendiente");

            estadoFormularios.add(estadoFormulario);
        }

        model.addAttribute("estadoFormularios", estadoFormularios);

        return "home";
    }

    @PostMapping("/aceptar-solicitud/{idRegistro}")
    public String aceptarSolicitud(@PathVariable Long idRegistro) {
        Solicitudes solicitud = solicitudesService.buscarPorId(idRegistro);
        if (solicitud != null) {
            Usuario usuarioSolicitante = solicitud.getUsuario();
            System.out.println(
                    "Correo electrónico del usuario solicitante (Aceptar Solicitud): " + usuarioSolicitante.getEmail());
            solicitudesService.aceptarSolicitud(idRegistro);
        } else {
            // Manejar el caso en el que la solicitud no existe
            System.err.println("La solicitud con ID " + idRegistro + " no existe.");
        }
        return "redirect:/home";
    }

    @PostMapping("/rechazar-solicitud/{idRegistro}")
    public String rechazarSolicitud(@PathVariable Long idRegistro) {
        Solicitudes solicitud = solicitudesService.buscarPorId(idRegistro);
        if (solicitud != null) {
            Usuario usuarioSolicitante = solicitud.getUsuario();
            System.out.println("Correo electrónico del usuario solicitante (Rechazar Solicitud): "
                    + usuarioSolicitante.getEmail());
            solicitudesService.rechazarSolicitud(idRegistro);
        } else {
            // Manejar el caso en el que la solicitud no existe
            System.err.println("La solicitud con ID " + idRegistro + " no existe.");
        }
        return "redirect:/home";
    }

    @GetMapping("/consultas")
    public String consultas(Model model) {
        model.addAttribute("titulo", "Admisión de Detenidos");
        return "consultas";
    }

     @GetMapping("/graficos")
    public String grafico(Model model) {
        model.addAttribute("titulo", "Estadisticas");
        return "graficos";
    }
}
