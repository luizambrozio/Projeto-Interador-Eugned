package model;

import java.util.Date;

public class Incidente {
	
	private int id;
	private Paciente paciente;
	private Date dataIncidente;
	private Date dataSintoma;
	private String sintomas;
	
	public Incidente(int id, Paciente paciente, Date dataIncidente,
			Date dataSintoma, String sintomas) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.dataIncidente = dataIncidente;
		this.dataSintoma = dataSintoma;
		this.sintomas = sintomas;
	}
	public Incidente() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataIncidente() {
		return dataIncidente;
	}
	public void setDataIncidente(Date dataIncidente) {
		this.dataIncidente = dataIncidente;
	}
	public Date getDataSintoma() {
		return dataSintoma;
	}
	public void setDataSintoma(Date dataSintoma) {
		this.dataSintoma = dataSintoma;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	
	

	
	

}
