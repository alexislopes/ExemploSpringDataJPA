package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.repository.ConsultaRepository;
import br.gov.sp.fatec.repository.MedicoRepository;
import br.gov.sp.fatec.service.api.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("medicoService")
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public void setMedicoRepository(MedicoRepository usuarioRepository) {
        this.medicoRepository = usuarioRepository;
    }


    public void setConsultaRepository(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }


    @Override
    @Transactional
    public Medico insereMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    @Transactional
    public void deletaMedico(Medico medico) {
        consultaRepository.deleteAllByCrm(medico.getCrm());
        medicoRepository.delete(medico);
    }

    @Override
    @Transactional
    public void deletaMedico(Long crm){
        consultaRepository.deleteAllByCrm(crm);
        medicoRepository.deleteById(crm);
    }

    @Override
    @Transactional
    public Medico atualizaMedico(Medico medico) {
        return null;
    }

    @Override
    @Transactional
    public List<Medico> achaTodosMedicos() {
        List<Medico> auxmedicos = new ArrayList<>();
        List<Medico> medicos = (List<Medico>) medicoRepository.findAll();
        for(Medico m : medicos){
            List<Consulta> consultas = consultaRepository.findConsultaByCrm(m.getCrm());
            m.setConsultas(consultas);
            auxmedicos.add(m);
        }
        return auxmedicos;
    }

    @Override
    @Transactional
    public Medico achaMedicoPorCrm(Long crm) {
        List<Consulta> consultas = consultaRepository.findConsultaByCrm(crm);
        Medico medico = medicoRepository.findMedicoByCrm(crm);
        medico.setConsultas(consultas);
        return medico;
    }

    @Override
    @Transactional
    public List<Medico> achaMedicoPorEspecialidade(String especialidade) {
        return medicoRepository.findMedicoByEspecialidade(especialidade);
    }

    @Override
    public void deletaTodosMedicos() {
        medicoRepository.deleteAll();
    }

}
