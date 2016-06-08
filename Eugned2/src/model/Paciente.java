package model;

import java.util.Date;

public class Paciente {
	
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private String escolaridade;
	private String estadoCivil;
	private String sexo;
	private String corRaca;
	private Date dataNascimento;
	private Integer rendaFamiliar;
	
	
	public Paciente(int id, String nome, String cpf, String rg, String escolaridade, String estadoCivil, String sexo,
			String corRaca, Date dataNascimento, Integer rendaFamiliar) {
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
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCorRaca() {
		return corRaca;
	}
	public void setCorRaca(String corRaca) {
		this.corRaca = corRaca;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getRendaFamiliar() {
		return rendaFamiliar;
	}
	public void setRendaFamiliar(Integer rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}
	
	
	
	

}
