package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import util.ConnectionUtil;

public class EnderecoDao {

	private ArrayList<Endereco> listaEnderecos = new ArrayList<Endereco>();
	
	private Connection con = ConnectionUtil.getConnection();
	
	public List<Endereco> getListaEnderecos(){
		try {
			Statement stmt = con.createStatement();
			String query = "select * from endereco";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				Endereco endereco = new Endereco();
				endereco.setId( rs.getInt("id") );
				endereco.
				
				//Endereco.setDataEndereco( rs.getDate("dataEndereco") );
				//Endereco.setCpf( rs.getString("cpf") );
				
				listaEnderecos.add(Endereco);
			}
			return listaEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Endereco> getListaEnderecosByNome(String nome){
		String query = "select * from Endereco where nome like ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nome);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()){
				Endereco Endereco = new Endereco();
				Endereco.setId( rs.getInt("id") );
				Endereco.setDataEndereco( rs.getDate("dataEndereco") );
				//Endereco.setCpf( rs.getString("cpf") );
				
				listaEnderecos.add(Endereco);
			}
			return listaEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void inserir(Endereco Endereco){
		String query = "insert into Endereco (dataEndereco) values (?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, new java.sql.Date(Endereco.getDataEndereco().getTime()));
			//pstmt.setInt(2, 0);
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Endereco Endereco){
		String query = "update Endereco set dataEndereco=?, idEndereco=? where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDate(1, new java.sql.Date(Endereco.getDataEndereco().getTime()));
			pstmt.setInt(2, Endereco.getEndereco().getId());
			pstmt.setInt(3, Endereco.getId());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void excluir(int id){
		String query = "delete from Endereco where id = ?";
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
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static EnderecoDAO EnderecoDao;
//	
//	public static EnderecoDAO obterInstancia(){
//		if ( EnderecoDao == null){
//			EnderecoDao = new EnderecoDAO();
//		}
//		return EnderecoDao;
//	}

//	public ArrayList<Endereco> getListaEnderecos() {
//		return listaEnderecos;
//	}

	public void setListaEnderecos(ArrayList<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	



	
}
