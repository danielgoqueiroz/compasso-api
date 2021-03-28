#Context Path
/api


# Endpoint

## GET /user 

Busca usuários

Para busca de usuário específico usar query param, ex: 'https://compasso-api.herokuapp.com/api/user?id=5654696211037176413'

Query Param - name
Query Param - id


## POST /user
```
{
    "name": "Nome Teste", // maior que 5 caracteres
    "password": "1234567890", // deve ser maior que 8 caracteres
    "cpf" : "65498732100", // deve ser maior que 8 caracteres
    "email": "teste@email.com" // deve ter padrão válido de email
}
```

