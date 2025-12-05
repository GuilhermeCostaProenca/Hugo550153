package br.com.exame.dao;

import br.com.exame.model.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO (Data Access Object) para operações de banco de dados relacionadas a Reserva.
 * 
 * Tabela: exame_reserva
 * Campos: id (number), id_cliente (number), id_veiculo (number)
 */
public class ReservaDAO {
    
    /**
     * Insere uma nova reserva no banco de dados.
     * 
     * @param reserva Reserva a ser inserida
     * @return Reserva inserida com ID gerado, ou null em caso de erro
     */
    public Reserva inserir(Reserva reserva) {
        String sql = "INSERT INTO exame_reserva (id_cliente, id_veiculo) VALUES (?, ?)";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, reserva.getIdCliente());
            pstmt.setLong(2, reserva.getIdVeiculo());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Busca o último ID inserido (Oracle)
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM exame_reserva")) {
                    if (rs.next()) {
                        reserva.setId(rs.getLong(1));
                    }
                }
                return reserva;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Lista todas as reservas cadastradas com dados do cliente e veículo.
     * 
     * @return Lista de reservas
     */
    public List<Reserva> listar() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT id, id_cliente, id_veiculo FROM exame_reserva ORDER BY id";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getLong("id"));
                reserva.setIdCliente(rs.getLong("id_cliente"));
                reserva.setIdVeiculo(rs.getLong("id_veiculo"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return reservas;
    }
    
    /**
     * Busca uma reserva pelo ID.
     * 
     * @param id ID da reserva
     * @return Reserva encontrada ou null se não encontrada
     */
    public Reserva buscarPorId(Long id) {
        String sql = "SELECT id, id_cliente, id_veiculo FROM exame_reserva WHERE id = ?";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Reserva reserva = new Reserva();
                    reserva.setId(rs.getLong("id"));
                    reserva.setIdCliente(rs.getLong("id_cliente"));
                    reserva.setIdVeiculo(rs.getLong("id_veiculo"));
                    return reserva;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
