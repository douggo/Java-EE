<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<core:url value="/new-empresa" var="linkNewEmpresa"/>
<core:url value="/altera-empresa" var="linkAlteraEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar dados da empresa</title>
</head>
<body>
    <form action="${linkAlteraEmpresa}" method="post">
    	<div>
    		<input type="hidden" name="id" value="${empresa.id}">
    	</div>
    	<div>
    		<label>Nome:</label>
        	<input type="text" name="nome" value="${empresa.nome}"/>
        </div>
        <div>
        	<label>Data:</label>
        	<input type="text" name="dataAbertura" value='<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>'/>
        </div>
        <div>
        	<input type="submit" />
        </div>
    </form>
</body>
</html>