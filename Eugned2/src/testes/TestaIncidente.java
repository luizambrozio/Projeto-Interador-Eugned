package testes;

import model.Endereco;
import model.Incidente;
import model.IncidenteEndereco;
import model.Paciente;
import dao.EnderecoDao;
import dao.IncidenteDAO;
import dao.IncidenteEnderecoDAO;
import dao.PacienteDAO;

public class TestaIncidente {

	public static void main(String[] args) {
		// Testando Entidade incidente e Endereco
		testaInserir();
		testaListar();

}
	private static void testaListar() {
	for (Incidente incidente : new IncidenteDAO().getListaIncidentes()) {
		System.out.println(incidente.getDataIncidente().toLocaleString() +
						" - " + incidente.getDataSintoma().toLocaleString() +
						" - " + incidente.getSintomas());
	}
		
}

	private static void testaInserir() {
		// Conecta o PacienteDAO
		PacienteDAO pacienteDAO = new PacienteDAO();
		int idPaciente = 3;
		// Buscao o Paciente com id 1 e cria o objeto paciente
		Paciente paciente = (pacienteDAO.getPacienteById(idPaciente));
		System.out.println("Paciente: "+paciente.getNome());
		
		// Criar um objeto Incidente
		Incidente incidente = new Incidente();
		incidente.setDataIncidente(new java.util.Date());
		incidente.setDataSintoma(new java.util.Date());
		incidente.setPaciente(paciente);
		incidente.setSintomas("sintomas");
		System.out.println("incidente: " + incidente.getDataIncidente() + " - " + paciente.getNome());
		
		// Conectar o IncidenteDAO e inserir o objeto Incidente
		new IncidenteDAO().inserir(incidente);
		System.out.println("Id incidente: " + incidente.getId());
		System.out.println(new IncidenteDAO().getListaIncidentes());
		
		// Conecta o EnderecoDao
		EnderecoDao enderecoDao = new EnderecoDao();
		//Busca o Endereco pelo id
		Endereco endereco1 = (enderecoDao.getEnderecoById(4));
		Endereco endereco2 = (enderecoDao.getEnderecoById(7));
		System.out.println("Endereco1: "+endereco1.getRua());
		System.out.println("Endereco2: "+endereco2.getRua());
		
		// Criar um Objeto incidenteEndereco
		IncidenteEndereco incidenteEndereco1 = new IncidenteEndereco();
		incidenteEndereco1.setIncidente(incidente);
		incidenteEndereco1.setEndereco(endereco1);

		// Criar um Objeto incidenteEndereco
		IncidenteEndereco incidenteEndereco2 = new IncidenteEndereco();
		incidenteEndereco2.setIncidente(incidente);
		incidenteEndereco2.setEndereco(endereco2);
		System.out.println("incidente1: " + incidenteEndereco1.getIncidente() + " - " + incidenteEndereco1.getEndereco().getRua());
		System.out.println("incidente2: " + incidenteEndereco2.getIncidente() + " - " + incidenteEndereco2.getEndereco().getRua());
		
		// Conecta o Incideten Dao e insere o objeto incidenteEndereco
		new IncidenteEnderecoDAO().inserir(incidenteEndereco1);
		new IncidenteEnderecoDAO().inserir(incidenteEndereco2);
		
		
		
		System.out.println("Gravou");
		
	}

}