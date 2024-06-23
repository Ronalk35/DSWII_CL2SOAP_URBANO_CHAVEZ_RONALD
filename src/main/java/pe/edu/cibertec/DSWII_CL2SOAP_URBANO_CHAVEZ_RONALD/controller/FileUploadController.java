package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service.FileStorageService;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    private final List<String> allowedExtensions = Arrays.asList("pdf", "png", "docx");

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload-multiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            return ResponseEntity.badRequest().body("Debes subir exactamente 3 archivos.");
        }

        for (MultipartFile file : files) {
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            if (extension == null || !allowedExtensions.contains(extension.toLowerCase())) {
                return ResponseEntity.badRequest().body("Invalid file extension. Allowed extensions are: pdf, png, docx.");
            }

            fileStorageService.storeFile(file);
        }

        return ResponseEntity.ok("Archivos cargados exitosamente.");
    }

    @PostMapping("/upload-single")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (extension == null || !allowedExtensions.contains(extension.toLowerCase())) {
            return ResponseEntity.badRequest().body("Extensión de archivo inválida. Las extensiones permitidas son: pdf, png, docx");
        }

        if (file.getSize() > 25 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("El tamaño del archivo excede el tamaño máximo permitido de 25 MB.");
        }

        fileStorageService.storeFile(file);

        return ResponseEntity.ok("Archivos cargados exitosamente.");
    }
}
