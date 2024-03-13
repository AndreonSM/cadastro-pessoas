```
Disclaimer: Este README vai ter altíssimo teor pessoal porque considero este desafio como um projeto pessoal que ainda há de ser continuado... lidemos
```

# Desafio de Cadastro de Pessoas - README

Este projeto consiste em uma TENTATIVA (que, até então, está falha) de aplicação web para manter dados de pessoas, utilizando tecnologias como Java, JSF (JavaServer Faces), Hibernate (JPA), PrimeFaces e PostgreSQL.

```
Nota Pessoal: O grande desafio consistia em não utilizar frameworks como Spring Boot, Quarkus ou Micronaut - em todo meu tempo como programador Java, SEMPRE usei Spring Boot. Também, nunca usei PostgreSQL, mas isso é o de menos.
```

## Decisões Técnicas e Arquiteturais:

* JavaServer Faces (JSF): O JSF foi escolhido como framework de apresentação porque foi o pedido no desafio - simples assim. E ah, ele é bom de se usar, apesar de minha pouca experiência

* Hibernate (JPA): O Hibernate foi utilizado como provedor de persistência para mapeamento objeto-relacional (ORM)- ele simplifica o acesso aos dados do banco de dados e oferece recursos para manipulação de entidades, o que simplifica bastante o trabalho com o banco em si.

* PrimeFaces: O PrimeFaces foi utilizado para adicionar componentes de interface de usuário ricos e responsivos à aplicação JSF.

* PostgreSQL: O PostgreSQL foi escolhido simplesmente porque foi o preferencial. É isso.

## Instruções para Compilar e Executar o Projeto:

* Clone o repositório do projeto para sua máquina local.
    * Certifique-se de ter o Maven instalado e configurado em seu ambiente.
    ```
    mvn -v
    ``` 
    Exemplo de saída esperada do terminal:
    ```
    Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
    Maven home: C:\bin\apache-maven-3.9.6
    Java version: 17.0.9, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-17
    Default locale: pt_BR, platform encoding: Cp1252
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```
    - - Caso não esteja instalado, [clique neste link](https://maven.apache.org/download.cgi) e baixe os arquivo indicado na linha "Binary zip archive". 

    * (Após ter o Maven corretamente instalado) No diretório raiz do projeto, execute o comando para compilar e empacotar o projeto.
    ```
    mvn clean install
    ``` 

    * Após a compilação bem-sucedida, o arquivo WAR será gerado no diretório target/. Implante o arquivo WAR gerado em um servidor de aplicação compatível, como Apache Tomcat

    * Rode o servidor de aplicação e acesse a URL: http://localhost:8080/desafio-cadastro-pessoas-0.0.1-SNAPSHOT/ , que é a raiz da aplicação. 

    * Outra sugestão:
    http://localhost:8080/desafio-cadastro-pessoas-0.0.1-SNAPSHOT/views/pessoa/listar.xhtml

## Instruções para Executar os Testes da Solução:
  * Não foram implementados, mas num mundo ideal, basta rodar, no diretório raiz do projeto, o comando 
  

    ```
    mvn test
    ```

Por: Andreon Souza de Medeiros Roseira

E-mail: andreon.souza@gmail.com