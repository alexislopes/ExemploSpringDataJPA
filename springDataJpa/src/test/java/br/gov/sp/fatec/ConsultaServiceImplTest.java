package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Consulta;
import br.gov.sp.fatec.service.ConsultaServiceImpl;
import br.gov.sp.fatec.service.api.ConsultaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback()
public class ConsultaServiceImplTest {

    @Autowired
    private ConsultaServiceImpl consultaService;

    public void setConsultaService(ConsultaServiceImpl consultaService){
        this.consultaService = consultaService;
    }

    @Test(expected = Exception.class)
    public void insereConsultaTest(){
        Consulta consulta = consultaService.insereConsulta(new Consulta("05:00", "16/10/2018", "Hepatite",99L));
        assertNotNull(consulta.getId());
    }

    @Test
    public void achaConsultaPorDiagnostico(){
        consultaService.insereConsulta(new Consulta("05:00", "16/10/2018", "Hepatite",2L));
        List<Consulta> consultas = consultaService.achaConsultaPorDiagnostico("Hepatite");
        Consulta consulta = null;
        for(Consulta c : consultas){
            if(c.getDiagnostico().equals("Hepatite")){
                consulta = c;
            }
        }
        assertEquals("Hepatite", consulta.getDiagnostico());
    }

}
