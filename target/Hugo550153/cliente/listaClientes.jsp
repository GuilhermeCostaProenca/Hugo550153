<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Clientes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .top-actions {
            margin-bottom: 20px;
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
        }
        a.btn, button {
            padding: 10px 20px;
            text-decoration: none;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }
        a.btn-new {
            background-color: #3498db;
            color: white;
        }
        a.btn-new:hover {
            background-color: #2980b9;
        }
        a.btn-back {
            background-color: #7f8c8d;
            color: white;
        }
        a.btn-back:hover {
            background-color: #5d6d7b;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th {
            background-color: #3498db;
            color: white;
            padding: 12px;
            text-align: left;
            border-bottom: 2px solid #2980b9;
        }
        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        .actions {
            display: flex;
            gap: 5px;
        }
        a.btn-edit, a.btn-delete {
            padding: 5px 10px;
            font-size: 12px;
            text-decoration: none;
            border-radius: 3px;
        }
        a.btn-edit {
            background-color: #27ae60;
            color: white;
        }
        a.btn-edit:hover {
            background-color: #229954;
        }
        a.btn-delete {
            background-color: #e74c3c;
            color: white;
        }
        a.btn-delete:hover {
            background-color: #c0392b;
        }
        .empty-message {
            text-align: center;
            padding: 40px;
            color: #666;
        }
    </style>
</head>
<body>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <div class="container">
        <h1>Lista de Clientes</h1>

        <div class="top-actions">
            <a href="${ctx}/cliente/formCliente.jsp" class="btn btn-new">+ Novo Cliente</a>
            <a href="${ctx}/index.jsp" class="btn btn-back">Voltar ao Menu</a>
        </div>
        
        <c:if test="${not empty clientes}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Endereço</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.id}</td>
                            <td>${cliente.nome}</td>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.email}</td>
                            <td>${cliente.telefone}</td>
                            <td>${cliente.endereco}</td>
                            <td class="actions">
                                <a href="${ctx}/cliente?acao=editar&id=${cliente.id}" class="btn-edit">Editar</a>
                                <a href="${ctx}/cliente?acao=excluir&id=${cliente.id}"
                                   class="btn-delete"
                                   onclick="return confirm('Tem certeza que deseja excluir este cliente?')">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${empty clientes}">
            <div class="empty-message">
                <p>Nenhum cliente cadastrado.</p>
            </div>
        </c:if>
    </div>
</body>
</html>

