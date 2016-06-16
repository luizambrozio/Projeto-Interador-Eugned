package ControllerLuiz;


import java.util.List;

import dao.PacienteDAO;
import exception.PacienteException;
import model.EnumSexo;
import model.Paciente;



public class PacienteController {
	
	public void inserir(Paciente paciente) throws PacienteException{
		if(paciente.getNome().equals(null)){
			throw new PacienteException("nome Invalido");
		}
		if(paciente.getCpf().equals(null)){
			throw new PacienteException();
		}
		if(paciente.getRg().equals(null)){
			throw new PacienteException("RG invalido");
		}
		if(paciente.getDataNascimento().equals(null)){
			throw new PacienteException("Data de Nascimento invalido");
		}
		if(paciente.getRendaFamiliar().equals(null)){
			throw new PacienteException("Renda invalida");
		}
		if(paciente.getGestante().equals(true)){
			if (paciente.getSexo().equals(EnumSexo.MASCULINO)) {
				
			}
			throw new PacienteException("Homem não pode estar Gestante");
		}
		
		new PacienteDAO().inserir(paciente);
	}

}