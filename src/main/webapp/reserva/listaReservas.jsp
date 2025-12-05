<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Reservas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1400px;
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
            font-size: 13px;
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
            gap: 3px;
            flex-wrap: wrap;
        }
        a.btn-action {
            padding: 4px 8px;
            font-size: 11px;
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
        a.btn-cancel {
            background-color: #f39c12;
            color: white;
        }
        a.btn-cancel:hover {
            background-color: #d68910;
        }
        a.btn-finalize {
            background-color: #16a085;
            color: white;
        }
        a.btn-finalize:hover {
            background-color: #138d75;
        }
        .status {
            padding: 5px 10px;
            border-radius: 4px;
            font-weight: bold;
            text-align: center;
            display: inline-block;
        }
        .status-pendente {
            background-color: #f39c12;
            color: white;
        }
        .status-confirmada {
            background-color: #27ae60;
            color: white;
        }
        .status-cancelada {
            background-color: #e74c3c;
            color: white;
        }
        .status-finalizada {
            background-color: #7f8c8d;
            color: white;
        }
        .empty-message {
            text-align: center;
            padding: 40px;
            color: #666;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Lista de Reservas</h1>
        
        <div class="top-actions">
            <a href="formReserva.jsp" class="btn btn-new">+ Nova Reserva</a>
            <a href="../index.jsp" class="btn btn-back">Voltar ao Menu</a>
        </div>
        
        <c:if test="${not empty reservas}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Veículo</th>
                        <th>Data Início</th>
                        <th>Data Fim</th>
                        <th>Valor Total</th>
                        <th>Status</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="reserva" items="${reservas}">
                        <tr>
                            <td>${reserva.id}</td>
                            <td>${reserva.cliente.nome}</td>
                            <td>${reserva.veiculo.modelo} - ${reserva.veiculo.placa}</td>
                            <td>
                                <fmt:formatDate value="${reserva.dataInicio}" pattern="dd/MM/yyyy"/>
                            </td>
                            <td>
                                <fmt:formatDate value="${reserva.dataFim}" pattern="dd/MM/yyyy"/>
                            </td>
                            <td>
                                <fmt:formatNumber value="${reserva.valorTotal}" type="currency" currencyCode="BRL"/>
                            </td>
                            <td>
                                <span class="status status-${reserva.status.toLowerCase()}">
                                    ${reserva.status}
                                </span>
                            </td>
                            <td class="actions">
                                <a href="ReservaServlet?acao=editar&id=${reserva.id}" class="btn-action btn-edit">Editar</a>
                                <c:if test="${reserva.status != 'Cancelada' && reserva.status != 'Finalizada'}">
                                    <a href="ReservaServlet?acao=cancelar&id=${reserva.id}" 
                                       class="btn-action btn-cancel" 
                                       onclick="return confirm('Tem certeza que deseja cancelar esta reserva?')">Cancelar</a>
                                    <a href="ReservaServlet?acao=finalizar&id=${reserva.id}" 
                                       class="btn-action btn-finalize" 
                                       onclick="return confirm('Tem certeza que deseja finalizar esta reserva?')">Finalizar</a>
                                </c:if>
                                <a href="ReservaServlet?acao=excluir&id=${reserva.id}" 
                                   class="btn-action btn-delete" 
                                   onclick="return confirm('Tem certeza que deseja excluir esta reserva?')">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${empty reservas}">
            <div class="empty-message">
                <p>Nenhuma reserva cadastrada.</p>
            </div>
        </c:if>
    </div>
</body>
</html>

