## 7DaysOfCode - Java

Projeto desenvolvido para cumprir os desafios do 7DaysOfCode da Alura. Um projeto que tem a finalidade de consumir a API do IMDB, um site que armazena dados sobre filmes, series e atores, com uma base de dados enorme.

## Tecnologias utilizadas (projeto ainda em desenvolvimento)

Aqui estao alguimas tecnologias utilizadas no desenvolvimento do projeto:

- Java

### 1 dia do desafio

No primeiro dia do desafio, foi pedido que utilizando a linguagem Java, acessassemos a API do IMDB, para poder mostar na linha de comando os Top 250 Filmes.

#### Passos realizados
- Para realizar o acesso, foi necessario efetuar cadastro na plataforma da [API-IMDB](https://imdb-api.com/api).
- Criado o projeto pelo VS Code: utilizando a paleta de comandos (Ctrl + Shift + P), sem ferramentas de build inicialmente;
- Com o projeto criado, substitui o tradicional **"Hello World" do Java**, pelo codigo responsavel para mostrar a lista de filmes;
- Dentro do metodo `main`, foram utilizadas as classes HttpRequest, HttpClient e HttpResponse, todas do pacote `java.net.http`, além da URI, do pacote `java.net.URI`;
- Foi preciso gerar um `client`, para poder realizar a requisicao, de forma que pudesse pegar o JSON da resposta e mostrar na linha de comando;

![Imagem da tela do codigo da aplicacao](assets/filmes-java-dia-1.png)


