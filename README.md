# Plain Posting Program

API REST em **Spring Boot (Java 21)** com persistência em **MongoDB**, modelando um mini-sistema de **Usuários** e **Posts**, incluindo endpoints de busca por texto (title/body) e filtros por período.

> OBS: Na inicialização, a classe `Instantiation` (`CommandLineRunner`) **apaga as coleções** e **insere dados de exemplo**.

---

## 📌 Stack

- Java 21 (LTS)
- Spring Boot 3.5.6
- MongoDB
- Maven

---

## ✅ Requisitos

- Java 21 configurado no terminal (verifique com `mvn -v`)
- Maven 3.9+
- MongoDB (local ou via Docker)

---

## ⚙️ Configuração

A aplicação utiliza as configurações em `src/main/resources/application.properties`.

Principais pontos:

- Porta: `server.port=${port:8888}` (**usa a env var `port`**, minúscula)
- MongoDB: `spring.data.mongodb.uri=mongodb://localhost:27017/plain_posting_program`

### Variáveis de ambiente úteis

- `port` (default `8888`)
- `SPRING_DATA_MONGODB_URI` (para apontar o app para outro Mongo)

Exemplo:

```bash
export port=8888
export SPRING_DATA_MONGODB_URI='mongodb://localhost:27017/plain_posting_program'
```

---

## Rodando localmente

### 1) Suba um MongoDB local (exemplo com Docker)

```bash
docker run --rm -d \
  --name plainposting-mongo \
  -p 27017:27017 \
  mongo:7
```

### 2) Rode a aplicação

```bash
mvn clean spring-boot:run
```

A API vai subir em:  
**http://localhost:8888**

---

## Endpoints

### Usuários

- `GET /users/find-all-users`
- `GET /users/find-user-{id}`
- `POST /users/create-user`
- `PUT /users/update-user-{id}`
- `DELETE /users/delete-user-{id}`
- `GET /users/find-posts-by-user-{id}`

#### Exemplo (criar usuário)

```bash
curl -X POST 'http://localhost:8888/users/create-user' \
  -H 'Content-Type: application/json' \
  -d '{"name":"Ana","email":"ana@email.com"}'
```

---

### Posts

- `GET /posts/find-post-{id}`
- `GET /posts/search-post-by-text-title?titleParam=...`
- `GET /posts/search-post-by-text-body?bodyParam=...`
- `GET /posts/search-post-by-multiple-fields?textParam=...&minDateParam=dd/MM/yyyy&maxDateParam=dd/MM/yyyy`

#### Exemplo (buscar por título)

```bash
curl 'http://localhost:8888/posts/search-post-by-text-title?titleParam=bom%20dia'
```

---

## Rodando com Docker

### Build da imagem

Na raiz do projeto:

```bash
docker build -t plainpostingprogram:local .
```

---

### Executar (Mongo fora do container)

Se você já tem um Mongo rodando na sua máquina (`localhost:27017`), lembre-se que **de dentro do container** `localhost` aponta para o próprio container.

A forma mais simples é rodar os dois containers na mesma rede e usar o nome do serviço.

---

### Executar com Mongo em container (recomendado)

#### 1) Crie uma rede

```bash
docker network create plainposting-net
```

#### 2) Suba o Mongo

```bash
docker run --rm -d \
  --name plainposting-mongo \
  --network plainposting-net \
  mongo:7
```

#### 3) Suba a API apontando para o Mongo

```bash
docker run --rm -p 8888:8888 \
  --name plainposting-api \
  --network plainposting-net \
  -e SPRING_DATA_MONGODB_URI='mongodb://plainposting-mongo:27017/plain_posting_program' \
  -e port=8888 \
  plainpostingprogram:local
```

A API vai estar em:  
**http://localhost:8888**

---

## (Opcional) Docker Compose

Se você preferir, pode criar um `docker-compose.yml` com:

```yaml
services:
  mongo:
    image: mongo:7
    ports:
      - "27017:27017"

  api:
    build: .
    ports:
      - "8888:8888"
    environment:
      port: 8888
      SPRING_DATA_MONGODB_URI: mongodb://mongo:27017/plain_posting_program
    depends_on:
      - mongo
```

E subir com:

```bash
docker compose up --build
```

---

## Observações importantes

- **Seed / Reset do banco:** a classe `Instantiation` executa `deleteAll()` em `UserRepository` e `PostRepository` a cada boot e reinicializa dados de exemplo.  
  Se você não quiser isso em produção, comente/remova esse `CommandLineRunner`.

---

## Licença


