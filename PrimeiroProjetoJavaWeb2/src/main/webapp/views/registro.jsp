<%@ page language="java"  isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body class = "bodyOutro">

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
	<div class = "registrobox">
			<div class = "contact-title">
				<h1>Cadastre-se aqui</h1>
				<h3>Você não pode comprar felicidade mas pode comprar rapadura que é quase a mesma coisa</h3>
			</div>
			<form method = "post" action = "Controller">
			<input type="hidden" name="pagina" value="registro-formulario">
			<font color="white"><c:out value="${msg }"></c:out></font>
			<p>Nome</p>
			<input type = "text" name = "nome" placeholder = "Digite o seu nome" value = "<c:out value="${nome}"></c:out>" required>
			<p>Email</p>
			<input type = "text" name = "email" placeholder = "Digite o seu e-mail" value = "<c:out value="${email}"></c:out>" required>
			<p>Endereco</p>
			<input type = "text" name = "endereco" placeholder = "Digite seu endereco" value = "<c:out value="${endereco}"></c:out>" required>
			<p>Usuario</p>
			<input type = "text" name = "usuario" placeholder = "Digite um nome de usuário" value = "<c:out value="${usuario}"></c:out>" required>
			<p>Senha</p>
			<input type = "password" name = "senha" placeholder = "Digite uma senha">
			<p>Confirme a senha</p>
			<input type = "password" name = "senha2" placeholder = "Confirme a senha">
			<input type = "submit" name = "botao" value = "Cadastrar">
	
			</form>
	</div>
	
	</div>
	
		<footer>
		<div class="footer"> &copy;<script>document.write(new Date().getFullYear());</script>
	      <a href="Controller?pagina=index"> rapaduralivre.com</a>
	    </div>
	</footer>
</body>
</html>