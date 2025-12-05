package br.com.exame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados Oracle.
 */
public class Conexao {
    
    // TODO: Configurar as informações de conexão com o Oracle
    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USUARIO = "RM550153";
    private static final String SENHA = "280205";
    
    /**
     * Obtém uma conexão com o banco de dados Oracle.
     * 
     * @return Connection objeto de conexão
     * @throws SQLException se ocorrer erro na conexão
     */
    public static Connection obterConexao() throws SQLException {
        try {
            // Carrega o driver JDBC do Oracle
            Class.forName("oracle.jdbc.OracleDriver");


            // Estabelece a conexão
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver Oracle não encontrado", e);
        }
    }
}

