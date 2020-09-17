package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ecommerce.beans.Usuario;
import br.com.ecommerce.utils.DbUtil;


public class UsuarioDao {
	
	private Connection connection;
	ArrayList<Usuario> listaUsuarios = new ArrayList();
	
	public UsuarioDao() {
		connection = DbUtil.getConnection();
	}
	
	public ArrayList<Usuario> listarUsuarios(){
		String sql = "select * from usuarios";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Usuario u = new Usuario();
				
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setEndereco(rs.getString("endereco"));
				u.setEmail(rs.getString("email"));
				u.setUsuario(rs.getString("usuario"));
				u.setSenha(rs.getString("senha"));
				listaUsuarios.add(u);
			}
			
			st.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}
	
	
	public Usuario checarUsuario(String usuario, String senha) throws SQLException{
		    Usuario u = new Usuario();
			String sql = "select * from usuario where usuario = ? and senha = ?";
			
			PreparedStatement st = connection.prepareStatement(sql);
	
			st.setString(1, usuario);
			st.setString(2, senha);
			
			ResultSet rs = st.executeQuery();
			
			boolean teste = rs.next();
			
			if(!teste) {
				u = null;
			}
			else {
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setEndereco(rs.getString("endereco"));
				u.setEmail(rs.getString("email"));
				u.setUsuario(rs.getString("usuario"));
				u.setSenha(rs.getString("senha"));
			}
			st.close();
		
		return u;
	}
	
	public void cadastrarUsuario(Usuario usuario) throws SQLException{
		String sql = "insert into usuario(nome, endereco, email, usuario, senha) values(?,?,?,?,?)";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, usuario.getNome());
		st.setString(2, usuario.getEndereco());
		st.setString(3, usuario.getEmail());
		st.setString(4, usuario.getUsuario());
		st.setString(5, usuario.getSenha());
		
		st.executeUpdate();
		
		st.close();
	}

}
