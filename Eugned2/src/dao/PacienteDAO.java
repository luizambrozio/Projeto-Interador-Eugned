/**
 * @author ambrozio
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.EnumCorRaca;
import model.EnumEscolaridade;
import model.EnumEstadoCivil;
import model.EnumSexo;
import model.Paciente;
import util.ConnectionUtil;

public class PacienteDAO {
	
	private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
	
	private Connection con = ConnectionUtil.getConnection();
	/**
	 * Carrega todos os Pacientes do banco de dados para manipulação posterior
	 * @return Lista de Objetos Paciente
	 */
	public List<Paciente> getListaPacientes(){
		try {
			Statement stmt = con.createStatement();
			String query = "select * from paciente";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()){
				Paciente paciente = new Paciente();
				
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));           
				paciente.setRg(rs.getString("rg"));            
				paciente.setEscolaridade(EnumEscolaridade.values()[rs.getInt("escolaridade")-1]);  
				paciente.setEstadoCivil(EnumEstadoCivil.values()[rs.getInt("estadoCivil")-1]);   
				paciente.setSexo(EnumSexo.values()[rs.getInt("sexo")-1]);          
				paciente.setCorRaca(EnumCorRaca.values()[rs.getInt("corRaca")-1]); 
				paciente.setDataNascimento(rs.getDate("dataNascimento"));  
				paciente.setRendaFamiliar(rs.getFloat("rendaFamiliar"));
				paciente.setGestante(rs.getInt("gestante")==1);
				
				listaPacientes.add(paciente);
			}
			return listaPacientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Paciente> getListaPacientesByNome(String nome){
		String query = "select * from paciente where nome like ?";	
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%"+nome+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Paciente paciente = new Paciente();
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));           
				paciente.setRg(rs.getString("rg"));            
				paciente.setEscolaridade(EnumEscolaridade.values()[rs.getInt("escolaridade")-1]);  
				paciente.setEstadoCivil(EnumEstadoCivil.values()[rs.getInt("estadoCivil")-1]);   
				paciente.setSexo(EnumSexo.values()[rs.getInt("sexo")-1]);          
				paciente.setCorRaca(EnumCorRaca.values()[rs.getInt("corRaca")-1]); 
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

	/**
	 * Carrega um Paciente pelo Id
	 * @return Paciente
	 */		
	public Paciente getPacienteById(int id){
		String query = "select * from paciente where id = ?" ;
		try {
			Paciente paciente = null; 
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			paciente = new Paciente();
			paciente.setId(rs.getInt("id"));
			paciente.setNome(rs.getString("nome"));
			paciente.setCpf(rs.getString("cpf"));           
			paciente.setRg(rs.getString("rg"));            
			paciente.setEscolaridade(EnumEscolaridade.values()[rs.getInt("escolaridade")-1]);  
			paciente.setEstadoCivil(EnumEstadoCivil.values()[rs.getInt("estadoCivil")-1]);   
			paciente.setSexo(EnumSexo.values()[rs.getInt("sexo")-1]);          
			paciente.setCorRaca(EnumCorRaca.values()[rs.getInt("corRaca")-1]); 
			paciente.setDataNascimento(rs.getDate("dataNascimento"));  
			paciente.setRendaFamiliar(rs.getFloat("rendaFamiliar"));
			paciente.setGestante(rs.getInt("gestante")==1);
			
				
			return paciente;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public void inserir(Paciente paciente){		            
		 
		String query = "insert into paciente (nome, cpf, rg, escolaridade, estadoCivil, sexo, corRaca, dataNascimento, rendaFamiliar, gestante) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, paciente.getNome());
			pstmt.setString(2, paciente.getCpf());
			pstmt.setString(3, paciente.getRg());
			pstmt.setInt(4, paciente.getEscolaridade().getCodigo());
			pstmt.setInt(5, paciente.getEstadoCivil().getCodigo());
			pstmt.setInt(6, paciente.getSexo().getCodigo());
			pstmt.setInt(7, paciente.getCorRaca().getCodigo());
			pstmt.setDate(8, new java.sql.Date(paciente.getDataNascimento().getTime()));
			pstmt.setFloat(9, paciente.getRendaFamiliar());
			pstmt.setInt(10, paciente.getGestante() ? 1 : 0);
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			con.commit();
			if (rs.next() ){
				paciente.setId(rs.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Paciente paciente){
		String query = "update paciente set nome=?, cpf=?, rg=?, escolaridade=?, estadoCivil=?, sexo=?, corRaca=?, dataNascimento=?, rendaFamiliar=?, gestante=? where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println(paciente.toString());
			System.out.println(paciente.getEscolaridade().getCodigo());
			pstmt.setString(1, paciente.getNome());
			pstmt.setString(2, paciente.getCpf());
			pstmt.setString(3, paciente.getRg());
			pstmt.setInt(4, paciente.getEscolaridade().getCodigo());
			pstmt.setInt(5, paciente.getEstadoCivil().getCodigo());
			pstmt.setInt(6, paciente.getSexo().getCodigo());
			pstmt.setInt(7, paciente.getCorRaca().getCodigo());
			pstmt.setDate(8, new java.sql.Date(paciente.getDataNascimento().getTime()));
			pstmt.setFloat(9, paciente.getRendaFamiliar());
			pstmt.setInt(10, paciente.getGestante() ? 1 : 0);
			pstmt.setInt(11, paciente.getId());
			
			pstmt.executeUpdate();
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
		String query = "delete from paciente where id = ?";
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
	public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

}