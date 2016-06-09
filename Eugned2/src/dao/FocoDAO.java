package dao;
/**
 * @author wagmattei
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Foco;
import util.ConnectionUtil;

public class FocoDAO {

		private ArrayList<Foco> listaFocos = new ArrayList<Foco>();
		
		private Connection con = ConnectionUtil.getConnection();
		
		public List<Foco> getListaFocos(){
			try {
				Statement stmt = con.createStatement();
				String query = "select * from foco";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()){
					Foco foco = new Foco();
					foco.setId( rs.getInt("id") );
					foco.setDataFoco( rs.getDate("dataFoco") );
					// Para pegar o objeto endereco devemos recuperar o idEndereco da tabela Foco
					// e com este id usar o EnderecoDAO e recuperar o objeto endereco a partir do id.
					foco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
					
					listaFocos.add(foco);
				}
				return listaFocos;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public List<Foco> getListaFocosByNome(String nome){
			String query = "select * from Foco where nome like ?";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, nome);
				ResultSet rs = pstmt.executeQuery(query);
				while (rs.next()){
					Foco foco = new Foco();
					foco.setId( rs.getInt("id") );
					foco.setDataFoco( rs.getDate("dataFoco") );
					// Para pegar o objeto endereco devemos recuperar o idEndereco da tabela Foco
					// e com este id usar o EnderecoDAO e recuperar o objeto endereco a partir do id.
					foco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
					
					listaFocos.add(foco);
				}
				return listaFocos;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public Foco getFocoById(int id){
			String query = "select * from Foco where id = ?";
			try {
				Foco foco = null; 
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery(query);
				while (rs.next()){
					foco = new Foco();
					foco.setId( rs.getInt("id") );
					foco.setDataFoco( rs.getDate("dataFoco") );
					// Para pegar o objeto endereco devemos recuperar o idEndereco da tabela Foco
					// e com este id usar o EnderecoDAO e recuperar o objeto endereco a partir do id.
					foco.setEndereco(new EnderecoDao().getEnderecoById(rs.getInt("idEndereco")));
				}
				return foco;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		
		public void inserir(Foco foco){
			String query = "insert into foco (dataFoco) values (?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(foco.getDataFoco().getTime()));
				pstmt.setInt(2,foco.getEndereco().getId() );
				pstmt.execute();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void editar(Foco foco){
			String query = "update foco set dataFoco=?, idEndereco=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(foco.getDataFoco().getTime()));
				pstmt.setInt(2, foco.getEndereco().getId());
				pstmt.setInt(3, foco.getId());
				pstmt.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		public void excluir(int id){
			String query = "delete from foco where id = ?";
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
				
		public void setListaFocos(ArrayList<Foco> listaFocos) {
			this.listaFocos = listaFocos;
		}
		
	
	
}
