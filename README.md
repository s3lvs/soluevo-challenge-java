# Challenge Java
O objetivo do desafio abaixo é criar uma aplicação com Spring Boot 2.7.0 e Java 11. 

O desafio se divide em 2 seções: **Obrigatório e Desejado**. Você DEVE concluir todas as tarefas da seção **Obrigatório** caso contrário o desafio será considerado como não concluído. Na seção **Desejado** quanto mais itens você concluir maior será sua pontuação na avaliação final.

A pontuação final servirá para classificação de Junior, Pleno, Senior ou Especialista. 

## O desafio
Precisamos de uma API RESTful capaz de controlar o saldo bancário (R$) dos clientes. Você DEVE criar uma branch `feature/seu-usuario-github` a partir da `main`. 

**IMPORTANTE**:
- Você tem 2 horas para completar o desafio.
- Faça o push da sua branch antes do desafio terminar, só será considerado código que foi enviado para a sua branch.
- Você perderá o acesso automaticamente após 2 horas, por isso é importante enviar tudo que você conseguir antes do fim do desafio.

### Tarefas Obrigatórias
A API deve ser capaz de:
- Cadastrar um novo cliente. 
  - CPF (deve ter exatamente 11 números).
  - Nome (length max 150, length min 20).
  - Data Nascimento (dd/mm/yyyy).
  - Situação (Ativo/Inativo) , ativo por padrão, para controle interno da API, cliente não pode mudar esse valor.
  - Saldo (2 casas decimais após a virgula, padrão 0.00).
  - Todos os campos são obrigatórios.
  - CPF deve ser PK. 
- Deletar um cliente, apenas se ele tiver saldo zerado. Caso o saldo não seja zerado devemos avisar que o saldo precisa ser zerado antes. 
  - A deleção deve ser apenas lógica, mudando a Situação de Ativo para Inativo.
- Atualizar um cliente. 
  - Permite atualização apenas do Nome e Data de nascimento. 
- Atualizar Saldo. 
  - Recebe um valor que deve ser somado ao saldo atual.
  - Se o valor for negativo, então deve ser subtraído do saldo atual.
  - Se o valor a ser retirado (negativo) for maior que o saldo atual, deve retornar uma mensagem dizendo que não há saldo suficiente.

A API deve usar as seguintes tecnologias:
- Java 11
- Maven 3.x
- Swagger
- Spring Boot 2.7.0
  - Spring Data
  - Spring Web
- Banco de dados PostgreSQL com Docker Compose.
- POSTMAN (Deve ser criada uma collection no POSTMAN e disponibilizada ao fim do desafio)


### Tarefas Desejadas
- Gerar testes unitários e integrados com jUnit, Mockito, Spring Boot Test e Wiremock. Coverage mínimo de 80%. 
- Logs em formato JSON com Log4j2. 
- Adicionar a aplicação ao docker compose já existente.
- Criar healthcheck para liveness e readiness probe. 
- Registrar métricas padrões no formato do Prometheus.
- Registrar métricas customizadas no formato do Prometheus. 
  - Counter para cada chamada ao endpoint de  *Atualização de Saldo* 
- Criar arquivo de Deployment para Kubernetes
  - Namespace challenge-java
  - Image URI: Seu Dockerhub. 
  - CPU limit 1, CPU request 500m 
  - Memory limit 1560Mi, Memory request 518mi
  - Para valores não mencionados aqui, fique a vontade para escolher um de sua preferência.
- Criar arquivo de Service para Kubernetes
  - Usando spec.type ClusterIP
  - Para valores não mencionados aqui, fique a vontade para escolher um de sua preferência.
- Criar arquivo de Configmap para Kubernetes
  - Contendo a URL jdbc do postgres (pode usar uma fake URL)
  - Para valores não mencionados aqui, fique a vontade para escolher um de sua preferência.


### Artefatos Esperados
- Aplicação rodando sem erros ao executar `mvn spring-boot:run`
- Collection POSTMAN com todos os endpoints
- Docker compose para subir o PostgreSQL