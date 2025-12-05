<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nova Reserva</title>
</head>
<body>
<h1>Registrar Reserva</h1>
<form action="<%=request.getContextPath()%>/reserva" method="post">
    <label>Cliente:<br><input type="text" name="cliente" required></label><br><br>
    <label>Veículo:<br><input type="text" name="veiculo" required></label><br><br>
    <label>Data de retirada:<br><input type="date" name="dataRetirada" required></label><br><br>
    <label>Data de devolução:<br><input type="date" name="dataDevolucao" required></label><br><br>
    <button type="submit">Salvar</button>
</form>
<p><a href="<%=request.getContextPath()%>/index.jsp">Voltar ao menu</a></p>
</body>
</html>
