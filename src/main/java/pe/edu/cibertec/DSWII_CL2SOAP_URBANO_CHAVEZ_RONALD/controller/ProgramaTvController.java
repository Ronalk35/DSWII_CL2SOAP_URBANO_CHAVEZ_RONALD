package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.ProgramaTv;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service.ProgramaTvService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programatv")
public class ProgramaTvController {

    @Autowired
    private ProgramaTvService programaTvService;

    @GetMapping
    public List<ProgramaTv> findAll() {
        return programaTvService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTv> findById(@PathVariable Integer id) {
        ProgramaTv programaTv = programaTvService.findById(id);
        if (programaTv != null) {
            return ResponseEntity.ok(programaTv);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProgramaTv save(@RequestBody ProgramaTv programaTv) {
        return programaTvService.save(programaTv);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTv> update(@PathVariable Integer id, @RequestBody ProgramaTv programaTv) {
        ProgramaTv updatedProgramaTv = programaTvService.update(id, programaTv);
        if (updatedProgramaTv != null) {
            return ResponseEntity.ok(updatedProgramaTv);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        programaTvService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
