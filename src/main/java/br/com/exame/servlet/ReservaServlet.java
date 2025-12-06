package br.com.exame.servlet;

import br.com.exame.dao.ReservaDAO;
import br.com.exame.model.Reserva;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/reserva", "/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String acao = request.getParameter("acao");

        if ("listar".equalsIgnoreCase(acao)) {
            List<Reserva> reservas = new ReservaDAO().listar();
            request.setAttribute("reservas", reservas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/reserva/listaReservas.jsp");
            dispatcher.forward(request, response);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idClienteParam = request.getParameter("idCliente");
        String idVeiculoParam = request.getParameter("idVeiculo");

        try {
            Long idCliente = Long.parseLong(idClienteParam);
            Long idVeiculo = Long.parseLong(idVeiculoParam);

            Reserva reserva = new Reserva(idCliente, idVeiculo);
            new ReservaDAO().inserir(reserva);

            response.sendRedirect(request.getContextPath() + "/reserva?acao=listar");
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/reserva/formReserva.jsp");
        }
    }
}
