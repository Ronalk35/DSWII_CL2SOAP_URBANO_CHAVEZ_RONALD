package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service;

import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.ProgramaTv;
import java.util.List;

public interface ProgramaTvService {
    List<ProgramaTv> findAll();
    ProgramaTv findById(Integer id);
    ProgramaTv save(ProgramaTv programaTv);
    ProgramaTv update(Integer id, ProgramaTv programaTv);
    void delete(Integer id);
}
