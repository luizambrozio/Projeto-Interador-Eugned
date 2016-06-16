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
import java.util.Date;
import java.util.List;

import model.Incidente;
import util.ConnectionUtil;

public class IncidenteDAO {

		private ArrayList<Incidente> listaIncidentes = new ArrayList<Incidente>();
		
		private Connection con = ConnectionUtil.getConnection();
		/**
		 * Carrega todos os Incidentes do banco de dados para manipulação posterior
		 * @return Lista de Objetos Incidente
		 */
		public List<Incidente> getListaIncidentes(){
			try {
				Statement stmt = con.createStatement();
				String query = "select * from incidente";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()){
					Incidente incidente = new Incidente();
					incidente.setId( rs.getInt("id") );
					incidente.setDataIncidente( rs.getDate("dataIncidente") );
					incidente.setDataSintoma( rs.getDate("dataSintoma") );
					incidente.setSintomas( rs.getString("sintomas") );
					incidente.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
					
					listaIncidentes.add(incidente);
				}
				return listaIncidentes;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		/**
		 * Carrega todos os Incidentes que ocorreram em um período
		 * @return Lista de Objetos Incidente
		 */
		public List<Incidente> getListaIncidentesByData(Date dataIni, Date dataFim){
			String query = "select * from Incidente where dataIncidente BETWEEN ? AND ?";
			if(dataFim == null) {
				dataFim = dataIni;				
			}
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(dataIni.getTime()));
				pstmt.setDate(1, new java.sql.Date(dataFim.getTime()));
				ResultSet rs = pstmt.executeQuery(query);
				while (rs.next()){
					Incidente incidente = new Incidente();
					incidente.setId( rs.getInt("id") );
					incidente.setDataIncidente( rs.getDate("dataIncidente") );
					incidente.setDataSintoma( rs.getDate("dataSintoma") );
					incidente.setSintomas( rs.getString("sintomas") );
					incidente.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
					
					listaIncidentes.add(incidente);
				}
				return listaIncidentes;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * Carrega um Incidente pelo Id
		 * @return Incidente
		 */		
		public Incidente getIncidenteById(int id){
			String query = "select * from Incidente where id = ?";
			try {
				Incidente incidente = null; 
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery(query);
				while (rs.next()){
					incidente = new Incidente();
					incidente.setId( rs.getInt("id") );
					incidente.setDataIncidente( rs.getDate("dataIncidente") );
					incidente.setDataSintoma( rs.getDate("dataSintoma") );
					incidente.setSintomas( rs.getString("sintomas") );
					incidente.setPaciente(new PacienteDAO().getPacienteById(rs.getInt("idPaciente")));
					}
				return incidente;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * Insere um registro de Incidente no banco de dados
		 * Para que o Incidente possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */

		public void inserir(Incidente incidente){
			String query = "insert into incidente (dataIncidente,dataSintoma,sintomas,idPaciente) values (?,?,?,?)";
			try {
				PreparedStatement pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				pstmt.setDate(1, new java.sql.Date(incidente.getDataIncidente().getTime()));
				pstmt.setDate(2, new java.sql.Date(incidente.getDataSintoma().getTime()));
				pstmt.setString(3,incidente.getSintomas() );
				pstmt.setInt(4,incidente.getPaciente().getId());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				con.commit();
				if (rs.next() ){
					incidente.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/**
		 * Edita o registro do Incidente no banco de dados
		 * Para que o Incidente possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */
		public void editar(Incidente incidente){
			String query = "update Incidente set dataIncidente=?, dataSintoma=?,Sintoma=? where id=?";
			try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setDate(1, new java.sql.Date(incidente.getDataIncidente().getTime()));
				pstmt.setDate(2, new java.sql.Date(incidente.getDataSintoma().getTime()));
				pstmt.setString(3,incidente.getSintomas() );
				pstmt.setInt(4,incidente.getPaciente().getId());
				pstmt.setInt(5, incidente.getId());
				pstmt.executeUpdate();
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		/**
		 * Exclui um Incidente informando o id
		 * Para que o Incidente possa ser inserido o objeto endereço já deve estar persistido no banco de dados 
		 * @return nada
		 */
		public void excluir(int id){
			String query = "delete from Incidente where id = ?";
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
		 * Seta uma lista de Incidentes para teste
		 * @param listaIncidentes
		 * @return nada
		 */
		public void setListaIncidentes(ArrayList<Incidente> listaIncidentes) {
			this.listaIncidentes = listaIncidentes;
		}
		
	
	
}