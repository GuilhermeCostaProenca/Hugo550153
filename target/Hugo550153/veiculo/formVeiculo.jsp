<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Veículo</title>
</head>
<body>
<h1>Cadastrar Veículo</h1>
<form action="<%=request.getContextPath()%>/veiculo" method="post">
    <label>Marca:<br><input type="text" name="marca" required></label><br><br>
    <label>Modelo:<br><input type="text" name="modelo" required></label><br><br>
    <label>Placa:<br><input type="text" name="placa" required></label><br><br>
    <button type="submit">Salvar</button>
</form>
<p><a href="<%=request.getContextPath()%>/index.jsp">Voltar ao menu</a></p>
</body>
</html>
