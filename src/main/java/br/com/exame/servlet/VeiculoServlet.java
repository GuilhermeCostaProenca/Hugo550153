package br.com.exame.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "VeiculoServlet", urlPatterns = {"/veiculo", "/VeiculoServlet"})
public class VeiculoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getParameter("acao");
            out.println("<html><head><title>Veículos</title></head><body>");
            out.println("<h1>Gestão de Veículos</h1>");
            if ("listar".equalsIgnoreCase(acao)) {
                out.println("<p>Listagem de veículos ainda não implementada.</p>");
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

        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String placa = request.getParameter("placa");

        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Veículo cadastrado</title></head><body>");
            out.println("<h1>Veículo cadastrado com sucesso!</h1>");
            out.printf("<p>Marca: %s</p>%n", marca);
            out.printf("<p>Modelo: %s</p>%n", modelo);
            out.printf("<p>Placa: %s</p>%n", placa);
            out.printf("<p><a href='%s/veiculo/formVeiculo.jsp'>Cadastrar outro</a></p>%n", contextPath);
            out.printf("<p><a href='%s/index.jsp'>Voltar ao menu</a></p>%n", contextPath);
            out.println("</body></html>");
        }
    }
}
