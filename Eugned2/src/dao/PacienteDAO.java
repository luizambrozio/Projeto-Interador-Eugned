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
import java.util.List;

import model.Paciente;
import util.ConnectionUtil;

public class PacienteDAO {
	
private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	public List<Paciente> getListaPacientes(){
		Statement stmt;
		try {
			stmt = con.createStatement();
			String query = "select * from paciente";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Paciente c = new Paciente();
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				
				listaPacientes.add(c);
			}
			return listaPacientes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void inserir(Paciente paciente){
		String query = "insert into Paciente(id, nome, cpf, rg, escolaridade, estadoCivil, sexo, corRaca, dataNascimento, rendaFamiliar, gestante) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, paciente.getId());
			pstmt.setString(2, paciente.getNome());
			pstmt.setString(3, paciente.getCpf());
			pstmt.setString(4, paciente.getRg());
			pstmt.setString(5, paciente.getEscolaridade());
			pstmt.setString(6, paciente.getEstadoCivil());
			pstmt.setString(7, paciente.getSexo());
			pstmt.setString(8, paciente.getCorRaca());
			pstmt.setDate(9, new java.sql.Date(paciente.getDataNascimento().getTime()));
			pstmt.setFloat(10, paciente.getRendaFamiliar());
			pstmt.setBoolean(11, paciente.getGestante());
			pstmt.execute();
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar (Paciente paciente){
		String query = "update Paciente set nome=?, CPF=? where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, paciente.getNome());
			pstmt.setString(2, paciente.getCpf());
			pstmt.setInt(3, paciente.getId());
			pstmt.executeUpdate();			
			con.commit();
			System.out.println("testedao");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
	}
	
	public void excluir(int id){
		String query = "delete from paciente where id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public List<Paciente> getListaPacientesB(){
		String query = "select * from paciente where nome like '%?%'";
				
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "nome");
			ResultSet rs = pstmt.executeQuery(query);
			
			while (rs.next()) {
				Paciente c =new Paciente();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("CPF"));
				
				listaPacientes.add(c);
			}
			return listaPacientes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

}