package com.secc_sistema.admision_cupo.Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class errorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Obtenemos el código de error de la solicitud
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");

        // Manejar el código de error y asignar mensajes de error personalizados
        String errorMessage = "Ha ocurrido un error inesperado en la aplicación.";
        if (statusCode != null) {
            switch (statusCode) {
                case 404:
                    errorMessage = "La página que buscas no se encontró.";
                    break;
                case 500:
                    errorMessage = "Se ha producido un error interno en el servidor.";
                    break;
                // Agrega más casos según tus necesidades
            }
        }

        // Agregar el mensaje de error al modelo para mostrarlo en la vista
        model.addAttribute("error", errorMessage);

        return "error";
    }
}

