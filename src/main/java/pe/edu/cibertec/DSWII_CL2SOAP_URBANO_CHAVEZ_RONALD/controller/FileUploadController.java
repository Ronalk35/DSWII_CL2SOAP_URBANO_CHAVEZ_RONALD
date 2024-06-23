package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileUploadController {

    private final List<String> allowedExtensions = Arrays.asList("pdf", "png", "docx");

    @PostMapping("/upload-multiple")
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        if (files.length != 3) {
            return ResponseEntity.badRequest().body("You must upload exactly 3 files.");
        }

        for (MultipartFile file : files) {
            String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            if (extension == null || !allowedExtensions.contains(extension.toLowerCase())) {
                return ResponseEntity.badRequest().body("Invalid file extension. Allowed extensions are: pdf, png, docx.");
            }
        }



        return ResponseEntity.ok("Files uploaded successfully.");
    }

    @PostMapping("/upload-single")
    public ResponseEntity<String> uploadSingleFile(@RequestParam("file") MultipartFile file) {
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        if (extension == null || !allowedExtensions.contains(extension.toLowerCase())) {
            return ResponseEntity.badRequest().body("Invalid file extension. Allowed extensions are: pdf, png, docx.");
        }

        if (file.getSize() > 25 * 1024 * 1024) {
            return ResponseEntity.badRequest().body("File size exceeds the maximum allowed size of 25MB.");
        }



        return ResponseEntity.ok("File uploaded successfully.");
    }
}
