package controller;

import java.util.Date;
import java.util.List;

import dao.EnderecoDao;
import dao.FocoDAO;
import exception.FocoException;
import model.Foco;

// teste
public class FocoController {

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
		System.out.println("FOCO: Inserção OK!");

	}
	
	public List<Foco> getListaFocos(){
		return new FocoDAO().getListaFocos();
	}
	
	public List<Foco> getListaFocosByData(Date dataIni, Date dataFim) throws FocoException{
		if (dataIni == null || dataFim == null){
			throw new FocoException("Informe um período para pesquisa");
		}
		return new FocoDAO().getListaFocosByData(dataIni, dataFim);
	}
	
	public void editar(Foco foco) throws FocoException{
		if (foco == null){
			throw new FocoException("Foco inválido");
		}
		if (foco.getId() == 0){
			throw new FocoException("Foco inválido");
		}
		if (foco.getDataFoco() == null){
			throw new FocoException("Informe uma data");
		}
		if (foco.getEndereco() == null){
			throw new FocoException("Preencha o endereço");
		}
		new EnderecoDao().editar(foco.getEndereco());
		new FocoDAO().editar(foco);
	}
	
	public void excluir(int id) throws FocoException{
		if (id == 0){
			throw new FocoException("Selecione um foco");
		}		
		new FocoDAO().excluir(id);
	}	
}
