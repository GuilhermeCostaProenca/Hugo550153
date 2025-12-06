<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Novo Veiculo</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Cadastrar Veiculo</h1>
        <form action="<%=request.getContextPath()%>/veiculo" method="post">
            <label>Marca
                <input type="text" name="marca" required>
            </label>
            <label>Modelo
                <input type="text" name="modelo" required>
            </label>
            <div class="actions">
                <button type="submit">Salvar</button>
                <a href="<%=request.getContextPath()%>/index.jsp" class="btn btn-back">Voltar ao menu</a>
            </div>
        </form>
    </div>
</body>
</html>
