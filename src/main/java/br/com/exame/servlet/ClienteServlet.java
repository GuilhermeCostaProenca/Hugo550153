package br.com.exame.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClienteServlet", urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            String acao = request.getParameter("acao");
            out.println("<html><head><title>Clientes</title></head><body>");
            out.println("<h1>Gestão de Clientes</h1>");
            if ("listar".equalsIgnoreCase(acao)) {
                out.println("<p>Listagem de clientes ainda não implementada.</p>");
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

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        String contextPath = request.getContextPath();
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>Cliente cadastrado</title></head><body>");
            out.println("<h1>Cliente cadastrado com sucesso!</h1>");
            out.printf("<p>Nome: %s</p>%n", nome);
            out.printf("<p>Email: %s</p>%n", email);
            out.printf("<p>Telefone: %s</p>%n", telefone);
            out.printf("<p><a href='%s/cliente/formCliente.jsp'>Cadastrar outro</a></p>%n", contextPath);
            out.printf("<p><a href='%s/index.jsp'>Voltar ao menu</a></p>%n", contextPath);
            out.println("</body></html>");
        }
    }
}
