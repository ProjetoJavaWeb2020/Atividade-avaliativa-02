package br.com.ecommerce.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.model.Produto;


@ManagedBean (name = "produtoBean")
public class ProdutoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private ProdutoDao produtodao = new ProdutoDao();
	private Produto produto = new Produto();
	private List<Produto> listaProduto;
	String mensagem = "";
	
	@PostConstruct
	public void init() {
		listaProduto = produtodao.findAll();
	}
	
	public ProdutoDao getProdutodao() {
		return produtodao;
	}

	public void setProdutodao(ProdutoDao produtodao) {
		this.produtodao = produtodao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
}
