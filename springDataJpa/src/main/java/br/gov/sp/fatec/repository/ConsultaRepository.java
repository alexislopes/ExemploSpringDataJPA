package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.model.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	public List<Consulta> findAll();

	@Query("SELECT c FROM Consulta c WHERE c.diagnostico = ?1")
	List<Consulta> findConsultaByDiagnostico(String diagnostico);

	@Query("SELECT c FROM Consulta c JOIN c.medico m WHERE m.crm = ?1")
	List<Consulta> findConsultaByMedico(Long crm);

	List<Consulta> findConsultaByDia(String dia);

	void deleteAllByMedico(Medico medico);

}
