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

import com.mysql.jdbc.JDBC4PreparedStatement;

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
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				
				listaEnderecos.add(endereco);
			}
			return listaEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Endereco> getListaEnderecosByRua(String rua){
		String query = "select * from endereco where rua like '	%?%'";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, "aldo");
			System.out.println(((JDBC4PreparedStatement) pstmt).asSql());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Endereco endereco = new Endereco();
				endereco.setId( rs.getInt("id") );
				endereco.setRua( rs.getString("rua") );
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCep(rs.getString("cep"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				
				listaEnderecos.add(endereco);
			}
			return listaEnderecos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Endereco getEnderecoById(int id){
		String query = "select * from endereco where id = ?";
		try {
			Endereco endereco = null;
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(query);
			while (rs.next()){
				System.out.println("Entrou");
				endereco = new Endereco();
				endereco.setId( rs.getInt("id") );
				endereco.setRua( rs.getString("rua") );
				endereco.setNumero(rs.getString("numero"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCep(rs.getString("cep"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				
			}
			return endereco;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public void inserir(Endereco endereco){
		String query = "insert into endereco (rua,numero,bairro,cep,cidade,estado) values (?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, endereco.getRua());
			pstmt.setString(2, endereco.getNumero());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getCep());
			pstmt.setString(5, endereco.getCidade());
			pstmt.setString(6, endereco.getEstado());
			pstmt.execute();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editar(Endereco endereco){
		String query = "update endereco set rua=?,numero=?,bairro=?,cep=?,cidade=?,estado=? where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, endereco.getRua());
			pstmt.setString(2, endereco.getNumero());
			pstmt.setString(3, endereco.getBairro());
			pstmt.setString(4, endereco.getCep());
			pstmt.setString(5, endereco.getCidade());
			pstmt.setString(6, endereco.getEstado());
			pstmt.setInt(7, endereco.getId());
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void excluir(int id){
		String query = "delete from endereco where id = ?";
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

	public void setListaEnderecos(ArrayList<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	



	
}
