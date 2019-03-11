package br.gov.sp.fatec;

import static org.junit.Assert.assertTrue;

import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.repository.MedicoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback()
public class MedicoRepositoryTest {


	@Autowired
	private MedicoRepository medicoRepository;
	

	public void setMedicoRepository(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	@Test
	public void insereMedicoTest() {
		Medico medico = new Medico();
		medico.setNome("Natalie");
		medico.setSobrenome("Manning");
		medico.setEspecialidade("Medico de Sala de Emergência");
		medicoRepository.save(medico);
		assertNotNull(medico.getCrm());
	}

	@Test
	public void achaMedicoPorCrm(){
		Medico medico = medicoRepository.findMedicoByCrm(1L);
		assertEquals("Connor", medico.getNome());
	}

}
