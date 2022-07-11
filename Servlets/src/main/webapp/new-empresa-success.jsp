<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Sucesso!</title>
	</head>
	<body>
		<core:if test="${not empty nomeEmpresa}">
			<h2>Empresa ${nomeEmpresa} cadastrada com sucesso!</h2>
		</core:if>
		<core:if test="${empty nomeEmpresa}">
			<h2>Nenhuma empresa cadastrada!</h2>
		</core:if>
	</body>
</html>