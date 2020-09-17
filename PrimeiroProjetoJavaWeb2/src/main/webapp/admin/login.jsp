<%@ page language="java" isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:wght@500&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@700&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body  class = "bodyOutro">


	<div class = "conteudo">
		<div class = "loginbox">
		<div class = "contact-title">
				<h1>Admin Login</h1>
				<h3>Com doçura e com afeto fiz seu doce predileto</h3>
			</div>
			<form method="post" action="admin">
				 
				 <input type="hidden" name="pagina" value="admin-login-form">
				 
				 		<!-- Validations errors -->
				 		<font color="#F24638"><c:out value="${msg }"></c:out></font>
				 
			
				 		<p>Usuario</p>
				 		<input type="text" name="usuario" placeholder="Seu usuario" value="<c:out value="${usuario }"></c:out>">
		
			
				 		<p>Senha</p>
				 		<input type="password" name="senha" placeholder="Sua senha">
			
		
				 		<input type = "submit" name = "botao" value = "Login">
			
			</form>
		</div>
	</div>
</body>
</html>