package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Instant;

import static report.Report.appendToReport;
import static driver.Drivers.getDriver;
import static utils.Utils.*;
public class LoginPO {

    WebDriver driver;

    public LoginPO() {
        this.driver = getDriver();
    }
    public void btnCadastro(){
        elementClick(By.id("btnCadastro"));

    }

    public void cadastro(String email,String password){
        btnCriarConta();
        inputEmailCadastro(email);
        inputSenhaCadastro(password);
        appendToReport();
        btnCadastro();
        validatePop();

    }

    public void btnCriarConta(){
        elementClick(By.id("criarConta"));
    }

    public void inputEmailCadastro(String email){
        elementSendKeys(By.id("email-create-input"), email);
    }

    public void inputSenhaCadastro(String password){
        elementSendKeys(By.id("create-password-input"), password);
    }

    public void validateModalCadastro(){
        Assert.assertTrue(getElement(By.id("create-form")).isDisplayed(),
                "não foi possível validar o modal de cadastro");
    }

    public void validatePagLogin(){
        Assert.assertTrue(getElement(By.id("login-form")).isDisplayed(),
                "Não foi possível validar a página ");
        appendToReport();
    }

    public void validatePop(){
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        String message = "Conta criada com sucesso!";
        if (text == message){
            alert.accept();
        }

    }

   public void inputEmailLogin(String email){
       elementSendKeys(By.id("email-input"), email);
   }
   public void inputSenhaLogin(String senha){
       elementSendKeys(By.id("password-input"), senha);
   }
   public void btnLogin(){
        elementClick(By.cssSelector("#login-form > button"));
   }

   public void validateCadastroEmailInvalido(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#create-form > div.modal-body > div:nth-child(1) > p"));
        Assert.assertTrue(errorMessage.getText().contains(message));
    }

    public void validateCadastroSenhaInvalida(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#create-form > div.modal-body > div:nth-child(2) > p"));
        Assert.assertTrue(errorMessage.getText().contains(message));
    }

    public void validateCadastro(){


    }
}
