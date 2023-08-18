
Feature: Cadastro nikel
  Background: acessar o site do nikel
    Given eu acessei o site do nikel

  Scenario Outline: Validações de cadastro
    When fiz o cadastro com o email <email> e a senha <password>
    Then eu vizualizei a mensagem <message>
    Examples:
      |email                    |password      |message                                |
      |"growdev@gmail.com"      |"1234"        |""                                     |
      |"growdevgmailcom"        |"1234"        |"O e-mail é inválido."                 |
      |"growdev@gmail.com"      |"123"         |"A senha deve ter no mínimo 4 digitos."|
      |""                       |"1234"        |"O e-mail é inválido."                 |
      |"growdev@gmail.com"      |""            |"A senha deve ter no mínimo 4 digitos."|