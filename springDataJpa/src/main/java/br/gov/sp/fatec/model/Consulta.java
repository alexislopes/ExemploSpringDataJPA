package br.gov.sp.fatec.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String hora;
    private String dia;
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name="crm")
    private Medico medico;

    public Consulta() {
    }

    public Consulta(String hora, String dia, String diagnostico, Medico medico) {
        this.hora = hora;
        this.dia = dia;
        this.diagnostico = diagnostico;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return dia;
    }

    public void setData(String data) {
        this.dia = data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Medico getCrm() {
        return this.medico;
    }

    public void setCrm(Medico medico) {
        this.medico = medico;
    }
}
