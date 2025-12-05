package br.com.exame.dao;

import br.com.exame.model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO (Data Access Object) para operações de banco de dados relacionadas a Veículo.
 * 
 * Tabela: exame_veiculo
 * Campos: id (number), marca (varchar2(50)), modelo (varchar2(50))
 */
public class VeiculoDAO {
    
    /**
     * Insere um novo veículo no banco de dados.
     * 
     * @param veiculo Veículo a ser inserido
     * @return Veículo inserido com ID gerado, ou null em caso de erro
     */
    public Veiculo inserir(Veiculo veiculo) {
        String sql = "INSERT INTO exame_veiculo (marca, modelo) VALUES (?, ?)";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, veiculo.getMarca());
            pstmt.setString(2, veiculo.getModelo());
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                // Busca o último ID inserido (Oracle)
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM exame_veiculo")) {
                    if (rs.next()) {
                        veiculo.setId(rs.getLong(1));
                    }
                }
                return veiculo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Lista todos os veículos cadastrados.
     * 
     * @return Lista de veículos
     */
    public List<Veiculo> listar() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT id, marca, modelo FROM exame_veiculo ORDER BY id";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return veiculos;
    }
    
    /**
     * Busca um veículo pelo ID.
     * 
     * @param id ID do veículo
     * @return Veículo encontrado ou null se não encontrado
     */
    public Veiculo buscarPorId(Long id) {
        String sql = "SELECT id, marca, modelo FROM exame_veiculo WHERE id = ?";
        
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setId(rs.getLong("id"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    return veiculo;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
