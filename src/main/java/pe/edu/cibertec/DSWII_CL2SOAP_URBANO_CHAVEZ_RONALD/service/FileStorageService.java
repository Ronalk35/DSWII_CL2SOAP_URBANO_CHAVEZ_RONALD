package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final Path fileStorageLocation = Paths.get("file_storage").toAbsolutePath().normalize();

    public FileStorageService() {
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("No se pudo crear el directorio donde se almacenarán los archivos cargados.", ex);
        }
    }

    public void storeFile(MultipartFile file) {
        try {
            Path targetLocation = this.fileStorageLocation.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), targetLocation);
        } catch (IOException ex) {
            throw new RuntimeException("No se pudo almacenar el archivo" + file.getOriginalFilename() + ". Inténtalo de nuevo!", ex);
        }
    }
}
