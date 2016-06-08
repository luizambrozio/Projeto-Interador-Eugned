package model;

public class IncidenteEndereco {
	
	private int id;
	private Incidente idIncidente;
	private Endereco idEndereco;
	
	
	public IncidenteEndereco(int id, Incidente idIncidente, Endereco idEndereco) {
		super();
		this.id = id;
		this.idIncidente = idIncidente;
		this.idEndereco = idEndereco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Incidente getIdIncidente() {
		return idIncidente;
	}
	public void setIdIncidente(Incidente idIncidente) {
		this.idIncidente = idIncidente;
	}
	public Endereco getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	
	

}
