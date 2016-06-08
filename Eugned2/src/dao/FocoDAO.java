package dao;

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
				String query = "select * from Foco";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()){
					Foco foco = new Foco();
					foco.setId( rs.getInt("id") );
					foco.setDataFoco( rs.getDate("dataFoco") );
					//foco.setCpf( rs.getString("cpf") );
					
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
					//foco.setCpf( rs.getString("cpf") );
					
					listaFocos.add(foco);
				}
				return listaFocos;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public void inserir(Foco Foco){
			String query = "insert into foco (dataFoco) values (?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(Foco.getDataFoco().getTime()));
				//pstmt.setInt(2, 0);
				pstmt.execute();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void editar(Foco Foco){
			String query = "update Foco set dataFoco=?, idEndereco=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(Foco.getDataFoco().getTime()));
				pstmt.setInt(2, Foco.getEndereco().getId());
				pstmt.setInt(3, Foco.getId());
				pstmt.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		public void excluir(int id){
			String query = "delete from Foco where id = ?";
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
		
		
		
		
		
		
		
		
		
		
		
		
		
//		private static FocoDAO FocoDao;
	//	
//		public static FocoDAO obterInstancia(){
//			if ( FocoDao == null){
//				FocoDao = new FocoDAO();
//			}
//			return FocoDao;
//		}

//		public ArrayList<Foco> getListaFocos() {
//			return listaFocos;
//		}

		public void setListaFocos(ArrayList<Foco> listaFocos) {
			this.listaFocos = listaFocos;
		}
		
	
	
}
