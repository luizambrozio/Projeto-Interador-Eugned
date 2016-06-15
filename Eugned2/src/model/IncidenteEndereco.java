package model;
/**
 * 
 * @author Diego Leite
 *
 */

public class IncidenteEndereco {
	
	private int id;
	private Incidente incidente;
	private Endereco endereco;
	
	
	public IncidenteEndereco() {
	}
	
	public IncidenteEndereco(int id, Incidente incidente, Endereco endereco) {
		super();
		this.id = id;
		this.incidente = incidente;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

}
