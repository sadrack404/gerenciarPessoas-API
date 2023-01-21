# Gerenciar Pessoas - API
<hr>

Essa api foi feita para demonstra um pouco do meu 
conhecimento sobre o Framework Springboot, utilizando o Banco de dados H2.

<hr>

# Desafio
Usando Spring boot, crie uma API simples para gerenciar Pessoas.<br>
Esta API deve permitir :

- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa  


## Requisitos:
### Rotas da aplicação:
<b>[GET] </b> /pessoas : A rota deverá listar todas as pessoas cadastradas<br><br>
<b>[GET] </b> /pessoas/{id} : A rota deverá buscar a pessoa com o id informado<br><br>
<b>[POST] </b> /pessoas :  A rota deverá receber nome, data de nascimento e um endereço dentro do corpo da requisição. Ao cadastrar um novo projeto, ele deverá ser armazenado dentro de um objeto no seguinte formato: { id: 1, nome: 'Gabriel', dataDeNascimento: 1971-10-20, enderecos: [{id: 1, logradouro: "Marigarida", cep: 842000, numero: 07,cidade: "Gama" }};<br><br>
<b>[PUT] </b> /pessoas/{id} : A rota deverá atualizar as informações de nome, data de nascimento ou endereço (podendo ter esse atributo ou não) <br><br>
<b>[POST] </b> /pessoas/endereco/{pessoaId} :  A rota deverá receber um logradouro, CEP, numero, cidade. O Objeto deve ser {logradouro: "Margarida", cep: 728000, numero: 03, cidade: "Gama" }<br><br>
<b>[GET] </b> /pessoas/enderecos/{pessoaId} : A rota deverá listar todos os endereços cadastrados da pessoa<br><br>

# Techs:
- Springboot
- Lombook
- Hibernate
- SQL com banco H2
- Mavem

# H2 Login
JDBC URL: jdbc:h2:mem:banco<br>
User name: sa<br>
Password: <br>
