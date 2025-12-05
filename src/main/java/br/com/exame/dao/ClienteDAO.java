package br.com.exame.dao;

import br.com.exame.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO (Data Access Object) para operações de banco de dados relacionadas a Cliente.
 * 
 * Tabela: exame_cliente
 * Campos: id (number), cpf (varchar2(50)), nome (varchar2(20))
 */
public class ClienteDAO {
    
    /**
     * Insere um novo cliente no banco de dados.
     * 
     * @param cliente Cliente a ser inserido
     * @return Cliente inserido com ID gerado, ou null em caso de erro
     */
    public Cliente inserir(Cliente cliente) {
        String sql = "INSERT INTO exame_cliente (cpf, nome) VALUES (?, ?)";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getNome());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Busca o último ID inserido (Oracle)
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM exame_cliente")) {
                    if (rs.next()) {
                        cliente.setId(rs.getLong(1));
                    }
                }
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Lista todos os clientes cadastrados.
     * 
     * @return Lista de clientes
     */
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, cpf, nome FROM exame_cliente ORDER BY id";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("id"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    /**
     * Busca um cliente pelo ID.
     * 
     * @param id ID do cliente
     * @return Cliente encontrado ou null se não encontrado
     */
    public Cliente buscarPorId(Long id) {
        String sql = "SELECT id, cpf, nome FROM exame_cliente WHERE id = ?";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    return cliente;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
