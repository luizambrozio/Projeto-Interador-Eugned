/**
 * @author ambrozio
 */
package model;

public class PacienteEndereco {
	
	private int id;
	private Endereco endereco;
	private Paciente paciente;
	private EnumTipoEndereco tipo;
	public PacienteEndereco(int id, Endereco endereco, Paciente paciente, EnumTipoEndereco tipo) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.paciente = paciente;
		this.tipo = tipo;
	}
	public PacienteEndereco() {
		// TODO Auto-generated constructor stub
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
	public EnumTipoEndereco getTipo() {
		return tipo;
	}
	public void setTipo(EnumTipoEndereco tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
