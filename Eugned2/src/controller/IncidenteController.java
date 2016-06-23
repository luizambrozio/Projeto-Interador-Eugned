package controller;

import java.util.Date;
import java.util.List;

import dao.EnderecoDao;
import dao.IncidenteDAO;
import dao.IncidenteEnderecoDAO;
import exception.IncidenteException;
import model.Incidente;
import model.IncidenteEndereco;

// teste
public class IncidenteController {

	public void inserir(Incidente Incidente) throws IncidenteException{
		if (Incidente == null){
			throw new IncidenteException("Incidente inválido");
		}
		if (Incidente.getDataIncidente() == null){
			throw new IncidenteException("Informe uma data do incidente");
		}
		if (Incidente.getDataSintoma() == null){
			throw new IncidenteException("Informe uma data do sintoma");
		}
		if (Incidente.getSintomas() == null){
				throw new IncidenteException("Informe o sintoma");
		}
		if (Incidente.getPaciente() == null){
			throw new IncidenteException("Informe o nome do paciente");
	}
		// TODO recuperado o id do endereço
		//new EnderecoDao().inserir(Incidente.getEndereco());
		new IncidenteDAO().inserir(Incidente);
		System.out.println("Incidente: Inserção OK!");

	}
	
	public List<Incidente> getListaIncidentes(){
		return new IncidenteDAO().getListaIncidentes();
	}
	
	
	public List<Incidente> getListaIncidentesByData(Date dataIni, Date dataFim) throws IncidenteException{
		if (dataIni == null || dataFim == null){
			throw new IncidenteException("Informe um período para pesquisa");
		}
		System.out.println("Controller:"+dataIni.toLocaleString() +" - "+ dataFim.toLocaleString());
		return new IncidenteDAO().getListaIncidentesByData(dataIni, dataFim);
	}
	public List<Incidente> getSintomasByData(Date dataIni, Date dataFim) throws IncidenteException{
		if (dataIni == null || dataFim == null){
			throw new IncidenteException("Informe um período para pesquisa sintomas");
		}
		return new IncidenteDAO().getListaIncidentesByData(dataIni, dataFim);
	}
	
	public void editar(Incidente Incidente) throws IncidenteException{
		if (Incidente == null){
			throw new IncidenteException("Incidente inválido");
		}
		if (Incidente.getId() == 0){
			throw new IncidenteException("Incidente inválido");
		}
		if (Incidente.getDataIncidente() == null){
			throw new IncidenteException("Informe uma data");
		}
		//if (Incidente.getEndereco() == null){
			//throw new IncidenteException("Preencha o endereço");
		//}
		//new EnderecoDao().editar(Incidente.getEndereco());
		new IncidenteDAO().editar(Incidente);
		System.out.println("Incidente: Edição OK....");
	}
	
	public void excluir(int id) throws IncidenteException{
		if (id == 0){
			throw new IncidenteException("Selecione um Incidente");
		}		
		new IncidenteDAO().excluir(id);
	}	

	public List<IncidenteEndereco> getListaIncidentesEnderecos(Incidente incidente){
		if(incidente!= null) {
			return new IncidenteEnderecoDAO().getEnderecosIncidentes(incidente);
		} else {
			return new IncidenteEnderecoDAO().getEnderecosIncidentes(new Incidente());
		}
	}

}
