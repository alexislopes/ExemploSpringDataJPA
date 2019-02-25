package br.gov.sp.fatec.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.io.Serializable;

@Entity
public class ConsultaMedico implements Serializable {

    @Id
    @JoinColumn(name = "Medico")
    private Long crm;

    @Id
    @JoinColumn(name = "Consulta")
    private Long id;
}
