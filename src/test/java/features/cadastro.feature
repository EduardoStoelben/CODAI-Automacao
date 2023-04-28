Feature: Cadastro
  Como um usuário
  Eu quero me cadastrar no sistema
  Para poder utilizar os recursos disponíveis

  Scenario: Cadastro com sucesso
    Given que estou no modal de cadastro
    When Quando eu preencho os campos com minhas informações
    And clico no botão Criar conta
    Then Devo receber a mensagem de conta criada com sucesso