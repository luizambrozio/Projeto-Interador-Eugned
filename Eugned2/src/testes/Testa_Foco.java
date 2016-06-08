package testes;

import java.sql.Date;

import dao.EnderecoDao;
import dao.FocoDAO;
import model.Endereco;
import model.Foco;

public class Testa_Foco {

	public static void main(String[] args) {
		// Testando Entidade Foco e Endereco
		Endereco endereco = new Endereco(0, "Servidão Aldo Flores da Cunha", "359", "Rio Vermelho","88060-211" , "Florianópolis", "SC");
		
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.inserir(endereco);
		System.out.println("Gravou");
		
	
//		Foco foco = new Foco();
//		foco.setDataFoco(new java.util.Date());
//		foco.setEndereco(endereco);
//		System.out.println(foco.getDataFoco());
		
		// Testa o DAO
		// Inserir
	//	new FocoDAO().inserir(foco);
//		System.out.println(new FocoDAO().getListaFocos());

	}

}
