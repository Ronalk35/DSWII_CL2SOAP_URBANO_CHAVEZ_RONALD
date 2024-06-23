package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.Personaje;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.repository.PersonajeRepository;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> findAll() {
        return personajeRepository.findAll();
    }

    @Override
    public Personaje findById(Integer id) {
        return personajeRepository.findById(id).orElse(null);
    }

    @Override
    public Personaje save(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Override
    public Personaje update(Integer id, Personaje personaje) {
        if (personajeRepository.existsById(id)) {
            personaje.setIdPersonaje(id);
            return personajeRepository.save(personaje);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (personajeRepository.existsById(id)) {
            personajeRepository.deleteById(id);
        }
    }
}
