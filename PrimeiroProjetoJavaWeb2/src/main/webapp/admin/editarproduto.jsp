<%@ page language="java" isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar produto</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body  class = "bodyOutro">
<header>
		<h1>
			Bem-vindo administrador
		</h1>
		<nav>
			<ul>
				<li><a href="admin?pagina=index">Home</a></li>
				<li><a href="admin?pagina=adicionarproduto">Adicionar produto</a></li>
			</ul>
		</nav>
	</header>
	
	<div class = "conteudo">
		<div class = "registrobox">	
			<div class="container">
				 <form method="post" action="admin">
				 
				 <input type="hidden" name="pagina" value="editar-produto">
				 <input type="hidden" name="id" value="<c:out value="${p.getId() }"/>">
			     
				 		<p>Nome</p>
				 		<input type="text" name="nome" value="<c:out value="${p.getNome() }"></c:out>" required>
	
				 		<p>Preço</p>
				 		<input type="text" name="preco" value="<c:out value="${p.getPreco() }"></c:out>" required>

				 		<p>Categoria</p>
				 		<input type="text" name="categoria" value="<c:out value="${p.getCategoria() }"></c:out>" required>
	
				 		<p>Imagem</p>
				 		<img style="height: 160px;width: 160px;" src="<c:out value="${p.getImagem() }"></c:out>">
	
		
						<input type="submit" value="Editar">	 

				 </form>
			</div>
		</div>
	</div>
	
	 <footer>
		<div class="footer"> &copy; 2018 Copyright:
	      Tiazon.com
	    </div>
	</footer>
</body>
</html>