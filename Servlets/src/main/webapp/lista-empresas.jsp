<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, servlet.Model.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

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
				<li>${empresa.nome}</li>
			</core:forEach>
		</ul>
	</body>
</html>