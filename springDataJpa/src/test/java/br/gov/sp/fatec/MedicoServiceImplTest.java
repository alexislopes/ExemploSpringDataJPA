package br.gov.sp.fatec;


import br.gov.sp.fatec.model.Medico;
import br.gov.sp.fatec.service.MedicoServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class MedicoServiceImplTest {

    private MedicoServiceImpl medicoService;
    private Medico medico;

    @Before
    public void setUp(){
        medicoService = new MedicoServiceImpl();
        medico = new Medico("Will", "Halstead", "Sala de Emergencia");
    }

    @Test
    public void insereMedicoTest(){
        Medico aux = medicoService.insereMedico(medico);
        assertNotNull(aux.getCrm());
    }
}
