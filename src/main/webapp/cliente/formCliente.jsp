<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Cliente</title>
</head>
<body>
<h1>Cadastrar Cliente</h1>
<form action="<%=request.getContextPath()%>/cliente" method="post">
    <label>Nome:<br><input type="text" name="nome" required></label><br><br>
    <label>Email:<br><input type="email" name="email" required></label><br><br>
    <label>Telefone:<br><input type="text" name="telefone" required></label><br><br>
    <button type="submit">Salvar</button>
</form>
<p><a href="<%=request.getContextPath()%>/index.jsp">Voltar ao menu</a></p>
</body>
</html>
