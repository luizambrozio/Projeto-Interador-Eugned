package dao;
/**
 * @author diegoBLeite
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.JDBC4PreparedStatement;

import model.incidenteEndereco;
import util.ConnectionUtil;

public class incidenteEnderecoDao {

	private ArrayList<incidenteEndereco> listaincidenteEnderecos = new ArrayList<incidenteEndereco>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	public List<incidenteEndereco> getListaincidenteEnderecos(){
		try {
			Statement stmt = con.createStatement();
			String query = "select * from incidenteEndereco";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				incidenteEndereco incidenteEndereco = new incidenteEndereco();
				incidenteEndereco.setId( rs.getInt("id") );
				incidenteEndereco.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
				incidenteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				
				listaincidenteEnderecos.add(incidenteEndereco);
			}
			return listaincidenteEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<incidenteEndereco> getListaincidenteEnderecosByRua(String rua){
		String query = "select * from incidenteEndereco where rua like '	%?%'";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "aldo");
			System.out.println(((JDBC4PreparedStatement) pstmt).asSql());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				incidenteEndereco incidenteEndereco = new incidenteEndereco();
				incidenteEndereco.setId( rs.getInt("id") );
				incidenteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				
				listaincidenteEnderecos.add(incidenteEndereco);
			}
			return listaincidenteEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public incidenteEndereco getincidenteEnderecoById(int id){
		String query = "select * from incidenteEndereco where id = ?";
		try {
			incidenteEndereco incidenteEndereco = null;
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Entrou");
				incidenteEndereco = new incidenteEndereco();
				incidenteEndereco.setId( rs.getInt("id") );
				incidenteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				
			}
			return incidenteEndereco;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public void inserir(incidenteEndereco incidenteEndereco){
		String query = "insert into incidenteEndereco (paciente,endereco) values (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,new PacienteDAO().getPacienteById().getId());
			pstmt.setInt(2,new EnderecoDAO().getEnderecoById().getId());
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(incidenteEndereco incidenteEndereco){
		String query = "update incidenteEndereco set paciente=?,endereco=?, where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,new PacienteDAO().getPacienteById().getId());
			pstmt.setInt(2,new EnderecoDAO().getEnderecoById().getId());
			pstmt.setInt(3, incidenteEndereco.getId());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void excluir(int id){
		String query = "delete from incidenteEndereco where id = ?";
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

	public void setListaincidenteEnderecos(ArrayList<incidenteEndereco> listaincidenteEnderecos) {
		this.listaincidenteEnderecos = listaincidenteEnderecos;
	}	
}