package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.repository.ConsultaRepository;
import br.gov.sp.fatec.service.api.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class ConsultaServiceImpl implements ConsultaService {


    @Autowired
    private ConsultaRepository consultaRepository;

    public void setConsultaRepository(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    @Override
    @Transactional
    public Optional<Consulta> achaConsultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    @Override
    @Transactional
    public Consulta insereConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    @Transactional
    public void deletaTodasConsultas() {
        consultaRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deletaConsultaPorId(Long id) {
        consultaRepository.deleteById(id);
    }
}
