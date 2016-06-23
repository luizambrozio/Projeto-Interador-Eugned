package controller;

import java.util.List;

import dao.EnderecoDao;
import dao.PacienteDAO;
import exception.EnderecoException;
import exception.PacienteException;
import model.Endereco;
import model.EnumSexo;
import model.Paciente;
import model.PacienteEndereco;

public class EnderecoController {

	
	public void inserir(Endereco endereco) throws EnderecoException{
		if(endereco.getRua().equals(null)){
			throw new EnderecoException("Rua Invalid");
		}
		if(endereco.getCep().equals(null)){
			throw new EnderecoException("CEP invalido");
		}
		if(endereco.getBairro().equals(null)){
			throw new EnderecoException("Bairro invalido");
		}
		if(endereco.getEstado().equals(null)){
			throw new EnderecoException("Endereco invalido");
		}
		if(endereco.getNumero().equals(null)){
			throw new EnderecoException("Numero invalida");
		}
		if(endereco.getCidade().equals(true)){
			throw new EnderecoException("Homem não pode estar Gestante");
		}
		
		new EnderecoDao().inserir(endereco);
	}
	
	public void excluir(int id) throws EnderecoException{
		if (id == 0){
			throw new EnderecoException("Selecione um Endereco");
		}		
		new EnderecoDao().excluir(id);
	}
	
//Editar
	public void editar(Endereco endereco) throws EnderecoException{
		if(endereco.getRua().equals(null)){
			throw new EnderecoException("Rua Invalid");
		}
		if(endereco.getCep().equals(null)){
			throw new EnderecoException("CEP invalido");
		}
		if(endereco.getBairro().equals(null)){
			throw new EnderecoException("Bairro invalido");
		}
		if(endereco.getEstado().equals(null)){
			throw new EnderecoException("Endereco invalido");
		}
		if(endereco.getNumero().equals(null)){
			throw new EnderecoException("Numero invalida");
		}
		if(endereco.getCidade().equals(true)){
			throw new EnderecoException("Homem não pode estar Gestante");
		}
		
		new EnderecoDao().editar(endereco);
	}
	
	
	public List<Endereco> getListaEnderecoByPaciente(int pe){
		return new EnderecoDao().getEnderecoByIdPessoa(pe);
	}

}
