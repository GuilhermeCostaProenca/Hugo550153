<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Reserva</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
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
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"],
        input[type="date"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="number"]:focus,
        select:focus {
            outline: none;
            border-color: #3498db;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
        }
        .button-group {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin-top: 25px;
        }
        button, a.btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;
        }
        button[type="submit"] {
            background-color: #27ae60;
            color: white;
        }
        button[type="submit"]:hover {
            background-color: #229954;
        }
        a.btn {
            background-color: #7f8c8d;
            color: white;
        }
        a.btn:hover {
            background-color: #5d6d7b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Nova Reserva</h1>
        
        <form method="POST" action="../ReservaServlet">
            <input type="hidden" name="acao" value="salvar">
            
            <div class="form-group">
                <label for="clienteId">Cliente:</label>
                <select id="clienteId" name="clienteId" required>
                    <option value="">-- Selecione um cliente --</option>
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.id}">
                            ${cliente.nome} - ${cliente.cpf}
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="veiculoId">Veículo:</label>
                <select id="veiculoId" name="veiculoId" required>
                    <option value="">-- Selecione um veículo --</option>
                    <c:forEach var="veiculo" items="${veiculos}">
                        <c:if test="${veiculo.disponivel}">
                            <option value="${veiculo.id}">
                                ${veiculo.modelo} (${veiculo.placa}) - ${veiculo.marca} ${veiculo.ano}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            
            <div class="form-group">
                <label for="dataInicio">Data de Início:</label>
                <input type="date" id="dataInicio" name="dataInicio" required>
            </div>
            
            <div class="form-group">
                <label for="dataFim">Data de Fim:</label>
                <input type="date" id="dataFim" name="dataFim" required>
            </div>
            
            <div class="form-group">
                <label for="valorTotal">Valor Total (R$):</label>
                <input type="number" id="valorTotal" name="valorTotal" step="0.01" min="0" required>
            </div>
            
            <div class="form-group">
                <label for="status">Status:</label>
                <select id="status" name="status" required>
                    <option value="">-- Selecione --</option>
                    <option value="Pendente">Pendente</option>
                    <option value="Confirmada">Confirmada</option>
                    <option value="Cancelada">Cancelada</option>
                    <option value="Finalizada">Finalizada</option>
                </select>
            </div>
            
            <div class="button-group">
                <button type="submit">Salvar Reserva</button>
                <a href="../index.jsp" class="btn">Voltar</a>
            </div>
        </form>
    </div>
</body>
</html>

