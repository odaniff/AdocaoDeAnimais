# Sistema de Adoção de Animais

Este é um projeto Spring Boot para gerenciamento de adoção de animais.

## Requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

## Como executar

1. Clone o repositório
2. Na raiz do projeto, execute:
   ```bash
   mvn spring-boot:run
   ```
3. A aplicação estará disponível em: http://localhost:8080
4. O console H2 (banco de dados) estará disponível em: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:file:./data/adocaoanimais
   - Username: sa
   - Password: password

## Tecnologias utilizadas

- Spring Boot 3.2.3
- Spring Data JPA
- H2 Database
- Maven 