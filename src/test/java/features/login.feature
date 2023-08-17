Feature: Login
  Como um usuário
  Eu quero acessar o sistema
  Para poder utilizar os recursos disponíveis

  Scenario: Login com sucesso
    Given que estou no na tela de login
    When Quando eu preencho o login com minhas informações
    And clico no botão Entrar
    Then Devo efetuar login e vizualizar a pagina home