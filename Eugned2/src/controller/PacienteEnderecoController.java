/**
 * @author ambrozio
 */
package controller;

import java.util.Date;
import java.util.List;

import dao.EnderecoDao;
import dao.FocoDAO;
import dao.PacienteDAO;
import dao.PacienteEnderecoDAO;
import exception.EnderecoException;
import exception.EnderecoPacienteException;
import exception.FocoException;
import exception.PacienteException;
import model.Endereco;
import model.Foco;
import model.Paciente;
import model.PacienteEndereco;

public class PacienteEnderecoController {
	
	public void inserir(Foco foco) throws FocoException{
		if (foco == null){
			throw new FocoException("Foco inválido");
		}
		if (foco.getDataFoco() == null){
			throw new FocoException("Informe uma data");
		}
		if (foco.getEndereco() == null){
			throw new FocoException("Preencha o endereço");
		}
		// TODO recuperado o id do endereço
		new EnderecoDao().inserir(foco.getEndereco());
		new FocoDAO().inserir(foco);
	}
	
	public void excluir(int id) throws EnderecoPacienteException{
		if (id == 0){
			throw new EnderecoPacienteException("Selecione um Endereco");
		}		
		new EnderecoDao().excluir(id);
	}
	
	public List<PacienteEndereco> getListaPacienteEnderecobyIdPe(){
		return new PacienteEnderecoDAO().getListaPacienteEndereco();
	}
	
	public List<PacienteEndereco> getListaPacienteEnderecobyIdPe(Paciente paciente){
		if(paciente!=null){
			return new PacienteEnderecoDAO().getListaPacienteEnderecoById(paciente);
		}else{
			return new PacienteEnderecoDAO().getListaPacienteEnderecoById(new Paciente());

		}
	}
	

}
