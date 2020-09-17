package br.com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


import br.com.ecommerce.beans.Produto;
import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.utils.BeanUtilities;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");
		if(pagina == null) {
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");
		if(pagina.equals("admin-login-form")) {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			
			if(usuario.equals("admin") && senha.equals("admin@1234")) {
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);

			}
			else {
				request.setAttribute("msg", "Usuario ou senha errado");
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);

			}
		}
		if(pagina.equals("deletar")) {
			String id = request.getParameter("id");
			ProdutoDao produtodao = new ProdutoDao();
			try {
				produtodao.deletarProduto(id);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);  
			JOptionPane.showMessageDialog(dialog, "Produto excluido com sucesso");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);

		}
		if(pagina.equals("index")) {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		if(pagina.equals("adicionarproduto")) {
			request.getRequestDispatcher("admin/adicionarproduto.jsp").forward(request, response);
		}
		if(pagina.equals("adicionar-produto-form")){
			String nome = request.getParameter("nome");
			String preco = request.getParameter("preco");
			String categoria = request.getParameter("categoria");
			String imagem = request.getParameter("imagem");
			
			Produto p = new Produto();
			
			p.setNome(nome);
			p.setPreco(preco);
			p.setCategoria(categoria);
			p.setImagem("img/"+imagem);
			
			ProdutoDao produtodao = new ProdutoDao();
			
			try {
				produtodao.adicionarProduto(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, "Produto adicionado com sucesso");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		if(pagina.equals("editar-produto")){

			Produto p = new Produto();
			BeanUtilities.populateBean(p, request);

			
			ProdutoDao produtodao = new ProdutoDao();
			try {
				produtodao.editarProduto(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, "Produto atualizado com sucesso");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		if(pagina.equals("editar")) {
			String id = request.getParameter("id");
			ProdutoDao produtodao = new ProdutoDao();
			Produto p = null;
			try {
				 p = produtodao.listarProdutos(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("p", p);
			request.getRequestDispatcher("admin/editarproduto.jsp").forward(request, response);
		}

	}
}
