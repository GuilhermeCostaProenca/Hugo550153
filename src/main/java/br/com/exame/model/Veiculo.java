package br.com.exame.model;

/**
 * Classe Model que representa um Veículo no sistema.
 * 
 * Atributos conforme especificação do exame:
 * - id: number (primary key)
 * - marca: varchar2(50) (not null)
 * - modelo: varchar2(50) (not null)
 */
public class Veiculo {
    
    private Long id;
    private String marca;
    private String modelo;
    
    /**
     * Construtor padrão.
     */
    public Veiculo() {
    }
    
    /**
     * Construtor com parâmetros.
     * 
     * @param id ID do veículo
     * @param marca Marca do veículo
     * @param modelo Modelo do veículo
     */
    public Veiculo(Long id, String marca, String modelo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    /**
     * Construtor sem ID (para inserção no banco).
     * 
     * @param marca Marca do veículo
     * @param modelo Modelo do veículo
     */
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
