# Plain Posting Program
API REST em **Spring Boot (Java 21)** com persistência em **MongoDB**, modelando um mini-sistema de **Usuários** e **Posts**, incluindo endpoints de busca por texto (title/body) e filtros por período.
> OBS: Na inicialização, a classe `Instantiation` (`CommandLineRunner`) **apaga as coleções** e **insere dados de exemplo**.

---

## 📌 Stack
- Java 21 
- Spring Boot 3.5.9
- MongoDB
- Maven

---

## ⚙️ Running

A aplicação utiliza as configurações em `src/main/resources/application.properties`.

### A) Executando Localmente com IntelliJ
#### 1. Após clonar, utilize o IntelliJ para abrir o projeto e crie o `.env` com as variáveis necessárias:
```bash
PORT=8888
```
#### 2. No menu do IntelliJ:
- Em *File* > *Project Structure* > selecione a versão do Java > *Apply* > *OK*
#### 3. Na classe Application
- Clique no botão de reprodução ao lado da declaração da classe *Application* > *Modify Run Configuration*
- Confira versão do Java
- No campo *Environment Variables*, preencha com o path do arquivo `.env`
- *Apply* > *Run*
#### 4. O serviço estará disponível em http://localhost:8888/swagger-ui.html

### B) Executando Via Docker
#### 1. Suba os containers:
```bash
docker compose up --build
```
#### 2. O serviço estará disponível em http://localhost:8888/swagger-ui.html

---

## 🔗 Endpoints

### Usuários
- `GET /users/find-all-users`
- `GET /users/find-user-{id}`
- `POST /users/create-user`
- `PUT /users/update-user-{id}`
- `DELETE /users/delete-user-{id}`
- `GET /users/find-posts-by-user-{id}`
#### Exemplo: criar usuário
```bash
curl -X POST 'http://localhost:8888/users/create-user' \
  -H 'Content-Type: application/json' \
  -d '{"name":"Ana","email":"ana@email.com"}'
```

### Posts
- `GET /posts/find-post-{id}`
- `GET /posts/search-post-by-text-title?titleParam=...`
- `GET /posts/search-post-by-text-body?bodyParam=...`
- `GET /posts/search-post-by-multiple-fields?textParam=...&minDateParam=dd/MM/yyyy&maxDateParam=dd/MM/yyyy`
#### Exemplo: buscar por título
```bash
curl 'http://localhost:8888/posts/search-post-by-text-title?titleParam=bom%20dia'
```

---

## Observações importantes
- **Seed / Reset do banco:** a classe `Instantiation` executa `deleteAll()` em `UserRepository` e `PostRepository` a cada boot e reinicializa dados de exemplo.  
  Se você não quiser isso, comente/remova esse `CommandLineRunner`.


## Autoria
__Abner Andrade__
<div style="display: flex;">
    <a href = "https://www.linkedin.com/in/abnerandrade/"><img src="https://img.icons8.com/color/64/null/linkedin-2--v1.png" target="_blank"></a>
    <a href = "https://api.whatsapp.com/send?phone=5521973257039&text=Oi,%20Abner.%20Curti%20teu%20GitHub.%20%20Vamos%20trabalhar%20juntos?"><img src="https://img.icons8.com/color/64/null/whatsapp--v1.png" target="_blank"></a>
    <a href = "mailto:aa.abnerandrade@outlook.com"><img src="https://img.icons8.com/fluency/64/null/microsoft-outlook-2019.png" target="_blank"></a>
</div>

