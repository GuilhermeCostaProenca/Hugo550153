package br.com.exame.servlet;

import br.com.exame.dao.VeiculoDAO;
import br.com.exame.model.Veiculo;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet responsável por processar requisições relacionadas a Veículos.
 * 
 * Rotas:
 * - GET /veiculo → lista todos os veículos
 * - POST /veiculo → cadastra um novo veículo
 */
public class VeiculoServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private VeiculoDAO veiculoDAO;
    
    @Override
    public void init() throws ServletException {
        super.init();
        veiculoDAO = new VeiculoDAO();
    }
    
    /**
     * Processa requisições GET - Lista todos os veículos.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<Veiculo> veiculos = veiculoDAO.listar();
            request.setAttribute("veiculos", veiculos);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/listaVeiculos.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao listar veículos");
        }
    }
    
    /**
     * Processa requisições POST - Cadastra um novo veículo.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");
            
            if (marca != null && modelo != null && !marca.trim().isEmpty() && !modelo.trim().isEmpty()) {
                Veiculo veiculo = new Veiculo(marca, modelo);
                Veiculo veiculoInserido = veiculoDAO.inserir(veiculo);
                
                if (veiculoInserido != null) {
                    response.sendRedirect(request.getContextPath() + "/veiculo");
                } else {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar veículo");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Marca e Modelo são obrigatórios");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao cadastrar veículo");
        }
    }
}
