package testes;

import java.sql.Date;

import dao.EnderecoDao;
import dao.FocoDAO;
import model.Endereco;
import model.Foco;

public class Testa_Foco {

	public static void main(String[] args) {
		// Testando Entidade Foco e Endereco
		EnderecoDao enderecoDao = new EnderecoDao();
		int id = 4;
		Endereco endereco = (enderecoDao.getEnderecoById(id));
		System.out.println("Endereço: "+endereco.getRua());
		
	
		Foco foco = new Foco();
		foco.setDataFoco(new java.util.Date());
		foco.setEndereco(endereco);
		System.out.println("Foco: " + foco.getDataFoco().toLocaleString() + " - " + endereco.getRua());
		
		new FocoDAO().inserir(foco);
		System.out.println(new FocoDAO().getListaFocos());

	}

}
