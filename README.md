# Página Web de um Consultório Odontológico

Projeto Integrador desenvolvido para o curso de Desenvolvimento de Sistemas pelo SENAC-EAD.

## Status do Projeto
Em desenvolvimento

## Tecnologias Aplicadas
- HTML
- CSS
- JavaScript
- Java
- SQL

## Time de Desenvolvedores
Gustavo Novaes de Souza

## Objetivo do Software
Um sistema web de um consultório odontológico que permitirá aos pacientes:
- Realização de cadastro e login no sistema.
- Acesso às informações do consultório, como localização do mesmo, e visualização da equipe de cirurgiões-dentistas.
- Realização de agendamento de consultas, com acesso ao histórico de consultas agendadas e já realizadas.

## Funcionalidades do Sistema

### Tela de Cadastro
![Tela Cadastro](/PI-etapa7e9/src/main/resources/static/imgs/TelaCadastro.png "Tela Cadastro")

##### Requisitos Funcionais
[RF01] O sistema deve permitir o cadastro de um novo cliente no sistema, com as seguintes informações obrigatórias: login, senha, nome completo, CPF, data de nascimento, endereço, telefone e e-mail.

[RF02] O sistema deve permitir a seleção de um convênio cadastrado no sistema para associar ao paciente, caso ele(a) possua um.

[RF03] O sistema deve permitir verificar se os campos obrigatórios foram preenchidos corretamente antes de permitir o cadastro do cliente.

##### Regras de Negócio
[RN01] Campos considerados obrigatórios na tela de cadastro: login, senha, nome completo, CPF, data de nascimento, endereço, telefone e e-mail.

[RN02] Data de nascimento deve ser uma data válida no formato padrão brasileiro (dd/mm/aaaa).

### Tela de Login
![Tela Login](/PI-etapa7e9/src/main/resources/static/imgs/TelaLogin.png "Tela Login")

##### Requisitos Funcionais
[RF04] Permitir acesso as demais funcionalidades do sistema assim que o login for realizado com sucesso (login e senha válidos).

##### Regras de Negócio
[RN03] Campos considerados obrigatórios na tela de login: login, senha.

[RN04] Campo senha deve ser oculto por padrão, dando a opção de ser vísivel caso o(a) usuário(a) deseje.

[RN05] O sistema deve alertar para campos obrigatórios em branco ou inválidos após a tentativa de login.

### Tela de Agendamento de Consultas
![Tela Agendamento](/PI-etapa7e9/src/main/resources/static/imgs/TelaAgendamento.png "Tela Agendamento")

##### Requisitos Funcionais
[RF05] O sistema deve permitir o agendamento de consulta onde os seguintes campos serão utilizados: especialidade procurada, cirurgiã(o)-dentista de preferência, data, horário, número do convênio.

[RF06] O sistema deve permitir a seleção de um cirurgião-dentista cadastrado no sistema para associar ao agendamento.

##### Regras de Negócio
[RN06] Campos considerados obrigatórios na tela de agendamento de consulta: especialidade procurada, cirurgiã(o)-dentista, data e horário.

### Tela Principal
![Tela Inicial](/PI-etapa7e9/src/main/resources/static/imgs/TelaInicial.png "Tela Inicial")

##### Requisitos Funcionais
[RF07] Tela principal deve ser composta por notícias da clínica, informação de endereço e menu de navegação com acesso as outras funcionalidades

### Tela de Equipe
![Tela Equipe](/PI-etapa7e9/src/main/resources/static/imgs/TelaEquipe.png "Tela Equipe")

##### Requisitos Funcionais
[RF08] Tela contendo informações sobre a equipe que atua na clínica, dando foco aos cirurgiões-dentistas e suas especializações.

### Tela de Consultas
![Tela Consultas](/PI-etapa7e9/src/main/resources/static/imgs/TelaConsultas.png "Tela Consultas")

##### Requisitos Funcionais
[RF09] Tela contendo listagem das consultas marcadas pelo paciente.

[RF10] Sistema deve permitir o cancelamento de consultas ainda não realizadas dentre as consultas listadas.

### Tela de Sua Conta
![Tela Sua Conta](/PI-etapa7e9/src/main/resources/static/imgs/TelaSeusDados.png "Tela Sua Conta")

##### Requisitos Funcionais
[RF11] Tela contendo listagem das informações cadastradas por determinado paciente.

[RF12] Sistema deve permitir atualização dos dados do paciente.