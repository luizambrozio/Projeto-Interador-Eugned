package controller;

import java.util.Date;
import java.util.List;

import dao.EnderecoDao;
import dao.FocoDAO;
import exception.FocoException;
import model.Foco;

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
	

}
