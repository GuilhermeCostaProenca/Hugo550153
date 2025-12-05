# Sistema de Reservas Hugo550153

Sistema de gerenciamento de reservas de veículos desenvolvido com Java Web (Servlet + JSP), compatível com Tomcat 9.

## Estrutura do Projeto

```
Hugo550153/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/exame/
│   │   │       ├── dao/          # Classes de acesso a dados
│   │   │       ├── model/        # Classes de modelo (entidades)
│   │   │       └── servlet/      # Servlets para processamento de requisições
│   │   ├── resources/            # Arquivos de configuração e recursos
│   │   └── webapp/               # Arquivos web (JSP, CSS, JS, etc.)
│   │       ├── index.jsp         # Página inicial
│   │       ├── cliente/          # Páginas relacionadas a clientes
│   │       ├── veiculo/          # Páginas relacionadas a veículos
│   │       ├── reserva/          # Páginas relacionadas a reservas
│   │       └── WEB-INF/
│   │           ├── web.xml       # Configuração do projeto web
│   │           └── lib/          # Bibliotecas JAR (se não usar Maven)
└── pom.xml                       # Configuração Maven
```

## Tecnologias Utilizadas

- **Java 8**
- **Servlet 4.0**
- **JSP 2.3**
- **JSTL 1.2**
- **Tomcat 9**
- **Maven** (opcional, mas recomendado)

## Funcionalidades

### Módulo de Clientes
- Cadastro de clientes
- Listagem de clientes
- Edição de clientes
- Exclusão de clientes
- Busca por CPF e nome

### Módulo de Veículos
- Cadastro de veículos
- Listagem de veículos
- Edição de veículos
- Exclusão de veículos
- Controle de disponibilidade
- Busca por modelo e placa

### Módulo de Reservas
- Criação de reservas
- Listagem de reservas
- Edição de reservas
- Cancelamento de reservas
- Finalização de reservas
- Validação de disponibilidade
- Cálculo de valor total

## Configuração e Instalação

### Pré-requisitos
- JDK 8 ou superior
- Apache Tomcat 9
- Maven 3.6+ (opcional)
- Banco de dados (MySQL, PostgreSQL, etc.)

### Passos para Configuração

1. **Clone ou baixe o projeto**

2. **Configure o banco de dados**
   - Crie o banco de dados
   - Configure a conexão nas classes DAO
   - Execute os scripts SQL para criar as tabelas

3. **Configure as dependências**
   - Se usar Maven: execute `mvn clean install`
   - Se não usar Maven: adicione as JARs necessárias em `WEB-INF/lib/`

4. **Configure o Tomcat**
   - Adicione o projeto ao Tomcat
   - Configure o contexto no `server.xml` (se necessário)

5. **Inicie o servidor**
   - Inicie o Tomcat
   - Acesse: `http://localhost:8080/Hugo550153`

## Próximos Passos de Implementação

### Classes Model
- [ ] Implementar atributos, construtores, getters e setters
- [ ] Implementar métodos de validação
- [ ] Implementar método toString()

### Classes DAO
- [ ] Implementar conexão com banco de dados
- [ ] Implementar métodos CRUD
- [ ] Implementar tratamento de exceções
- [ ] Implementar métodos de busca

### Servlets
- [ ] Implementar lógica doGet()
- [ ] Implementar lógica doPost()
- [ ] Implementar tratamento de erros
- [ ] Implementar validações de dados
- [ ] Implementar mensagens de feedback

### Páginas JSP
- [ ] Implementar validações JavaScript
- [ ] Adicionar máscaras de entrada (CPF, telefone, placa)
- [ ] Implementar tratamento de mensagens
- [ ] Melhorar estilos CSS
- [ ] Adicionar funcionalidades de busca e filtro

### Banco de Dados
- [ ] Criar script SQL para criação das tabelas
- [ ] Criar script SQL para dados iniciais (se necessário)
- [ ] Configurar DataSource no Tomcat (opcional)

## Estrutura de Banco de Dados Sugerida

```sql
-- Tabela de Clientes
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(200)
);

-- Tabela de Veículos
CREATE TABLE veiculo (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(10) UNIQUE NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(30),
    tipo VARCHAR(30),
    disponivel BOOLEAN DEFAULT TRUE
);

-- Tabela de Reservas
CREATE TABLE reserva (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    veiculo_id BIGINT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Pendente',
    FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    FOREIGN KEY (veiculo_id) REFERENCES veiculo(id)
);
```

## Notas Importantes

- Todos os arquivos foram criados com comentários TODO indicando onde cada funcionalidade deve ser implementada
- O projeto está configurado para usar UTF-8 em todas as páginas
- Os Servlets estão configurados com anotações @WebServlet para facilitar o mapeamento
- O projeto está preparado para uso com Maven, mas pode ser usado sem ele

## Como publicar suas alterações no GitHub

Se você já fez commits locais e não está vendo as mudanças no GitHub, verifique estes pontos:

1. Confirme o `remote` configurado para seu repositório:
   ```bash
   git remote -v
   ```
   Certifique-se de que `origin` aponta para a URL do seu repositório no GitHub.

2. Envie o branch atual para o GitHub (substitua `work` pelo nome do seu branch, se for outro):
   ```bash
   git push -u origin work
   ```

3. Caso esteja trabalhando em outro branch, troque para ele antes de fazer o push:
   ```bash
   git checkout <nome-do-branch>
   git push -u origin <nome-do-branch>
   ```

4. Se o push exigir autenticação, garanta que você está usando um token de acesso pessoal ou chave SSH configurada na sua conta GitHub.

Seguindo esses passos, os commits locais passarão a aparecer no repositório remoto.

## Licença

Este projeto foi desenvolvido para fins educacionais.

