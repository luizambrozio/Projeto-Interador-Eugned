package dao;

import java.awt.PaintContext;

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
import model.Paciente;
import model.PacienteEndereco;
import util.ConnectionUtil;

public class PacienteEnderecoDAO {

	private ArrayList<PacienteEndereco> listaPacienteEndereco = new ArrayList<PacienteEndereco>();

	private ArrayList<PacienteEndereco> listaPacienteEnderecoById = new ArrayList<PacienteEndereco>();

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
	 * Carrega os enderecos pelo Id do paciente
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
				pacienteEndereco.setTipo(EnumTipoEndereco.values()[rs.getInt("tipoEndereco")]);

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

		String query = "insert into paciente_endereco (idEndereco, idPaciente, tipoEndereco ) values (?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, pacienteEndereco.getEndereco().getId());
			pstmt.setInt(2, pacienteEndereco.getPaciente().getId());
			pstmt.setInt(3, pacienteEndereco.getTipo().getCodigo());
			pstmt.execute();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(PacienteEndereco pacienteEndereco){
		String query = "update paciente set idEndereco =?, idPaciente=?, tipoEndereco=?   where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, pacienteEndereco.getEndereco().getId());
			pstmt.setInt(2, pacienteEndereco.getPaciente().getId());
			pstmt.setInt(3, pacienteEndereco.getTipo().getCodigo());
			pstmt.setInt(4, pacienteEndereco.getId());

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


	public List<PacienteEndereco> getListaPacienteEnderecoById(Paciente paciente) {
		
		try {
			String query = "select * from paciente_endereco where idPaciente = ?";
			PreparedStatement pstmt = con.prepareStatement(query);				
			pstmt.setInt(1, paciente.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				PacienteEndereco pacienteEnderecoId = new PacienteEndereco(); 
				pacienteEnderecoId.setId(rs.getInt("id"));           
				pacienteEnderecoId.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
				pacienteEnderecoId.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));					
				pacienteEnderecoId.setTipo(EnumTipoEndereco.values()[rs.getInt("tipoEndereco")]);

				listaPacienteEnderecoById.add(pacienteEnderecoId);
			}
			return listaPacienteEnderecoById;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//public List<PacienteEndereco> getListaPacienteEnderecoByIdPe() {
//		
//		try {
//			String query = "select * from paciente_endereco where idPaciente = ?";
//			PreparedStatement pstmt = con.prepareStatement(query);				
//			pstmt.setInt(1, e.getId());
//			ResultSet rs = pstmt.executeQuery();
//			while (rs.next()){
//				PacienteEndereco pacienteEnderecoId = new PacienteEndereco(); 
//				pacienteEnderecoId.setId(rs.getInt("id"));           
//				pacienteEnderecoId.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
//				pacienteEnderecoId.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));					
//				pacienteEnderecoId.setTipo(EnumTipoEndereco.values()[rs.getInt("tipoEndereco")]);
//
//				listaPacienteEnderecoById.add(pacienteEnderecoId);
//			}
//			return listaPacienteEnderecoById;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}


	public void setListaPacienteEnderecoById(ArrayList<PacienteEndereco> listaPacienteEnderecoById) {
		this.listaPacienteEnderecoById = listaPacienteEnderecoById;
	}

}