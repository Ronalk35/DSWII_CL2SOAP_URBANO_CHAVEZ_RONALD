package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service;

import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.Personaje;
import java.util.List;

public interface PersonajeService {
    List<Personaje> findAll();
    Personaje findById(Integer id);
    Personaje save(Personaje personaje);
    Personaje update(Integer id, Personaje personaje);
    void delete(Integer id);
}
