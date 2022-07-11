<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, servlet.Model.Empresa" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listando Empresas</title>
	</head>
	<body>
		<h1>Listando empresas cadastradas:</h1>
		<ul>
			<%
				List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
				for(Empresa empresa : empresas) { %>
					<li><%= empresa.getNome() %></li> <%
				}
			%>
		</ul>
	</body>
</html>