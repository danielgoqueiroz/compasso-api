#Contect Path
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
    "name": "Nome", // maior que 4 caracteres
    "password": "12345678", // deve ser maior que 8 caracteres
    "cpf" : "654987321", // deve ser maior que 8 caracteres
    "email": "teste@email.com" // deve ter padrão válido de email
}
```

