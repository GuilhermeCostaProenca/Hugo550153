package br.com.exame.servlet;

import br.com.exame.dao.ClienteDAO;
import br.com.exame.model.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por processar requisições relacionadas a Clientes.
 * 
 * Rotas:
 * - GET /cliente → lista todos os clientes
 * - POST /cliente → cadastra um novo cliente
 */
public class ClienteServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private ClienteDAO clienteDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        clienteDAO = new ClienteDAO();
    }
    
    /**
     * Processa requisições GET - Lista todos os clientes.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<Cliente> clientes = clienteDAO.listar();
            request.setAttribute("clientes", clientes);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/listaClientes.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar clientes");
        }
    }
    
    /**
     * Processa requisições POST - Cadastra um novo cliente.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            
            if (cpf != null && nome != null && !cpf.trim().isEmpty() && !nome.trim().isEmpty()) {
                Cliente cliente = new Cliente(cpf, nome);
                Cliente clienteInserido = clienteDAO.inserir(cliente);
                
                if (clienteInserido != null) {
                    response.sendRedirect(request.getContextPath() + "/cliente");
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar cliente");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "CPF e Nome são obrigatórios");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar cliente");
        }
    }
}
