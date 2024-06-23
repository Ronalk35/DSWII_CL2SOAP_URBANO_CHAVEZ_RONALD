package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.Personaje;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service.PersonajeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personaje")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> findAll() {
        return personajeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personaje> findById(@PathVariable Integer id) {
        Personaje personaje = personajeService.findById(id);
        if (personaje != null) {
            return ResponseEntity.ok(personaje);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Personaje save(@RequestBody Personaje personaje) {
        return personajeService.save(personaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personaje> update(@PathVariable Integer id, @RequestBody Personaje personaje) {
        Personaje updatedPersonaje = personajeService.update(id, personaje);
        if (updatedPersonaje != null) {
            return ResponseEntity.ok(updatedPersonaje);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        personajeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
