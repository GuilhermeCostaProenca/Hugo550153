package br.com.exame.model;

/**
 * Classe Model que representa uma Reserva no sistema.
 * 
 * Atributos conforme especificação do exame:
 * - id: number (primary key)
 * - idCliente: number (foreign key → exame_cliente(id))
 * - idVeiculo: number (foreign key → exame_veículo(id))
 */
public class Reserva {
    
    private Long id;
    private Long idCliente;
    private Long idVeiculo;
    
    /**
     * Construtor padrão.
     */
    public Reserva() {
    }
    
    /**
     * Construtor com parâmetros.
     * 
     * @param id ID da reserva
     * @param idCliente ID do cliente
     * @param idVeiculo ID do veículo
     */
    public Reserva(Long id, Long idCliente, Long idVeiculo) {
        this.id = id;
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
    }
    
    /**
     * Construtor sem ID (para inserção no banco).
     * 
     * @param idCliente ID do cliente
     * @param idVeiculo ID do veículo
     */
    public Reserva(Long idCliente, Long idVeiculo) {
        this.idCliente = idCliente;
        this.idVeiculo = idVeiculo;
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    public Long getIdVeiculo() {
        return idVeiculo;
    }
    
    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    
    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idVeiculo=" + idVeiculo +
                '}';
    }
}
