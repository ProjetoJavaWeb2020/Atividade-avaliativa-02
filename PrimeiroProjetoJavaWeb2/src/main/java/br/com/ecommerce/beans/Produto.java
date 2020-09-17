package br.com.ecommerce.beans;

import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome;
	private String preco;
	private String categoria;
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
