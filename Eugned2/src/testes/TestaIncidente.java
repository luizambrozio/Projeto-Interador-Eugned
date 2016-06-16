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
		//testaListar();
		 testaInserir();

}

	private static void testaListar() {
	for (Incidente incidente : new IncidenteDAO().getListaIncidentes()) {
		System.out.println(incidente.getPaciente().getNome());
	}
		
}

	private static void testaInserir() {
		PacienteDAO pacienteDAO = new PacienteDAO();
		int id = 1;
		Paciente paciente = (pacienteDAO.getPacienteById(id));
		System.out.println("Paciente: "+paciente.getNome());
		
		Incidente incidente = new Incidente();
		incidente.setDataIncidente(new java.util.Date());
		incidente.setDataSintoma(new java.util.Date());
		incidente.setPaciente(paciente);
		incidente.setSintomas("sintomas");
		System.out.println("incidente: " + incidente.getDataIncidente() + " - " + paciente.getNome());
		
		new IncidenteDAO().inserir(incidente);
		System.out.println(new IncidenteDAO().getListaIncidentes());
		

		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco endereco = (enderecoDao.getEnderecoById(id));
		System.out.println("Endereco: "+endereco.getRua());
		
		IncidenteEndereco incidenteEndereco = new IncidenteEndereco();
		incidenteEndereco.setIncidente(incidente);
		incidenteEndereco.setEndereco(endereco);
		System.out.println("incidente: " + incidenteEndereco.getIncidente() + " - " + endereco.getRua());
		
		new IncidenteEnderecoDAO().inserir(incidenteEndereco);
		System.out.println(new IncidenteEnderecoDAO().getListaincidenteEnderecos());
		
	}

}