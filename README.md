# API de Aula

## Visão Geral

Este projeto é uma API REST simples desenvolvida com Spring Boot para fins educacionais, oferecida como parte do curso de Tecnologia em Análise e Desenvolvimento de Sistemas da FATEC.

## Tecnologias

| Tecnologia | Versão | Descrição |
|------------|--------|----------|
| Java | 21 | Linguagem de programação orientada a objetos |
| Spring Boot | 4.0.6 | Framework para criação de aplicações Java |
| Maven | - | Gerenciador de dependências e build |
| YAML | - | Formato de arquivo de configuração |

### Detalhes das Dependências

- **spring-boot-starter-webmvc**: Fornece suporte para criação de APIs REST com Spring MVC
- **spring-boot-starter-webmvc-test**: Dependência para testes de aplicações web

## Estrutura do Projeto

```
aulaapi/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/fatec/aulaapi/
│   │   │       ├── AulaapiApplication.java    (classe principal)
│   │   │       ├── controller/                  (controladores REST)
│   │   │       │   ├── ClienteController.java
│   │   │       │   ├── ProdutoController.java
│   │   │       │   └── TesteController.java
│   │   │       └── dto/                       (objetos de transferência de dados)
│   │   │           ├── Cliente.java
│   │   │           └── Produto.java
│   │   └── resources/
│   │       └── application.yaml               (configurações da aplicação)
│   └── test/
│       └── java/
│           └── br/fatec/aulaapi/
│               └── AulaapiApplicationTests.java
├── pom.xml                                      (arquivo de configuração Maven)
├── mvnw                                          (wrapper Maven para Linux/macOS)
├── mvnw.cmd                                      (wrapper Maven para Windows)
└── target/                                       (diretório de compilação)
```

## Instalação

### Pré-requisitos

- Java Development Kit (JDK) 21 ou superior
- Maven (ou use o wrapper incluso)

### Passos para Instalação

1. Clone o repositório:

```bash
git clone <url-do-repositorio>
cd aulaapi
```

2. Compile o projeto:

```bash
# Usando o wrapper Maven (Linux/macOS)
./mvnw clean install

# Usando o wrapper Maven (Windows)
.\mvnw.cmd clean install

# Ou usando Maven diretamente
mvn clean install
```

3. Aguarde a compilação ser concluída. O Maven ira baixar todas as dependências necessárias.

## Execução

### Iniciar a Aplicação

```bash
# Usando o wrapper Maven (Linux/macOS)
./mvnw spring-boot:run

# Usando o wrapper Maven (Windows)
.\mvnw.cmd spring-boot:run

# Ou usando Maven diretamente
mvn spring-boot:run
```

### Acessar a Aplicação

A aplicação estará disponível em:

- URL base: `http://localhost:8080`
- API Documentation (Swagger): `http://localhost:8080/swagger-ui.html` (se configurado)

### Parar a Aplicação

Pressione `Ctrl + C` no terminal onde a aplicação está em execução.

## Endpoints da API

A API expõe os seguintes endpoints:

### Produtos

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Retorna um produto específico |
| POST | `/produtos` | Cria um novo produto |
| PUT | `/produtos/{id}` | Atualiza um produto existente |
| DELETE | `/produtos/{id}` | Remove um produto |

### Clientes

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | `/clientes` | Lista todos os clientes |
| GET | `/clientes/{id}` | Retorna um cliente específico |
| POST | `/clientes` | Cria um novo cliente |
| PUT | `/clientes/{id}` | Atualiza um cliente existente |
| DELETE | `/clientes/{id}` | Remove um cliente |

### Outros Endpoints

| Método | Endpoint | Descrição |
|--------|----------|------------|
| GET | `/teste` | Endpoint de teste |
| GET | `/temp` | Endpoint temporário |

## Testes

### Executar os Testes

```bash
# Usando o wrapper Maven
./mvnw test

# Ou usando Maven diretamente
mvn test
```

### Executar Testes com Cobertura

```bash
./mvnw test jacoco:report
```

O relatório de cobertura será gerado em `target/site/jacoco/index.html`.

## Configuração

### Arquivo application.yaml

O arquivo de configuração principal está localizado em `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: aulaapi
```

### Configurações Adicionais Comuns

Para adicionar mais configurações, edite o arquivo `application.yaml`. Exemplos:

```yaml
spring:
  application:
    name: aulaapi
  server:
    port: 8080

logging:
  level:
    br.fatec.aulaapi: DEBUG
```

## Build para Produção

### Gerar o JAR executável

```bash
./mvnw clean package
```

O arquivo JAR será gerado em `target/aulaapi-0.0.1-SNAPSHOT.jar`.

### Executar o JAR

```bash
java -jar target/aulaapi-0.0.1-SNAPSHOT.jar
```

## Troubleshooting

### Problemas Comuns

1. **Porta já em uso**: Altere a porta no arquivo `application.yaml` ou pare o processo que está usando a porta 8080.

2. **Java não encontrado**: Verifique se o JDK 21 está instalado corretamente:
   ```bash
   java -version
   ```

3. **Erro de compilação**: Execute `mvn clean install` para limpar e recompilar o projeto.

## Contribuição

Para contribuir com este projeto:

1. Fork o repositório
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Crie um Pull Request

## Licença

Este projeto é para fins educacionais.

---

Desenvolvido como parte do curso de Análise e Desenvolvimento de Sistemas da FATEC.