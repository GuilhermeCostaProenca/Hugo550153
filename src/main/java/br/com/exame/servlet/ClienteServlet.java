package br.com.exame.servlet;

import br.com.exame.dao.ClienteDAO;
import br.com.exame.model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente", "/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        if ("listar".equalsIgnoreCase(acao)) {
            List<Cliente> clientes = new ClienteDAO().listar();
            request.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/listaClientes.jsp");
            dispatcher.forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");

        Cliente cliente = new Cliente(cpf, nome);
        new ClienteDAO().inserir(cliente);

        response.sendRedirect(request.getContextPath() + "/cliente?acao=listar");
    }
}
