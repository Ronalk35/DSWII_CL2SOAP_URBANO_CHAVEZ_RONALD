package pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.model.bd.ProgramaTv;
import pe.edu.cibertec.DSWII_CL2SOAP_URBANO_CHAVEZ_RONALD.repository.ProgramaTvRepository;

import java.util.List;

@Service
public class ProgramaTvServiceImpl implements ProgramaTvService {

    @Autowired
    private ProgramaTvRepository programaTvRepository;

    @Override
    public List<ProgramaTv> findAll() {
        return programaTvRepository.findAll();
    }

    @Override
    public ProgramaTv findById(Integer id) {
        return programaTvRepository.findById(id).orElse(null);
    }

    @Override
    public ProgramaTv save(ProgramaTv programaTv) {
        return programaTvRepository.save(programaTv);
    }

    @Override
    public ProgramaTv update(Integer id, ProgramaTv programaTv) {
        if (programaTvRepository.existsById(id)) {
            programaTv.setIdProgramaTv(id);
            return programaTvRepository.save(programaTv);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (programaTvRepository.existsById(id)) {
            programaTvRepository.deleteById(id);
        }
    }
}
