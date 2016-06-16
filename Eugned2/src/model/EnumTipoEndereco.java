package model;

/**
 * 
 * @author ambrozio
 * 
 * Enum para registrar o tipo de endereco no cadastrdo do endereco do paciente
 *
 */

public enum EnumTipoEndereco {
	
	RESIDENCIA(1,"Residencia"),
	TRABALHO(2,"Trabalho"),
	ESCOLA(3,"Escola");
	 
	private int codigo;
	private String descricao;
	
	private EnumTipoEndereco(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return descricao;
	}
	
	

}
