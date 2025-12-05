package br.com.exame.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReservaServlet", urlPatterns = "/reserva")
public class ReservaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getParameter("acao");
            out.println("<html><head><title>Reservas</title></head><body>");
            out.println("<h1>Gestão de Reservas</h1>");
            if ("listar".equalsIgnoreCase(acao)) {
                out.println("<p>Listagem de reservas ainda não implementada.</p>");
            } else {
                out.println("<p>Nenhuma ação informada. Use ?acao=listar para visualizar a listagem.</p>");
            }
            out.printf("<p><a href='%s/index.jsp'>Voltar ao menu</a></p>%n", contextPath);
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String cliente = request.getParameter("cliente");
        String veiculo = request.getParameter("veiculo");
        String dataRetirada = request.getParameter("dataRetirada");
        String dataDevolucao = request.getParameter("dataDevolucao");

        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Reserva registrada</title></head><body>");
            out.println("<h1>Reserva registrada!</h1>");
            out.printf("<p>Cliente: %s</p>%n", cliente);
            out.printf("<p>Veículo: %s</p>%n", veiculo);
            out.printf("<p>Data de retirada: %s</p>%n", dataRetirada);
            out.printf("<p>Data de devolução: %s</p>%n", dataDevolucao);
            out.printf("<p><a href='%s/reserva/formReserva.jsp'>Registrar nova reserva</a></p>%n", contextPath);
            out.printf("<p><a href='%s/index.jsp'>Voltar ao menu</a></p>%n", contextPath);
            out.println("</body></html>");
        }
    }
}
