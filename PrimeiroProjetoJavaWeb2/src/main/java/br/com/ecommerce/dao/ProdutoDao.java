package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.ecommerce.beans.Produto;
import br.com.ecommerce.utils.DbUtil;

public class ProdutoDao {
	
	private Connection connection;
	ArrayList<Produto> listaProdutos = new ArrayList();

	public ProdutoDao() {
		connection = DbUtil.getConnection();
	}
	
	public ArrayList<Produto> listarProdutos(){
		
		String sql = "select * from produtos";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getString("preco"));
				p.setCategoria(rs.getString("categoria"));
				p.setImagem(rs.getString("imagem"));
				listaProdutos.add(p);
			}
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaProdutos;
	}
	
	public Produto listarProdutos(String id) {
		Produto p = new Produto();
		try {
			String sql = "select * from produtos where id=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();
			
			
			while(rst.next()){
				
				p.setId(rst.getInt("id"));
				p.setNome(rst.getString("nome"));
				p.setPreco(rst.getString("preco"));
				p.setCategoria(rst.getString("categoria"));
				p.setImagem(rst.getString("imagem"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void deletarProduto(String id){
		try {
		String sql = "delete from produtos where id = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void adicionarProduto(Produto p){
		try {
		String sql = "insert into produtos(nome,preco,categoria,imagem) values(?,?,?,?)";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, p.getNome());
		st.setString(2, p.getPreco());
		st.setString(3, p.getCategoria());
		st.setString(4, p.getImagem());
		
		
		st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void editarProduto(Produto p){
		try {
		String sql = "update produtos set nome = ?,preco = ?,categoria= ? where id= ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, p.getNome());
		st.setString(2, p.getPreco());
		st.setString(3, p.getCategoria());
		
		st.setInt(4, p.getId());
		st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
