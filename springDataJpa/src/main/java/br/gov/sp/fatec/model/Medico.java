package br.gov.sp.fatec.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long crm;
    
    @Column(unique=true, length = 20, nullable = false)
    private String nome;
    
    @Column(length = 50, nullable = false)
    private String sobrenome;

    private String especialidade;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="medico", targetEntity = Consulta.class, fetch = FetchType.LAZY)
    private List<Consulta> consultas;

	public Medico() {

	}

	public Medico(String nome, String sobrenome, String especialidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.especialidade = especialidade;
		this.consultas = consultas;
	}

	public Medico(Long crm, String nome, String sobrenome, String especialidade) {
		this.crm = crm;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.especialidade = especialidade;
		this.consultas = consultas;
	}






		@Override
	public String toString() {
		return "Medico{" +
				"crm=" + crm +
				", nome='" + nome + '\'' +
				", sobrenome='" + sobrenome + '\'' +
				", especialidade='" + especialidade + '\'' +
				", consultas=" + consultas +
				'}';
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}
