<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,gerenciador.modelo.Empresa" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas</title>
</head>
	<body>
	<c:import url="logout-parcial.jsp"/>
	<p>Lista de empresas:</p>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome} - <fmt:formatDate value = "${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
					<a href="entrada?acao=MostraEmpresas&id=${empresa.id}">editar</a> 
					<a href="entrada?acao=RemoveEmpresas&id=${empresa.id}">remove</a>
				</li>
			</c:forEach>
		</ul>
		<a href="entrada?acao=NovaEmpresasForm">Adicionar Empresa</a>
		
<!-- 		<c:forEach var="i" begin="1" end="10" step="2">
       		${i} <br />
    	</c:forEach>  
-->
	</body>
</html>