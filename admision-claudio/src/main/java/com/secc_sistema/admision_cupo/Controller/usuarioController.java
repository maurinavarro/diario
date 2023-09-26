package com.secc_sistema.admision_cupo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.secc_sistema.admision_cupo.Model_Entities.Fuerza;
import com.secc_sistema.admision_cupo.Model_Entities.Permiso;
import com.secc_sistema.admision_cupo.Model_Entities.Usuario;
import com.secc_sistema.admision_cupo.Service.IFuerzaService;
import com.secc_sistema.admision_cupo.Service.IPermisoService;
import com.secc_sistema.admision_cupo.Service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
@SessionAttributes("usuario")
public class usuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IPermisoService permisoService;

    @Autowired
    IFuerzaService fuerzaService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/listado")
    public String listado(Model model) {

        model.addAttribute("titulo", "Usuarios Registrados");
        model.addAttribute("usuarios", usuarioService.buscarTodos());

        return "usuarios/list";

    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("titulo", "Registrar Usuario");
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("permisos", permisoService.buscarTodo());

        return "usuarios/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Usuario usuario, BindingResult result, @RequestParam("rol") Long idRol,
            @RequestParam("fuer") Long idFuer,
            Model model, RedirectAttributes msgFlash, SessionStatus status) {

        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            model.addAttribute("danger", "Corrija los Errores...");
            return "usuarios/form";
        }

        // Verificar si el objeto Usuario es nuevo (sin id) o existente (con id)
        if (usuario.getId() == null) {
            usuario.setClave(passwordEncoder.encode(usuario.getClave())); // Solo en nuevo usuario
        }

        usuario.setPermiso(permisoService.buscarPorId(idRol));
        usuario.setFuerza(fuerzaService.buscarPorId(idFuer));
        usuarioService.guardar(usuario);

        msgFlash.addFlashAttribute("success", "Usuario Registrado Correctamente.");
        status.setComplete();

        return "redirect:/usuarios/listado";
    }

    @GetMapping("/borrar/{id}")
    public String deshabOrHabUsuario(@PathVariable("id") Long id, RedirectAttributes msgFlash) {

        Usuario usuario = usuarioService.buscarPorId(id);
        usuario.setActivo(!usuario.isActivo());
        usuarioService.guardar(usuario);
        msgFlash.addFlashAttribute("warning", usuario.isActivo() ? "Usuario Habilitado" : "Usuario Deshabilitado");

        return "redirect:/usuarios/listado";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {

        Usuario usuario = usuarioService.buscarPorId(id);

        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("usuario", usuario);

        return "usuarios/form";
    }

    @ModelAttribute("permisos")
    public List<Permiso> getPermisos() {
        return permisoService.buscarTodo();
    }

    @ModelAttribute("fuerzas")
    public List<Fuerza> getCategorias() {
        return fuerzaService.buscarTodo();
    }

}
