package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicoRepository extends CrudRepository<Medico, Long> {

	@Query("select m from Medico m where m.especialidade = ?1")
	public List<Medico> findMedicoByEspecialidade(String especialidade);
	
	public Medico findMedicoByCrm(Long crm);
	
	public void deleteAll();

}
