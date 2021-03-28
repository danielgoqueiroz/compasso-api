#Contect Path
/api


# Endpoint

GET /user 
Query Param - name
Query Param - id

```
POST /user
{
    "name": "Nome", // maior que 4 caracteres
    "password": "12345678", // deve ser maior que 8 caracteres
    "cpf" : "654987321", // deve ser maior que 8 caracteres
    "email": "teste@email.com" // deve ter padrão válido de email
}
```

