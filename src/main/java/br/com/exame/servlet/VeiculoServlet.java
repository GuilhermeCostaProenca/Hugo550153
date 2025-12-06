package br.com.exame.servlet;

import br.com.exame.dao.VeiculoDAO;
import br.com.exame.model.Veiculo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VeiculoServlet", urlPatterns = {"/veiculo", "/VeiculoServlet"})
public class VeiculoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        if ("listar".equalsIgnoreCase(acao)) {
            List<Veiculo> veiculos = new VeiculoDAO().listar();
            request.setAttribute("veiculos", veiculos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/veiculo/listaVeiculos.jsp");
            dispatcher.forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");

        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);

        new VeiculoDAO().inserir(veiculo);

        response.sendRedirect(request.getContextPath() + "/veiculo?acao=listar");
    }
}
