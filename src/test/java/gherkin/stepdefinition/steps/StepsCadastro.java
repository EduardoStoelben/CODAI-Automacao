package gherkin.stepdefinition.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.CadastroPO;
import pageobjects.LoginPO;

public class StepsCadastro {

    String ema;
    String pass;
    CadastroPO cadastroPO;
    LoginPO loginPO;

    @Given("eu acessei o site do nikel")
    public void eu_acessei_o_site_do_nikel() {
        cadastroPO = new CadastroPO();
        loginPO = new LoginPO();
        loginPO.validatePagLogin();
    }
    @When("fiz o cadastro com o email {string} e a senha {string}")
    public void fiz_o_cadastro_com_o_email_e_a_senha(String email, String password) {
        ema = email;
        pass = password;
        cadastroPO.cadastro(ema, pass);
    }
    @Then("eu vizualizei a mensagem {string}")
    public void eu_vizualizei_a_mensagem(String message) {
        cadastroPO.validateMessage(message);
    }
}
