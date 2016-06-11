package model;

public class PacienteEndereco {
	
	private int id;
	private Endereco endereco;
	private Paciente paciente;
	
	
	
	public PacienteEndereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PacienteEndereco(int id, Endereco endereco, Paciente paciente) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
