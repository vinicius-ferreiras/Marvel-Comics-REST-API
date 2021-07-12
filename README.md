# Marvel-Comics-REST-API


API REST para que usuários possam cadastrar seus Comics (livros) da Marvel.

Construída com Java e Spring no padrão arquitetural MVC.

Contém um endpoint de cadastro de usuários, outro para o cadastro de Comics, que consome a API de Comics da Marvel para obter os dados do livro e um endpoint onde é possível listar todos os Comics de um usuário.

A API consome os dados da API Marvel através do Spring Cloud Feign, para mapear o JSON de retorno foram criadas as classes do pacote RetornoJson dentro do pacote DTO.

Foram criadas três classes DTO para o objeto Usuario para que fosse possível expor/alterar dados específicos em cada método HTTP.

O tratamento de erros é feito através da classe ResourceAdvice que fica no pacote Config.

Existem várias maneiras de executar um aplicativo Spring Boot em sua máquina local. Uma maneira é executar o método main na classe ComicsAppication a partir do seu IDE.
Como alternativa, você pode usar o plugin Spring Boot Maven da seguinte maneira: mvn spring-boot: run
