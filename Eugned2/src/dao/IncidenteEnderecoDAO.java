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

import model.Incidente;
import model.IncidenteEndereco;
import util.ConnectionUtil;

public class IncidenteEnderecoDAO {

	private ArrayList<IncidenteEndereco> listaincidenteEnderecos = new ArrayList<IncidenteEndereco>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	public List<IncidenteEndereco> getListaincidenteEnderecos(){
		try {
			Statement stmt = con.createStatement();
			String query = "select * from incidente_endereco";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				IncidenteEndereco incidenteEndereco = new IncidenteEndereco();
				incidenteEndereco.setId( rs.getInt("id") );
				incidenteEndereco.setIncidente(new IncidenteDAO().getIncidenteById(rs.getInt("idIncidente")));
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
	
	public IncidenteEndereco getIncidenteEnderecoById(int id){
		String query = "select * from incidente_endereco where id = ?";
		try {
			IncidenteEndereco incidenteEndereco = null;
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Entrou");
				incidenteEndereco = new IncidenteEndereco();
				incidenteEndereco.setIncidente(new IncidenteDAO().getIncidenteById( rs.getInt("idIncidente")));
				incidenteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
			}
			return incidenteEndereco;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
 	}

	public List<IncidenteEndereco> getEnderecosIncidentes(Incidente incidente){
		System.out.println("incidente"+incidente.getId());
		String query = "select * from incidente_endereco where idIncidente = ?";
		List<IncidenteEndereco> listIncidentesEnderecos = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, incidente.getId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				IncidenteEndereco incidenteEndereco = new IncidenteEndereco();
				System.out.println("Entrou");
				//incidenteEndereco = new IncidenteEndereco();
				incidenteEndereco.setId(rs.getInt("id"));
				incidenteEndereco.setIncidente(new IncidenteDAO().getIncidenteById( rs.getInt("idIncidente")));
				incidenteEndereco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				listIncidentesEnderecos.add(incidenteEndereco);
			}
			return listIncidentesEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	public void inserir(IncidenteEndereco incidenteEndereco){
		String query = "insert into incidente_endereco (idIncidente,idEndereco) values (?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,incidenteEndereco.getIncidente().getId());
			pstmt.setInt(2,incidenteEndereco.getEndereco().getId());
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(IncidenteEndereco incidenteEndereco){
		String query = "update incidente_endereco set idIncidente=?,idEndereco=?, where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,incidenteEndereco.getIncidente().getId());
			pstmt.setInt(2,incidenteEndereco.getEndereco().getId());
			pstmt.setInt(3, incidenteEndereco.getId());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(int id){
		System.out.println("excluir incidente_endereço: "+ id);
		String query = "delete from incidente_endereco where id = ?";
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

	public void setListaincidenteEnderecos(ArrayList<IncidenteEndereco> listaincidenteEnderecos) {
		this.listaincidenteEnderecos = listaincidenteEnderecos;
	}	
}