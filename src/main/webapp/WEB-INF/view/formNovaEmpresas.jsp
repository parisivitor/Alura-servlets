<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/>
	<form action="/gerenciador/entrada" method="post">
		Nome: <input type="text" name="nome"/>
		Data abertura: <input type="text" name="data"/>	
		<input type="hidden" name="acao" value="NovaEmpresas">
		<input type="submit"/>
	</form>
	
</body>
</html>