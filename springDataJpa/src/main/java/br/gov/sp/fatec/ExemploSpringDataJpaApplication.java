package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExemploSpringDataJpaApplication implements CommandLineRunner {
	
	@Autowired
	private MedicoService medicoService;

	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringDataJpaApplication.class, args);
	}
	
	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}

	@Override
	public void run(String... args) throws Exception {
		//medicoService.insereMedico(new Medico("Connan", "Rhodes", "Cirurgião Cardiotoráxico"));
	}
}
