package br.com.ecommerce.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_produto")
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id                   //chave primária
	@GeneratedValue       //auto-incremento
	private int id;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "preco")
	private String preco;
	
	@Column (name = "categoria")
	private String categoria;
	
	@Column (name = "imagem")
	private String imagem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public boolean checar(ArrayList<String> carrinhoLista, String id) {
		for(String cid : carrinhoLista) {
			if(cid.equals(id))
				return true;
		}
		return false;
	}
	public ArrayList<String> remover(ArrayList<String> carrinhoLista, String id) {
		for(String cid : carrinhoLista) {
			if(cid.equals(id)) {
				carrinhoLista.remove(cid);
				break;
			}
				
		}
		
		return carrinhoLista;
	}
	

}
