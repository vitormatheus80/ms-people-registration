# API de Pessoas

A API de Pessoas é uma aplicação que permite cadastrar, buscar e atualizar informações de pessoas e seus endereços.

- POST /persons: Cadastra uma nova pessoa com nome e data de nascimento.
- POST /addresses: Cadastra um novo endereço para a pessoa com o ID especificado.
- GET /persons: Retorna uma lista de todas as pessoas cadastradas.
- GET /persons/{id}: Retorna os dados da pessoa com o ID especificado.
- GET /persons/{id}/addresses: Retorna uma lista de endereços da pessoa com o ID especificado.
- GET /persons/{id}/addresses-main: Retorna o endereço padrão da pessoa com o ID especificado.
- PUT /persons/{id}: Atualiza dados de uma pessoa por ID.
- PUT /persons/{id}/addresses/{addressId}/set-main: Atualiza o endereço padrão de uma pessoa, especificando o id da pessoa e do endereço

Exemplo de JSON para cadastrar uma nova pessoa:

```json
{
    "name":"Vitor",
    "birthdate":"1993-02-20"
}
```

Exemplo de JSON para cadastrar um novo endereço para uma pessoa com ID 1:

```json
{
    "id": 1,
    "street": "Rua M",
    "zipcode": "8888-888",
    "number": "100",
    "city": "São Paulo"
}
```
## Tecnologias utilizadas
* Java 17
* Spring boot
* JPA
* MySql
