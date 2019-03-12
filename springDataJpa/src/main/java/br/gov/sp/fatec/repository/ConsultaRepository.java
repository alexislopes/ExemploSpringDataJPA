package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Consulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	public List<Consulta> findAll();

	@Query("SELECT c FROM Consulta c WHERE c.diagnostico = ?1")
	List<Consulta> findConsultaByDiagnostico(String diagnostico);

	@Query("SELECT c FROM Consulta c WHERE c.crm = ?1")
	List<Consulta> findConsultaByCrm(Long crm);

	List<Consulta> findConsultaByDia(String dia);

	void deleteAllByCrm(Long crm);

}
