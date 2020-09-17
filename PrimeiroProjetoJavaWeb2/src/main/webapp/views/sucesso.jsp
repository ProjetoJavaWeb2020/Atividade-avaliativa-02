<%@page import="javax.swing.JDialog"%>
<%@page import="br.com.ecommerce.beans.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java"  isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body>

		<c:set var="x" value="0"></c:set>
	<c:forEach items="${carrinhoLista }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<header>
		<h1 class = "title">
			Rapadura Livre
		</h1>
		<nav>
			<ul>
				<li><a href = "Controller?pagina=index">Home</a></li>
				<li><a href = "Controller?pagina=produtos">Produtos</a></li>
			<c:choose>
				<c:when test="${sessao == null}">
					<li><a href = "Controller?pagina=login">Login</a></li>
					<li><a href = "Controller?pagina=registro">Inscreva-se</a></li>
				</c:when>
				<c:when test="${sessao != null}">
					<li><a href="Controller?pagina=sair">Sair</a></li>
					<li><a href="#">Minha conta(<c:out value="${usuario}"></c:out>)</a></li>
				</c:when>
			</c:choose>
			<li><a href="Controller?pagina=carrinho">Carrinho(<c:out value="${x}"/>)</a><img src = "img/shopping-cart.png" width = "30px" height = "30px"></li>
			
			</ul>
		</nav>
	</header>
	
	<div class = "conteudo">
	
	<c:choose>
		<c:when test="${sessao == null}">
				<%
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);  
				JOptionPane.showMessageDialog(dialog, "Por favor, faça login primeiro");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				%>
		</c:when>
		
		<c:when test="${x == 0}">
				
				<%
				final JDialog dialog = new JDialog();
				dialog.setAlwaysOnTop(true);  
				JOptionPane.showMessageDialog(dialog, "Seu carrinho está vazio");
				request.getRequestDispatcher("carrinho.jsp").forward(request, response);
				%>
		</c:when>
		
		<c:when test="${sessao != null}">
				
				
				<div style="margin-top: 60px;margin-bottom: 60px;">
					<h4>Obrigado(a) <font color="#6bb1f8"><c:out value="${nome }"></c:out></font> por comprar conosco. Nós recebemos seu pedido e enviaremos para o endereço <font color="#6bb1f8"><c:out value="${endereco }"></c:out></font> em 4-5 dias úteis.</h4>
					<h4>A confirmação da compra foi enviada para seu e-mail <font color="#6bb1f8"><c:out value="${email }"></c:out></font>.</h4>
					
					<br><br>
					<a href="Controller?pagina=index"><input type="button" value="Continue comprando" style="width:100%;padding:8px;font-size:16px;"></a>
				</div>
			
		</c:when>
	
	</c:choose>
	
	</div>

		<footer>
		<div class="footer"> &copy;<script>document.write(new Date().getFullYear());</script>
	      <a href="Controller?pagina=index"> rapaduralivre.com</a>
	    </div>
	</footer>
</body>
</html>