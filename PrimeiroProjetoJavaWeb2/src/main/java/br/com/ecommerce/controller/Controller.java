package br.com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import br.com.ecommerce.beans.*;
import br.com.ecommerce.dao.*;
import br.com.ecommerce.utils.BeanUtilities;


/**
 * Servlet implementation class UsuarioController
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Produto> listaProdutos = new ArrayList();
	static ArrayList<String> carrinhoLista = new ArrayList();
	HttpSession sessao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");

		if(pagina == null || pagina.equals("index")) {
			ProdutoDao produtodao = new ProdutoDao();
			try {
				listaProdutos = produtodao.listarProdutos();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			sessao = request.getSession();
			sessao.setAttribute("carrinhoLista", carrinhoLista);
			sessao.setAttribute("listaProdutos", listaProdutos);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}else {
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = request.getParameter("pagina");


		if(pagina.equals("produtos") || pagina.equals("bombons") || pagina.equals("donuts") || pagina.equals("pirulitos") || pagina.equals("chocolates") || pagina.equals("rapadura")) {

			ProdutoDao produtodao = new ProdutoDao();
			try {
				listaProdutos = produtodao.listarProdutos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("listaProdutos", listaProdutos);

			if(pagina.equals("bombons"))
				request.getRequestDispatcher("views/bombons.jsp").forward(request, response);
			if(pagina.equals("donuts"))
				request.getRequestDispatcher("views/donuts.jsp").forward(request, response);
			if(pagina.equals("pirulitos"))
				request.getRequestDispatcher("views/pirulitos.jsp").forward(request, response);
			if(pagina.equals("chocolates"))
				request.getRequestDispatcher("views/chocolates.jsp").forward(request, response);
			if(pagina.equals("rapadura"))
				request.getRequestDispatcher("views/rapadura.jsp").forward(request, response);
			if(pagina.equals("produtos"))
				request.getRequestDispatcher("views/produtos.jsp").forward(request, response);
		}
		if(pagina.equals("login")) {
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
		if(pagina.equals("registro")) {
			request.getRequestDispatcher("views/registro.jsp").forward(request, response);
		}
		if(pagina.equals("login-formulario")) {
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			UsuarioDao usuariodao = new UsuarioDao();
			Usuario u = new Usuario();

			try {
				u = usuariodao.checarUsuario(usuario, senha);
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			if(u != null) {
				sessao = request.getSession();
				sessao.setAttribute("sessao", sessao);
				sessao.setAttribute("endereco",u.getEndereco());
				sessao.setAttribute("email",u.getEmail());
				sessao.setAttribute("nome",u.getNome());
				sessao.setAttribute("usuario",u.getUsuario());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Usuario inválido");
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("views/login.jsp").forward(request, response);

			}

		}
		if(pagina.equals("registro-formulario")) {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String usuario = request.getParameter("usuario");
			String endereco = request.getParameter("endereco");
			String senha = request.getParameter("senha");
			String senha2 = request.getParameter("senha2");

			if(senha.equals(senha2)) {
				Usuario u = new Usuario();
				UsuarioDao usuariodao = new UsuarioDao();
				BeanUtilities.populateBean(u, request);

				try {
					usuariodao.cadastrarUsuario(u);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.setAttribute("usuario", usuario);
				request.setAttribute("email", email); 
				request.setAttribute("usuario",usuario); 
				request.setAttribute("endereco", endereco);
				request.setAttribute("senha", senha);

				request.setAttribute("msg", "Conta criada com sucesso, Por favor, logue-se!");
				request.getRequestDispatcher("views/login.jsp").forward(request, response);

			}else {
				request.setAttribute("msg", "As senhas devem ser iguais");
				request.setAttribute("nome", nome);
				request.setAttribute("endereco", endereco);
				request.setAttribute("email", email);
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("views/registro.jsp").forward(request, response);
			}

		}
		if(pagina.equals("sair")) {
			sessao = request.getSession();
			sessao.invalidate();

			sessao = request.getSession();
			carrinhoLista.clear();
			sessao.setAttribute("carrinhoLista", carrinhoLista);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if(pagina.equals("carrinho")) {
			request.getRequestDispatcher("views/carrinho.jsp").forward(request, response);
		}
		if(pagina.equals("adicionarCarrinho")){
			String id = request.getParameter("id");
			String acao = request.getParameter("acao");;
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
				listaProdutos = produtodao.listarProdutos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sessao = request.getSession();
			sessao.setAttribute("carrinhoLista", carrinhoLista);
			sessao.setAttribute("listaProdutos", listaProdutos);

			request.setAttribute("listaProdutos", listaProdutos);
			
			if(acao.equals("index"))
				request.getRequestDispatcher("index.jsp").forward(request, response);
			if(acao.equals("bombons"))
				request.getRequestDispatcher("views/bombons.jsp").forward(request, response);
			if(acao.equals("donuts"))
				request.getRequestDispatcher("views/donuts.jsp").forward(request, response);
			if(acao.equals("pirulitos"))
				request.getRequestDispatcher("views/pirulitos.jsp").forward(request, response);
			if(acao.equals("chocolates"))
				request.getRequestDispatcher("views/chocolates.jsp").forward(request, response);
			if(acao.equals("rapadura"))
				request.getRequestDispatcher("views/rapadura.jsp").forward(request, response);
			if(acao.equals("produtos"))
				request.getRequestDispatcher("views/produtos.jsp").forward(request, response);
		}
		if(pagina.equals("sucesso")) {

			request.getRequestDispatcher("views/sucesso.jsp").forward(request, response);
			/*session = request.getSession();
			 cartlist.clear();
			 session.setAttribute("cartlist", cartlist);*/
		}
		if(pagina.equals("remove")) {
			String id = request.getParameter("id");
			Produto p = new Produto();
			carrinhoLista = p.remover(carrinhoLista,id);
			
			sessao = request.getSession();
			sessao.setAttribute("carrinhoLista", carrinhoLista);
			request.getRequestDispatcher("views/carrinho.jsp").forward(request, response);
		}
	}

}
