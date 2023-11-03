
# Desafio Backend Dev Jr

Desafio técnico para vaga de desenvolvedor Backend.



## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/CleuJunior/padotec.coding.tests.git
```

Entre no diretório do projeto

```bash
  cd ./padotec.coding.tests
```

Rodando imagem do RabbitMQ
```bash
  docker-compose up -d ./docker
```

Porta raíz do sistema
```
  http://localhost:8080
```

Painel de controle H2
```
  http://localhost:8080/h2-console
```

Painel de controle RabbitMQ
```
  http://localhost:15672
```




## Autorizações

#### Painel de controle H2 Database
- **JDBC URL:** jdbc:h2:mem:padotec
- **Usuario:** cleonildo
- **Senha:** test

#### Painel de controle RabbitMQ
- **Usuario:** guest
- **Senha:** guest


#### RabbitMQ Queue
- **Direct Exchange:** ExchangeIoT
- **Queue:** ms.iot
- **Routing Key:** routing.key.iot

## Funcionalidades

- CRUD IoT
- Chamada para Endpoints
- Chamada para fila de menssageria



## Stack utilizada

**Back-end:** Java, SpringBoot

**Banco de Dados:** H2 Database

**Mensageria :** RabbitMQ

**Ferramenta para testes de Endpoints:** Postman


