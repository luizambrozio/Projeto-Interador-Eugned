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
import java.util.Date;
import java.util.List;

import model.Foco;
import util.ConnectionUtil;

public class FocoDAO {

		private ArrayList<Foco> listaFocos = new ArrayList<Foco>();
		
		private Connection con = ConnectionUtil.getConnection();
		/**
		 * Carrega todos os focos do banco de dados para manipulação posterior
		 * @return Lista de Objetos Focus
		 */
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
		
		/**
		 * Carrega todos os focos que ocorreram em um período
		 * @return Lista de Objetos Focus
		 */
		public List<Foco> getListaFocosByData(Date dataIni, Date dataFim){
			String query = "select * from Foco where dataFoco BETWEEN ? AND ?";
			if(dataFim == null) {
				dataFim = dataIni;				
			}
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(dataIni.getTime()));
				pstmt.setDate(1, new java.sql.Date(dataFim.getTime()));
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

		/**
		 * Carrega um Foco pelo Id
		 * @return Foco
		 */		
		public Foco getFocoById(int id){
			String query = "select * from foco where id = ?";
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

		/**
		 * Insere um registro de foco no banco de dados
		 * Para que o foco possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */

		public void inserir(Foco foco){
			String query = "insert into foco (dataFoco,idEndereco) values (?,?)";
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
		
		/**
		 * Edita o registro do foco no banco de dados
		 * Para que o foco possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */
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
		
		/**
		 * Exclui um foco informando o id
		 * Para que o foco possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */
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
				
		/**
		 * Seta uma lista de focos para teste
		 * @param listaFocos
		 * @return nada
		 */
		public void setListaFocos(ArrayList<Foco> listaFocos) {
			this.listaFocos = listaFocos;
		}
		
	
	
}
