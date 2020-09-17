<%@ page language="java" isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar produto</title>
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
			</ul>
		</nav>
	</header>
	
	<div class = "conteudo">
		<div class = "registrobox">	
			<div class="container">
		
				 <form method="post" action="admin">
				 
				 <input type="hidden" name="pagina" value="adicionar-produto-form">
			     
				 	
				 		<p>Nome</p>
				 		<input type="text" name="nome" placeholder="Nome do produto"  required>
			
				 	
				 		<p>Preço</p>
				 		<input type="text" name="preco" placeholder="Preço do produto" required>
				 	
				 
				 		<p>Categoria</p>
				 		<input type="text" name="categoria" placeholder="Categoria do produto" required>
				 	
				 	
				 		 <p>Nome da imagem</p>
	 					 	<input type="text" name="imagem" placeholder="Nome da imagem" required>
				 	
				 	
						<input type="submit" value="Enviar">	 
		
				 </form>
			</div>
		</div>
	</div>
	
	<footer>
		<div class="footer"> &copy;<script>document.write(new Date().getFullYear());</script>
	      <a href="Controller?pagina=index"> rapaduralivre.com</a>
	    </div>
	</footer>
</body>
</html>