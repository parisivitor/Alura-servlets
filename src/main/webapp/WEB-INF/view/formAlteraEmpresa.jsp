<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Cadastro da Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="/gerenciador/entrada" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome}"/>
		Data abertura: <input type="text" name="data" value="<fmt:formatDate value = "${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${empresa.id}"/>
		<input type="hidden" name="acao" value="AlteraEmpresas">	
		<input type="submit"/>
	</form>
	
</body>
</html>