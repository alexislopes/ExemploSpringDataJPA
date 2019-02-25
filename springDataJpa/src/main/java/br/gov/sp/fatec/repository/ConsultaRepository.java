package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Consulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

	public List<Consulta> findAll();

	public List<Consulta> findConsultaByDia(String dia);

}
