<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<core:url value="/new-empresa" var="linkNewEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar nova empresa</title>
</head>
<body>
    <form action="${linkNewEmpresa}" method="post">
    	<div>
    		<label>Nome:</label>
        	<input type="text" name="nome" />
        </div>
        <div>
        	<label>Data:</label>
        	<input type="text" name="dataAbertura"
        </div>
        <div>
        	<input type="submit" />
        </div>
    </form>
</body>
</html>