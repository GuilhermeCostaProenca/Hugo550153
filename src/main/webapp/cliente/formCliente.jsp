<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Cliente</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Cadastrar Cliente</h1>
        <form action="<%=request.getContextPath()%>/cliente" method="post">
            <label>Nome
                <input type="text" name="nome" required>
            </label>
            <label>Email
                <input type="email" name="email" required>
            </label>
            <label>Telefone
                <input type="text" name="telefone" required>
            </label>
            <div class="actions">
                <button type="submit">Salvar</button>
                <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-back">Voltar ao menu</a>
            </div>
        </form>
    </div>
</body>
</html>
