package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.model.Medico;

import java.util.List;

public interface MedicoService {
    Medico insereMedico(Medico medico);

    void deletaMedico(Medico medico);

    void deletaMedico(Long crm);

    Medico atualizaMedico(Medico medico);

    List<Medico> achaTodosMedicos();

    Medico achaMedicoPorCrm(Long crm);

    List<Medico> achaMedicoPorEspecialidade(String especialidade);
    
    void deletaTodosMedicos();




}
