/**
 * @author Wagner Crispim Mattei
 * @vesion 1
 * 
 * Classe Entidade que representa a tabela Foco
 * 
 */
package model;

import java.util.Date;

public class Foco {
	
	private int id;
	private Date dataFoco;
	private Endereco endereco;
	
	public Foco(int id, Date dataFoco, Endereco endereco) {
		super();
		this.id = id;
		this.dataFoco = dataFoco;
		this.endereco = endereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataFoco() {
		return dataFoco;
	}
	public void setDataFoco(Date dataFoco) {
		this.dataFoco = dataFoco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
