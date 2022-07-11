<%
	String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
	System.out.println(nomeEmpresa);
%>

<h2>Empresa ${nomeEmpresa} cadastrada com sucesso!</h2>

<!-- <h2>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</h2>  -->

<!-- <h2>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</h2>--> 