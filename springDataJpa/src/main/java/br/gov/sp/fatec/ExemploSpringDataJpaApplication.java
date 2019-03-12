package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.service.ConsultaServiceImpl;
import br.gov.sp.fatec.service.api.ConsultaService;
import br.gov.sp.fatec.service.api.MedicoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExemploSpringDataJpaApplication implements CommandLineRunner {
	
	@Autowired
	private MedicoService medicoService;

	@Autowired
	private ConsultaService consultaService;

	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringDataJpaApplication.class, args);
	}
	
	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}

	@Override
	public void run(String... args) throws Exception {
		//medicoService.insereMedico(new Medico("Connor", "Rhodes", "Cirurgião Cardiotoráxico"));
		//medicoService.insereMedico(new Medico("Will", "Halstead", "Médico de Sala de Emergência"));

		//consultaService.insereConsulta(new Consulta("12:15", "17/02/2019", "gripe", 1L));
		//consultaService.insereConsulta(new Consulta("13:45", "05/04/2019", "virose", 2L));


		Medico medico = medicoService.achaMedicoPorCrm(2L);
		
		System.out.println(medico.getNome());
		System.out.println(medico.getConsultas().toString());
		
		List<Medico> medicos = medicoService.achaMedicoPorEspecialidade("Cirurgião Cardiotoráxico");
		
		for(Medico m : medicos) {
			System.out.println(m.getNome());
		}
	}
}
