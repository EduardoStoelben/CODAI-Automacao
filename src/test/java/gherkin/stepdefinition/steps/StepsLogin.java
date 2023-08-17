package gherkin.stepdefinition.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPO;

public class StepsLogin {

    LoginPO loginPO;
    @Given("que estou no na tela de login")
    public void que_estou_no_na_tela_de_login() {
        loginPO = new LoginPO();
        loginPO.validatePagLogin();
    }

    @When("Quando eu preencho o login com minhas informações")
    public void quando_eu_preencho_o_login_com_minhas_informações() {
        loginPO.inputEmailLogin("admin@admin.com.br");
        loginPO.inputSenhaLogin("123456");
    }
    @And("clico no botão Entrar")
    public void clico_no_botão_entrar() {

        loginPO.btnLogin();
    }
    @Then("Devo efetuar login e vizualizar a pagina home")
    public void devo_efetuar_login_e_vizualizar_a_pagina_home() {

    }

}
