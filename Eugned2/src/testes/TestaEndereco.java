package testes;

import java.util.ArrayList;

import dao.EnderecoDao;
import model.Endereco;

public class TestaEndereco {
	
	public static void main(String[] args) {
		
		//testaListaEndereco();
		// testaInserir();
		// testaEditar();
		testaListaEndereco();
		//System.out.println("Excluindo");
		//testaExcluir();
		//testaListaEndereco();
		
	}
	
	public static void testaInserir() {
		
		String rua = "R. João da Costa";
		String numero = "26";
		String bairro = "Jardim São Miguel";
		String cep = "88160-000";
		String cidade = "Biguaçu";
		String estado = "SC";
		
		Endereco endereco = new Endereco(0, rua, numero, bairro,cep , cidade, estado);
		
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.inserir(endereco);
		System.out.println("Gravou");
	
	}
	
	public static void testaEditar() {
		
		int id = 3;
		String rua = "R. Geral";
		String numero = "111";
		String bairro = "Centro";
		String cep = "88160-000";
		String cidade = "Biguaçu";
		String estado = "SC";
		
		Endereco endereco = new Endereco(id, rua, numero, bairro,cep , cidade, estado);
		
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.editar(endereco);
		System.out.println("Gravou");
	
	}

	public static void testaExcluir() {
		
		int id = 3;
		EnderecoDao enderecoDao = new EnderecoDao();
		enderecoDao.excluir(id);
		System.out.println("Apagou");
	
	}
	
	public static void testaListaEndereco() {
		ArrayList<Endereco> listaEnderecos =  (ArrayList<Endereco>) new EnderecoDao().getListaEnderecosByRua("Aldo");
		if(listaEnderecos == null) {
			return;
		}
		for (Endereco endereco : listaEnderecos) {
			System.out.println("id: " + endereco.getId()+" - "+ endereco.getRua() + ", "+
							endereco.getNumero()+" - CEP " + endereco.getCep()+" - "+ endereco.getCidade()+
							"-"+endereco.getEstado());
		}
		
		
	}


}
