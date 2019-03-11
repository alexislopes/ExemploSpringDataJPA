package br.gov.sp.fatec;


import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.service.MedicoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback()
public class MedicoServiceImplTest {

    @Autowired
    private MedicoServiceImpl medicoService;

    public void setMedicoService(MedicoServiceImpl medicoService){
        this.medicoService = medicoService;
    }

    @Test
    public void insereMedicoTest(){
        Medico medico = medicoService.insereMedico(new Medico("Ethan", "Choi", "Médico de Sala de Emergencia"));
        assertNotNull(medico.getCrm());
    }

    @Test
    public void achaMedicoPorCrm(){
        Medico medico = medicoService.achaMedicoPorCrm(2L);
        assertNotNull(medico);
    }
}
