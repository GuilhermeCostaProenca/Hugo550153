package br.com.exame.model;

/**
 * Classe Model que representa um Cliente no sistema.
 * 
 * Atributos conforme especificação do exame:
 * - id: number (primary key)
 * - cpf: varchar2(50) (not null)
 * - nome: varchar2(20) (not null)
 */
public class Cliente {
    
    private Long id;
    private String cpf;
    private String nome;
    
    /**
     * Construtor padrão.
     */
    public Cliente() {
    }
    
    /**
     * Construtor com parâmetros.
     * 
     * @param id ID do cliente
     * @param cpf CPF do cliente
     * @param nome Nome do cliente
     */
    public Cliente(Long id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }
    
    /**
     * Construtor sem ID (para inserção no banco).
     * 
     * @param cpf CPF do cliente
     * @param nome Nome do cliente
     */
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    // Getters e Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
