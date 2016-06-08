package testes;

import java.sql.Date;

import dao.FocoDAO;
import model.Endereco;
import model.Foco;

public class Testa_Foco {

	public static void main(String[] args) {
		// Testando Entidade Foco e Endereco
		Endereco endereco = new Endereco(0, "Teste", "", "",null , "", "");
	
		Foco foco = new Foco();
		foco.setDataFoco(new java.util.Date());
		foco.setEndereco(endereco);
		System.out.println(foco.getDataFoco());
		
		// Testa o DAO
		// Inserir
	//	new FocoDAO().inserir(foco);
		System.out.println(new FocoDAO().getListaFocos());

	}

}
