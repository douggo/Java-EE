<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, servlet.Model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<core:url value="/remove-empresa" var="linkRemover" />
<core:url value="/mostra-empresa" var="linkMostrar" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listando Empresas</title>
	</head>
	<body>
		<h1>Listando empresas cadastradas:</h1>
		<ul>
			<core:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> |
					<a href='${linkRemover}?id=${empresa.id}'>remover</a> |
					<a href='${linkMostrar}?id=${empresa.id}'>alterar</a>
				</li>
			</core:forEach>
		</ul>
		<core:if test="${not empty nomeEmpresa}">
			<h3 style="color: blue;">Empresa ${nomeEmpresa} cadastrada com sucesso!</h3>
		</core:if>
	</body>
</html>