package testes;

/**
 * @author ambrozio;
 */

import java.util.ArrayList;
import java.util.Date;

import dao.PacienteDAO;
import model.EnumCorRaca;
import model.EnumEscolaridade;
import model.EnumEstadoCivil;
import model.EnumSexo;
import model.Paciente;

public class TestaPaciente {
	
	public static void main(String[] args) {
		
		//testaListaPaciente();
		//testaInserir();
		//testaEditar();
		testaBuscaPorNome();
		//testaListaPaciente();
		//System.out.println("Excluindo");
		//testaExcluir();
		//testaListaPaciente();
		
	}
	
	private static void testaBuscaPorNome() {
		String nome =  "Wagner";
		System.out.println("Pacinte: " + nome);
		for (Paciente paciente : new PacienteDAO().getListaPacientesByNome(nome)) {
			System.out.println(paciente.getId() + " - " + paciente.getNome());
		};
		
	}

	public static void testaInserir() {
		
		              
		String nome= "Luiz Ambrozio";            
		String cpf= "111.111.111-11";        
		String rg = "99-99-999";             
		EnumEscolaridade escolaridade = EnumEscolaridade.SUPERIOR;    
		EnumEstadoCivil estadoCivil = EnumEstadoCivil.CASADO;     
		EnumSexo sexo = EnumSexo.MASCULINO;            
		EnumCorRaca corRaca = EnumCorRaca.BRANCO;         
		Date dataNascimento = new Date();    
		Float rendaFamiliar = (float) 8650;  
		Boolean gestante = false;    
		
		Paciente paciente = new Paciente(0, nome, cpf, rg, escolaridade, estadoCivil, sexo, corRaca, dataNascimento, rendaFamiliar, gestante);
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.inserir(paciente);
		System.out.println("Gravou");
	
	}
	
	public static void testaEditar() {
		int id = 1;
		String nome= "Luiz Ambrozio 2 teste";            
		String cpf= "111.111.111-11";        
		String rg = "99-99-999";             
		EnumEscolaridade escolaridade = EnumEscolaridade.SUPERIOR;    
		EnumEstadoCivil estadoCivil = EnumEstadoCivil.CASADO;     
		EnumSexo sexo = EnumSexo.MASCULINO;            
		EnumCorRaca corRaca = EnumCorRaca.BRANCO;         
		Date dataNascimento = new Date();    
		Float rendaFamiliar = (float) 8650;  
		Boolean gestante = false;
		
		Paciente paciente = new Paciente(id, nome, cpf, rg, escolaridade, estadoCivil, sexo, corRaca, dataNascimento, rendaFamiliar, gestante);
		
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.editar(paciente);
		System.out.println("Gravou");
	
	}

	public static void testaExcluir() {
		
		int id = 3;
		PacienteDAO pacienteDAO = new PacienteDAO();
		pacienteDAO.excluir(id);
		System.out.println("Apagou");
	
	}
	
	public static void testaListaPaciente() {
		ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) new PacienteDAO().getListaPacientes();
		for (Paciente paciente : listaPacientes) {
			System.out.println("id: " + paciente.getId()+" - Nome "+ paciente.getNome() + ", CPF "+
							paciente.getCpf()+" - RG " + paciente.getRg()+" - "+ paciente.getDataNascimento()+
							"-"+paciente.getEstadoCivil()+" - "+ paciente.getCorRaca()+" - "+ paciente.getRendaFamiliar()+" - "+ paciente.getGestante());
		}
		
		
	}


}
