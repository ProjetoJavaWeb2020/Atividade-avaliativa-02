package br.com.ecommerce.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.ecommerce.model.*;
import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.dao.UsuarioDao;
import br.com.ecommerce.utils.UtilSession;

@ManagedBean
public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuariodao = new UsuarioDao();
	private Usuario usuario = new Usuario();
    String senhaConfirmacao = "";
	String mensagem = "";
	HttpSession sessao;
	ArrayList<String> carrinhoLista = new ArrayList();
	List<Produto> listaProdutos;
	
	public void init() {
		
	}
	
	
	public ArrayList<String> getCarrinhoLista() {
		return carrinhoLista;
	}
	public void setCarrinhoLista(ArrayList<String> carrinhoLista) {
		this.carrinhoLista = carrinhoLista;
	}
	public HttpSession getSessao() {
		return sessao;
	}
	public void setSessao(HttpSession sessao) {
		this.sessao = sessao;
	}
	public UsuarioDao getUsuariodao() {
		return usuariodao;
	}
	public void setUsuariodao(UsuarioDao usuariodao) {
		this.usuariodao = usuariodao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}
	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getsalvar(){
		if(usuario.getSenha().equals(this.senhaConfirmacao)) {
			usuariodao.salvar(usuario);
			return "login";
		}
		
		this.mensagem = "As senhas devem ser iguais";	
		return "";
			
	
	}
	
	public String getLogin(){
		List<Usuario> usuarios = usuariodao.findAll();
		
		for(Usuario user : usuarios) {
			if(user.getUsuario().equals(usuario.getUsuario()) && user.getSenha().equals(usuario.getSenha())) {
				sessao = UtilSession.getSession();
				sessao.setAttribute("usuario", usuario.getUsuario());
				sessao.setAttribute("carrinhoLista", carrinhoLista);
				return "index";
			}
		}
		
		this.mensagem = "Usuario invalido";	
		return "";
		
		
	}
	
	public String getLogout() {
		sessao = UtilSession.getSession();
		sessao.invalidate();

		/*
		 * sessao = UtilSession.getSession(); carrinhoLista.clear();
		 * sessao.setAttribute("carrinhoLista", carrinhoLista);
		 */
	    return "index";
	}
	
	public String getadicionarCarrinho(String id) {
		Produto p = new Produto();
		boolean checar = p.checar(carrinhoLista,id);
		
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  
		
		if(checar)
			JOptionPane.showMessageDialog(dialog, "Produto já foi adicionado ao carrinho");
		else {
			carrinhoLista.add(id);
			JOptionPane.showMessageDialog(dialog, "Produto foi adicionado ao carrinho com sucesso");
		}
		
		ProdutoDao produtodao = new ProdutoDao();
		try {
			listaProdutos = produtodao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sessao = UtilSession.getSession();
		sessao.setAttribute("carrinhoLista", carrinhoLista);
	

		
		return "";
	}
	
	public String getremoverItem(String id) {
		Produto p = new Produto();
		carrinhoLista = p.remover(carrinhoLista,id);
		return "";
		
	}
	
	

}
