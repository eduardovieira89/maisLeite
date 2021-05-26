<h1 align="center">Sistema MaisLeite</h1>
<div align="center">
Sistema sendo desenvolvido para controle de leitarias juntamente com front-end em angular https://github.com/eduardovieira89/maisLeiteAngular
</div>
 
 ## Compilando e executando o sistema
 ### Ferramentas necessárias
 - [MySql](https://www.mysql.com/downloads/) Versão 08;
   - Banco de dados (schema) com o nome: **leite2**
   - Usuario: **sistemaleitemais**
   - Senha: **sistemal3it3m@is**
   - Ou editar o arquivo `src/main/resources/application.properties` com os dados do Mysql da máquina local.
    
 - [Java JDK](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) versão 15 ou superior;
 - [Apache Maven](https://maven.apache.org/download.cgi) com as váriaveis de ambiente [configuradas](https://maven.apache.org/install.html);
 - Para edição do código fonte, uma IDE de sua preferência, estou usando [Spring Tool Suite 4](https://spring.io/tools) para eclipse.

### Compilando e executando
```bash
# Clone este repositório
$ git clone <https://github.com/eduardovieira89/maisLeite.git>

# Acesse a pasta do projeto no terminal/cmd
$cd maisLeite
Onde o arquivo pom.xml se encontra

#Execute os seguintes comandos para o Maven baixar as bibliotecas e gerar o arquivo jar
$mvn clean
$mvn install

#Acesse a pasta template que o maven gerou
$cd target

#Execute o arquivo jar
$java -jar maisLeite-0.0.1-SNAPSHOT.jar

#O Spring estará rodando, baixe e execute o projeto angular para acessar o sistema

```
```bash
Ou pode rodar a aplicação a partir da IDE
```

## Continua...


