<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sistema de Reservas de Veículos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 1000px;
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
            margin-bottom: 40px;
        }
        .menu {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-top: 30px;
        }
        .menu-item {
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            text-align: center;
            background-color: #f9f9f9;
        }
        .menu-item h2 {
            margin-top: 0;
            color: #2c3e50;
            font-size: 18px;
        }
        .menu-item a {
            display: inline-block;
            margin: 5px;
            padding: 10px 15px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .menu-item a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Sistema de Reserva de Veículos</h1>
        
        <div class="menu">
            <div class="menu-item">
                <h2>Clientes</h2>
                <a href="cliente/formCliente.jsp">Novo Cliente</a><br>
                <a href="ClienteServlet?acao=listar">Listar Clientes</a>
            </div>
            
            <div class="menu-item">
                <h2>Veículos</h2>
                <a href="veiculo/formVeiculo.jsp">Novo Veículo</a><br>
                <a href="VeiculoServlet?acao=listar">Listar Veículos</a>
            </div>
            
            <div class="menu-item">
                <h2>Reservas</h2>
                <a href="reserva/formReserva.jsp">Nova Reserva</a><br>
                <a href="ReservaServlet?acao=listar">Listar Reservas</a>
            </div>
        </div>
    </div>
</body>
</html>

