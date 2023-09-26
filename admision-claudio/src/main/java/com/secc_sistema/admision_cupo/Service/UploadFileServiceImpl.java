package com.secc_sistema.admision_cupo.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

    public final static String UPLOADS_FOLDER = "documentos";

    @Override
    public Resource load(String filename) throws MalformedURLException {
        Path pathFoto = getPath(filename);
        log.info("Path foto: " + pathFoto);
        Resource recurso = null;

        recurso = new UrlResource(pathFoto.toUri());
        if (!recurso.exists() || !recurso.isReadable()) {
            throw new RuntimeException("Error: no se pudo encontrar la imagen " + pathFoto.toString());
        }

        return recurso;
    }

    @Override
    public String copy(MultipartFile file) throws IOException {
        String uniqueFilename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path rootPath = getPath(uniqueFilename);

        log.info("rootPath: " + rootPath); // Path relativo al proyecto

        // byte[] bytes = foto.getBytes();
        // Path rutaCompleta = Paths.get(rootPath + "//" +
        // foto.getOriginalFilename());
        // Files.write(rutaCompleta, bytes);

        // Se puede usar write también...
        Files.copy(file.getInputStream(), rootPath);

        return uniqueFilename;
    }

    @Override
    public boolean delete(String filename) {

        Path rootPath = getPath(filename);
        File archivo = rootPath.toFile();

        if (archivo.exists() && archivo.canRead()) {
            if (archivo.delete()) {
                return true;
            }
        }
        return false;
    }

    public Path getPath(String filename) {
        return Paths.get(UPLOADS_FOLDER).resolve(filename).toAbsolutePath();
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(Paths.get(UPLOADS_FOLDER).toFile());
    }

    @Override
    public void init() throws IOException {
        Files.createDirectory(Paths.get(UPLOADS_FOLDER));
    }

    @Override
    public String guardarArchivo(MultipartFile archivo, String nombreDetenido, Long idDetenido) throws IOException {
        // Generar un nombre único para el archivo
        String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename();

        // Obtener la ruta completa de la carpeta del detenido
        String carpetaDetenido = UPLOADS_FOLDER + File.separator + nombreDetenido + "-" + idDetenido;
        Path rutaCompleta = Paths.get(carpetaDetenido).resolve(nombreArchivo).toAbsolutePath();

        // Crear la estructura de carpetas si no existe
        Files.createDirectories(rutaCompleta.getParent());

        // Guardar los bytes del archivo en la ruta completa
        Files.write(rutaCompleta, archivo.getBytes());

        return nombreArchivo;
    }

}