package br.gov.sp.fatec.service.api;

import br.gov.sp.fatec.model.Consulta;

import java.util.List;
import java.util.Optional;

public interface ConsultaService {

    Optional<Consulta> achaConsultaPorId(Long id);

    Consulta insereConsulta(Consulta consulta);

    List<Consulta> achaConsultaPorDiagnostico(String diagnostico);

    void deletaTodasConsultas();

    void deletaConsultaPorId(Long id);

}
