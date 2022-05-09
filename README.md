<h1 align="center">Sistema MaisLeite</h1>
<p>
Sistema sendo desenvolvido para gestão de leitarias juntamente com front-end em angular https://github.com/eduardovieira89/maisLeiteAngular.git O principal propósito do sistema é para estudos da linguagem java, do framework spring e do Angular.
</p>

## Requisitos
- Deve permitir o acesso ao sistema somente com usuário e senha;
- Deve permitir o cadastro de novo proprietário;
- Deve permitir que o proprietário crie funcionários;
- Deve permitir que o proprietário cadastre propriedades;
- Deve permitir o cadastro de animais;
- Deve permitir o cadastro e controle de cobertura/inseminação e lactação dos animais;
- Deve manter o registro de alimentação dos animais;
- Deve manter o registro de medicamentos dos animais;
- Deve manter o controle de baixas de animais mortos e vendidos;
- Deve permitir o cadastro de leite diario da propriedade;
- Deve permitir o cadastro de receitas e despesas da propriedade.

## Andamento do projeto
### Já feito
- Acesso ao sistema permitido somente com usuario e senha;
- Cadastrando proprietário com senha para acesso;
- Proprietário pode cadastrar propriedade;
- Cadastro de animal;

### Próximas etapas
- Permitir que o proprietário cadastre funcionários;
- Corrigir alguns bugs no front;
 
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

#O Spring estará rodando, baixe e execute o projeto angular e acesse via web.

```
```bash
Ou pode rodar a aplicação a partir da IDE
```


