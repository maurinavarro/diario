package com.secc_sistema.admision_cupo.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.internet.MimeMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.secc_sistema.admision_cupo.Model_Entities.Detenido;
import com.secc_sistema.admision_cupo.Model_Entities.Solicitudes;
import com.secc_sistema.admision_cupo.Model_Entities.Usuario;
import com.secc_sistema.admision_cupo.Repository.ISolicitudesRepository;

@Service
public class SolicitudesServiceImpl implements ISolicitudesService {

    @Autowired
    ISolicitudesRepository solicitudesRespository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Transactional
    public void guardar(Solicitudes solicitudes) {
        solicitudesRespository.save(solicitudes);
    }

    @Override
    public List<Solicitudes> buscarTodos() {
        return solicitudesRespository.findAll();
    }

    @Override
    public List<Solicitudes> buscarPor(String criterio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
    }

    @Override
    public Solicitudes buscarPorId(Long id) {
        return solicitudesRespository.findById(id).orElse(null);
    }

    @Override
    public Solicitudes buscarPorDetenido(Detenido detenido) {
        return solicitudesRespository.findByDetenido(detenido);
    }

    @Override
    @Transactional
    public void aceptarSolicitud(Long idRegistro) {
        Solicitudes solicitud = solicitudesRespository.findById(idRegistro).orElse(null);
        if (solicitud != null) {
            // Lógica para aceptar la solicitud
            solicitud.setEstado(true);
            solicitud.setNumeroRegistro(generarNumeroRegistro());
            // Obtener el usuario que creó la solicitud
            Usuario usuarioSolicitante = solicitud.getUsuario();
            // Enviar correo electrónico de aceptación al usuario
            enviarCorreoAceptacion(usuarioSolicitante, solicitud);
            // Cambiar el estado de estadoCorreo a 1
            solicitud.setEstadoCorreo(1);
            // Guardar los cambios en la solicitud
            solicitudesRespository.save(solicitud);
        }
    }

    @Override
    @Transactional
    public void rechazarSolicitud(Long idRegistro) {
        Solicitudes solicitud = solicitudesRespository.findById(idRegistro).orElse(null);
        if (solicitud != null) {
            // Lógica para rechazar la solicitud
            solicitud.setEstado(false);
            // Obtener el usuario que creó la solicitud
            Usuario usuarioSolicitante = solicitud.getUsuario();
            // Enviar correo electrónico de rechazo al usuario
            enviarCorreoRechazo(usuarioSolicitante, solicitud);
            solicitud.setEstadoCorreo(2);
            // Guardar los cambios en la solicitud
            solicitudesRespository.save(solicitud);
        }
    }

    private String generarNumeroRegistro() {

        LocalDateTime now = LocalDateTime.now();
        String numeroRegistro = "R " + "- " + now.getYear() + now.getMonthValue() + now.getDayOfMonth()
                + now.getHour()
                + now.getMinute() + now.getSecond();
        return numeroRegistro;
    }

    private void enviarCorreoAceptacion(Usuario usuario, Solicitudes solicitud) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Obtiene el nombre del usuario actual que está aceptando la solicitud
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String nombreUsuarioActual = authentication.getName();

            helper.setFrom("cmarangoni8@gmail.com");
            helper.setTo(usuario.getEmail());
            helper.setSubject("Solicitud Aceptada");
            helper.setText(
                    "Su solicitud ha sido aceptada con éxito. Número de registro: " + solicitud.getNumeroRegistro() +
                            " La solicitud fue aceptada por el usuario: " + nombreUsuarioActual);

            // Envía el correo electrónico
            javaMailSender.send(message);

            // Registro de éxito en la consola
            System.out.println("Correo electrónico de aceptación enviado con éxito a: " + usuario.getEmail());
        } catch (Exception e) {
            // Manejo de excepciones en caso de error al enviar el correo
            e.printStackTrace();

            // Registro de error en la consola
            System.err.println("Error al enviar el correo electrónico de aceptación a: " + usuario.getEmail());
        }
    }

    private void enviarCorreoRechazo(Usuario usuario, Solicitudes solicitud) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

             // Obtiene el nombre del usuario actual que está aceptando la solicitud
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String nombreUsuarioActual = authentication.getName();

            helper.setFrom("cmarangoni8@gmail.com"); // Cambia el remitente a tu dirección de correo
            helper.setTo(usuario.getEmail()); // Utiliza la dirección de correo del usuario
            helper.setSubject("Solicitud Rechazada");
            helper.setText(
                    "Lamentablemente, su solicitud ha sido rechazada. Puede ponerse en contacto para obtener más información." +
                    " La solicitud fue aceptada por el usuario: " + nombreUsuarioActual);

            javaMailSender.send(message);

        } catch (Exception e) {
            // Manejo de excepciones en caso de error al enviar el correo
            e.printStackTrace();
        }
    }

}
