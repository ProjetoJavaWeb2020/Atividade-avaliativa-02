<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width , inital-scale-1.0">
<title>Produtos</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap"
	rel="stylesheet">
</head>
<body class = "bodyOutro">
<c:set var="x" value="0"></c:set>
	<c:forEach items="${carrinhoLista }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>

	<header>
		<h1 class="title">Rapadura Livre</h1>
		<nav>
			<ul>
				<li><a href="Controller?pagina=index">Home</a></li>
				<li><a href="Controller?pagina=produtos">Produtos</a></li>
				<c:choose>
					<c:when test="${sessao == null}">
						<li><a href="Controller?pagina=login">Login</a></li>
						<li><a href="Controller?pagina=registro">Inscreva-se</a></li>
					</c:when>
					<c:when test="${sessao != null}">
						<li><a href="Controller?pagina=sair">Sair</a></li>
						<li><a href="#">Minha conta(<c:out value="${usuario}"></c:out>)</a></li>
					</c:when>
				</c:choose>
				<li><a href="Controller?pagina=carrinho">Carrinho(<c:out value="${x}"/>)</a></li>
			</ul>
		</nav>

	</header>

	<main>

		<div class="row1">

			<div class="col-3">
				<div class="categorias">
					<a href="Controller?pagina=bombons" class="categoria-item">Bombons</a>
					<a href="Controller?pagina=donuts" class="categoria-item">Donuts</a>
					<a href="Controller?pagina=pirulitos" class="categoria-item">Pirulitos</a>
					<a href="Controller?pagina=chocolates" class="categoria-item">Chocolates</a>
					<a href="Controller?pagina=rapadura" class="categoria-item">Rapaduras</a>
				</div>
			</div>

		</div>
		<div class="row">

			<c:forEach items="${listaProdutos}" var="produto">
				<div class="col-4">
					<img src="${produto.getImagem() }">
					<p><c:out value="${produto.getNome() }"></c:out> - R$<c:out value="${produto.getPreco() }"></c:out></p>
					<a href="Controller?pagina=adicionarCarrinho&acao=produtos&id=<c:out value="${produto.getId()}"/>">Adicionar ao Carrinho</a>
				</div>
			</c:forEach>

		</div>
	</main>

	<footer>
		&copy;
		<script>
			document.write(new Date().getFullYear());
		</script>
		<a href="Controller?pagina=index"> RapaduraLivre.com</a>
	</footer>
</body>
</html>