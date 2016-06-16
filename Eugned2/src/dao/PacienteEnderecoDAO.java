package dao;

/**
 * @author ambrozio
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.EnumTipoEndereco;
import model.PacienteEndereco;
import util.ConnectionUtil;

public class PacienteEnderecoDAO {
	
	private ArrayList<PacienteEndereco> listaPacienteEndereco = new ArrayList<PacienteEndereco>();
	
	private Connection con = ConnectionUtil.getConnection();
	/**
	 * Carrega todos os Pacientes do banco de dados para manipulação posterior
	 * @return Lista de Objetos Paciente
	 */
	public List<PacienteEndereco> getListaPacienteEndereco(){
		try {
			Statement stmt = con.createStatement();
			String query = "select * from paciente_endereco";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				PacienteEndereco pacienteEndereco = new PacienteEndereco();
				
				pacienteEndereco.setId(rs.getInt("id"));           
				pacienteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				pacienteEndereco.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
				pacienteEndereco.setTipo(EnumTipoEndereco.values()[rs.getInt("tipoEndereco")-1]);
				
				listaPacienteEndereco.add(pacienteEndereco);
			}
			return listaPacienteEndereco;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Carrega todos os Pacientes que ocorreram em um período
	 * @return Lista de Objetos Focus
	 */
	
	/**
	public List<PacienteEndereco> getListaPacientesByNome(String nome){
		String query = "select * from paciente where nome like '%?%'";	
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery(query);
			Paciente paciente = null;
			while (rs.next()){
				paciente.setId(rs.getInt("id"));           
				paciente.setCpf(rs.getString("cpf"));           
				paciente.setRg(rs.getString("rg"));            
				paciente.setEscolaridade(EnumEscolaridade.values()[rs.getInt("escolarida")]);  
				paciente.setEstadoCivil(EnumEstadoCivil.values()[rs.getInt("estadoCivil")]);   
				paciente.setSexo(EnumSexo.values()[rs.getInt("sexo")]);          
				paciente.setCorRaca(EnumCorRaca.values()[rs.getInt("corRaca")]);       
				paciente.setDataNascimento(rs.getDate("dataNascimento"));  
				paciente.setRendaFamiliar(rs.getFloat("rendaFamiliar"));				
				
				listaPacientes.add(paciente);
			}
			return listaPacientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
*/
	/**
	 * Carrega um Paciente pelo Id
	 * @return Paciente
	 */		
	
	public PacienteEndereco getPacienteEnderecoById(int id){
		String query = "select * from paciente_endereco where id = ?";
		try {
			PacienteEndereco pacienteEndereco = null; 
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()){				
				pacienteEndereco.setId(rs.getInt("id"));           
				pacienteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				pacienteEndereco.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
				
				listaPacienteEndereco.add(pacienteEndereco);
			}
			return pacienteEndereco;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return null;
		}
	
	

	public void inserir(PacienteEndereco pacienteEndereco){		            
		 
		String query = "insert into paciente_endereco (idEndereco, idPaciente) values (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, pacienteEndereco.getEndereco().getId());
			pstmt.setInt(2, pacienteEndereco.getPaciente().getId());
			pstmt.execute();
			con.commit();
			
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(PacienteEndereco pacienteEndereco){
		String query = "update paciente set idEndereco =?, idPaciente=?  where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pacienteEndereco.getEndereco().getId());
			pstmt.setInt(2, pacienteEndereco.getPaciente().getId());
			pstmt.setInt(3, pacienteEndereco.getId());
			pstmt.execute();
			con.commit();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	/**
	 * Exclui um Paciente informando o id
	 * Para que o Paciente possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
	 * @return nada
	 */
	public void excluir(int id){
		String query = "delete from Paciente where id = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
	/**
	 * Seta uma lista de Pacientes para teste
	 * @param listaPacientes
	 * @return nada
	 */
	public void setListaPacientes(ArrayList<PacienteEndereco> listaPacienteEndereco) {
		this.listaPacienteEndereco = listaPacienteEndereco;
	}

}