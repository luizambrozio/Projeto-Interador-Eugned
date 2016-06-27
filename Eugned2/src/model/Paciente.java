
package model;

/**
 * @author ambrozio
 */

import java.util.Date;

public class Paciente {
	
	private int id;
	private String nome;
	private String cpf;
	private String rg;
	private EnumEscolaridade escolaridade;
	private EnumEstadoCivil estadoCivil;
	private EnumSexo sexo;
	private EnumCorRaca corRaca;
	private Date dataNascimento;
	private Float rendaFamiliar;
	private Boolean gestante;
	
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(int id, String nome, String cpf, String rg, EnumEscolaridade escolaridade, EnumEstadoCivil estadoCivil, EnumSexo sexo,
			EnumCorRaca corRaca, Date dataNascimento, Float rendaFamiliar, Boolean gestante) {
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

	public EnumEscolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(EnumEscolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public EnumEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EnumEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public EnumCorRaca getCorRaca() {
		return corRaca;
	}

	public void setCorRaca(EnumCorRaca corRaca) {
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

	public void setRendaFamiliar(Float i) {
		this.rendaFamiliar = i;
	}

	public Boolean getGestante() {
		return gestante;
	}

	public void setGestante(Boolean gestante) {
		this.gestante = gestante;
	}

	public void setInt(EnumSexo enumSexo) {
		// TODO Auto-generated method stub
		
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public void setInt(EnumEscolaridade enumEscolaridade) {
		// TODO Auto-generated method stub
		
	}

	public void setInt(EnumCorRaca enumCorRaca) {
		// TODO Auto-generated method stub
		
	}

	public void setInt(EnumEstadoCivil enumEstadoCivil) {
		// TODO Auto-generated method stub
		
	}
	


	
	
	
	

	
	
	
	

}
