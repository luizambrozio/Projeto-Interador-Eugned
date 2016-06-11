package model;

import java.util.Date;

public class Paciente {
	
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private int escolaridade;
	private int estadoCivil;
	private int sexo;
	private int corRaca;
	private Date dataNascimento;
	private Float rendaFamiliar;
	private Boolean gestante;
	
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int id, String nome, String cpf, String rg, int escolaridade, int estadoCivil, int sexo,
			int corRaca, Date dataNascimento, Float rendaFamiliar, Boolean gestante) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.escolaridade = escolaridade;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.corRaca = corRaca;
		this.dataNascimento = dataNascimento;
		this.rendaFamiliar = rendaFamiliar;
		this.gestante = gestante;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(int escolaridade) {
		this.escolaridade = escolaridade;
	}

	public int getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getCorRaca() {
		return corRaca;
	}

	public void setCorRaca(int corRaca) {
		this.corRaca = corRaca;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Float getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(Float rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public Boolean getGestante() {
		return gestante;
	}

	public void setGestante(Boolean gestante) {
		this.gestante = gestante;
	}


	
	
	
	

	
	
	
	

}
