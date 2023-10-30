
Este README fornece instruções sobre como executar uma aplicação Spring Boot que usa MySQL e Swagger.

<br/>

### Requisitos

<br/>

* Java 17 ou superior
* Maven
* MySQL

<br/>

### Execução

<br/>

1. Crie um banco de dados MySQL chamado `JPspring`.
2. Edite o arquivo `application.properties` na pasta `src/main/resources` e configure as seguintes propriedades:
   
    ```
   spring.datasource.url=jdbc:mysql://localhost:3306/library
   spring.datasource.username=root
   spring.datasource.password=password
   ```
3. Execute o seguinte comando como alternativa para iniciar a aplicação:

    ```
    mvn spring-boot:run
    ```
4. Pronto! você pode testar a aplicação e ter informações mais detalhadas no seguinte link:
   http://localhost:8080/swagger-ui/index.html

   <br/>
   O banco de dados é estrutura automaticamente quando a aplicação é iniciada. Você pode visualizar os dados usando o MySQL workbench ou a ferramenta de preferência.
   <br/>

### Stack utilizada

<br/>

<div>
  <img src ="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" height="30px" alt="spring badge">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" height="30px" alt="java badge"/>  
  <img src="https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white" height="30px" alt="mysql badge"/>
  <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" height="30px" alt="maven badge"/>
</div>
