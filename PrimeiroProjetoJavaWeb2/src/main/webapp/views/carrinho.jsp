<%@ page language="java" isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
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
		<c:when test="${x == 1}">
						<h4 style="margin-top: 40px;">Meu carrinho de compra (<c:out value="${x}"/> item)</h4>
		</c:when>
		<c:when test="${x > 1}">
						<h4 style="margin-top: 40px;">Meu carrinho de compras (<c:out value="${x}"/> items)</h4>
		</c:when>
		<c:otherwise >
				<h4 style="margin-top: 40px;">Seu carrinho está vazio</h4>
		</c:otherwise>
	
	</c:choose>
	<table>
		<tr>
			<th>Nome do produto</th>
			<th>Preço</th>
			<th>Categoria</th>
			<th>Remover item</th>
		</tr>
	</table>
	
		<c:set var="total" value="0"></c:set>
		<c:forEach items="${carrinhoLista }" var="i">
			<c:forEach items="${listaProdutos }" var="produto">
				<c:if test="${i == produto.getId() }">
				
				<c:set var="total" value="${total + produto.getPreco() }"></c:set>
				
			<table style="table-layout: fixed;width: 90%;">
				<tr>
					<td style="width: 100px;"><img src="${produto.getImagem()}" height="100" width="150" >  (<c:out value="${produto.getNome()}"/>)</td>
					<td style="width: 50px;"><c:out value="${produto.getPreco()}"/></td>
					<td style="width: 100px;"><c:out value="${produto.getCategoria()}"/></td>
					<td style="width: 100px;"><a href="Controller?pagina=remove&id=<c:out value="${produto.getId()}"/>"><span>X</span></a></td>
				</tr>
			</table>
				</c:if>
			</c:forEach>
		</c:forEach>
	
	<h4 style="margin-top: 40px;margin-bottom: 40px;">Total da compra: R$ (<c:out value="${ total}"></c:out>)</h4>
	
	<a href="Controller?pagina=sucesso"><input type="submit" value="Finalizar venda" style="width:90%;padding:8px;font-size:16px;"></a><br>
	<a href="Controller?pagina=index"><input type="button" value="Continuar compra" style="width:90%;padding:8px;font-size:16px;margin-bottom: 40px;"></a>
	
	
	</div>

	<footer>
		&copy; <script>document.write(new Date().getFullYear());</script>
	      <a href="Controller?pagina=index"> RapaduraLivre.com</a>
	</footer>

</body>
</html>