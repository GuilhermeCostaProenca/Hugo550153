<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Clientes</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
    <style>
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
        .empty-message {
            text-align: center;
            padding: 40px;
            color: #666;
        }
        .top-actions {
            margin-bottom: 20px;
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
        }
        a.btn-new, a.btn-back {
            padding: 10px 16px;
            border-radius: 4px;
            text-decoration: none;
            color: white;
        }
        a.btn-new { background-color: #3498db; }
        a.btn-new:hover { background-color: #2980b9; }
        a.btn-back { background-color: #7f8c8d; }
        a.btn-back:hover { background-color: #5d6d7b; }
    </style>
</head>
<body>
    <c:set var="ctx" value="${pageContext.request.contextPath}" />
    <div class="container">
        <h1>Lista de Clientes</h1>

        <div class="top-actions">
            <a href="${ctx}/cliente/formCliente.jsp" class="btn-new">+ Novo Cliente</a>
            <a href="${ctx}/index.jsp" class="btn-back">Voltar ao Menu</a>
        </div>

        <c:if test="${not empty clientes}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>CPF</th>
                        <th>Nome</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                            <td>${cliente.id}</td>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.nome}</td>
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
