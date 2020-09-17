<%@ page language="java"  isELIgnored = "false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
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
<body>
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
	
	 <sql:setDataSource user="root" password="reguladora123" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/rapaduralivre?useTimezone=true&serverTimezone=UTC" var="ds"/>
	 
	  <sql:query var="resultado" dataSource="${ds }" sql = "select * from produtos"/>
	
	<div class="container">
		 <table>
			<tr>
			<th>Item id</th>
			<th>Nome</th>
			<th>Preço</th>
			<th>Categoria</th>
			<th>Imagem</th>
			<th>Opção</th>
		</tr>
	</table>
		
		 <c:forEach items="${resultado.rows }" var="linha">
		  <table style="table-layout: fixed;width: 90%;">
		  	
				<tr>
					<td style="width: 50px;"><c:out value="${linha.id }"></c:out></td>
					<td style="width: 100px;"><c:out value="${linha.nome }"></c:out></td>
					<td style="width: 100px;"><c:out value="${linha.preco }"></c:out></td>
					<td style="width: 100px;"><c:out value="${linha.categoria}"/></td>
					<td style="width: 100px;"><img src="${linha.imagem}" height="100" width="150" ></td>
					<td style="width: 100px;"><a href="<%= request.getContextPath() %>/admin?pagina=editar&id=${linha.id}" style="color: #6bb1f8;">editar</a> ||
					<a href="<%= request.getContextPath() %>/admin?pagina=deletar&id=${linha.id}" style="color:#6bb1f8;">deletar</a></td>
				</tr>
			</table>
		 </c:forEach>
		 </div>
	 <footer>
		&copy; <script>document.write(new Date().getFullYear());</script>
	      <a href="Controller?pagina=index"> RapaduraLivre.com</a>
	</footer>
	
</body>
</html>