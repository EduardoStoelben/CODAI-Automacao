package gherkin.stepdefinition.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPO;

public class StepsCadastro {

    LoginPO loginPO;

    @Given("que estou no modal de cadastro")
    public void que_estou_no_modal_de_cadastro() {
        loginPO = new LoginPO();
        loginPO.validatePagLogin();
        loginPO.btnCadastro();
    }
    @When("Quando eu preencho os campos com minhas informações")
    public void quando_eu_preencho_os_campos_com_minhas_informações() {
        loginPO.inputEmailCadastro("admin@admin.com.br");
        loginPO.inputSenhaCadastro("123456");
    }
    @When("clico no botão Criar conta")
    public void clico_no_botão_criar_conta() {
        loginPO.btnCriarConta();
    }
    @Then("Devo receber a mensagem de conta criada com sucesso")
    public void devo_receber_a_mensagem_de_conta_criada_com_sucesso() {
        loginPO.validatePop();
    }
}
