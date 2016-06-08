package model;

import java.util.Date;

public class Incidente {
	
	private int id;
	private Paciente idPaciente;
	private Date dataIncidente;
	private Date dataSintoma;
	private String simtomas;
	
	public Incidente(int id, Paciente idPaciente, Date dataIncidente,
			Date dataSintoma, String simtomas) {
		super();
		this.id = id;
		this.idPaciente = idPaciente;
		this.dataIncidente = dataIncidente;
		this.dataSintoma = dataSintoma;
		this.simtomas = simtomas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Paciente getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Paciente idPaciente) {
		this.idPaciente = idPaciente;
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
	public String getSimtomas() {
		return simtomas;
	}
	public void setSimtomas(String simtomas) {
		this.simtomas = simtomas;
	}
	
	

	
	

}
