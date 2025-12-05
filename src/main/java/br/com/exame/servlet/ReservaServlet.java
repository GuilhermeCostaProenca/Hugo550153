package br.com.exame.servlet;

import br.com.exame.dao.ReservaDAO;
import br.com.exame.dao.ClienteDAO;
import br.com.exame.dao.VeiculoDAO;
import br.com.exame.model.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por processar requisições relacionadas a Reservas.
 * 
 * Rotas:
 * - GET /reserva → lista todas as reservas
 * - POST /reserva → cadastra uma nova reserva
 */
public class ReservaServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private ReservaDAO reservaDAO;
    private ClienteDAO clienteDAO;
    private VeiculoDAO veiculoDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        reservaDAO = new ReservaDAO();
        clienteDAO = new ClienteDAO();
        veiculoDAO = new VeiculoDAO();
    }
    
    /**
     * Processa requisições GET - Lista todas as reservas.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<Reserva> reservas = reservaDAO.listar();
            request.setAttribute("reservas", reservas);
            
            // Carrega também clientes e veículos para exibir informações completas
            request.setAttribute("clientes", clienteDAO.listar());
            request.setAttribute("veiculos", veiculoDAO.listar());
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/reserva/listaReservas.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar reservas");
        }
    }
    
    /**
     * Processa requisições POST - Cadastra uma nova reserva.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            String idClienteStr = request.getParameter("idCliente");
            String idVeiculoStr = request.getParameter("idVeiculo");
            
            if (idClienteStr != null && idVeiculoStr != null && 
                !idClienteStr.trim().isEmpty() && !idVeiculoStr.trim().isEmpty()) {
                
                Long idCliente = Long.parseLong(idClienteStr);
                Long idVeiculo = Long.parseLong(idVeiculoStr);
                
                // Valida se cliente e veículo existem
                if (clienteDAO.buscarPorId(idCliente) == null) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Cliente não encontrado");
                    return;
                }
                
                if (veiculoDAO.buscarPorId(idVeiculo) == null) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Veículo não encontrado");
                    return;
                }
                
                Reserva reserva = new Reserva(idCliente, idVeiculo);
                Reserva reservaInserida = reservaDAO.inserir(reserva);
                
                if (reservaInserida != null) {
                    response.sendRedirect(request.getContextPath() + "/reserva");
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar reserva");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do Cliente e ID do Veículo são obrigatórios");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "IDs inválidos");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar reserva");
        }
    }
}
