package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.repository.ConsultaRepository;
import br.gov.sp.fatec.repository.MedicoRepository;
import br.gov.sp.fatec.service.api.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        medicoRepository.delete(medico);
        //List<Consulta> consultas = consultaRepository.queryConsulta(medico.getCrm());
        //consultaRepository.deleteAll(consultas);
    }

    @Override
    @Transactional
    public void deletaMedico(Long id) {
        Medico medico = achaMedicoPorCrm(id);
        medicoRepository.delete(medico);
    }

    @Override
    @Transactional
    public Medico atualizaMedico(Medico medico) {
        return null;
    }

    @Override
    @Transactional
    public List<Medico> achaTodosMedicos() {
        return (List<Medico>) medicoRepository.findAll();
    }

    @Override
    @Transactional
    public Medico achaMedicoPorCrm(Long crm) {
        return medicoRepository.findMedicoByCrm(crm);
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
