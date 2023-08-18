package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static report.Report.appendToReport;
import static utils.Utils.*;

public class CadastroPO {

    WebDriver driver;

    public void btnModalCadastro(){
        elementClick(By.cssSelector("#btnCadastro"));
    }

    public void btnCriarConta(){
        elementClick(By.cssSelector("#criarConta"));
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
    public void cadastro(String email,String password){
        btnCriarConta();
        validateModalCadastro();
        inputEmailCadastro(email);
        inputSenhaCadastro(password);
        btnModalCadastro();
    }

    public void validateCadastroEmailInvalido(String message) {
        WebElement errorMessage = getElement(By.className("#create-form > div.modal-body > div:nth-child(1) > p"));
        Assert.assertTrue(errorMessage.getText().contains(message));
    }

    public void validateCadastroSenhaInvalida(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#create-form > div.modal-body > div:nth-child(2) > p"));
        Assert.assertTrue(errorMessage.getText().contains(message));
    }

    public void validateCadastro(String email, String password, String message){
        //appendToReport();
        if (!email.isEmpty() && password.isEmpty()){
            System.out.println("1");
            validateCadastroSenhaInvalida(message);
        }else if(email.isEmpty() && !password.isEmpty()){
            System.out.println("2");
            validateCadastroEmailInvalido(message);
        }else if (!email.isEmpty() && !password.isEmpty()){

            if(email.contains("growdev@gmail.com") && password.contains("1234")){
                System.out.println("teste");
            }else if(isElementPresent(By.id("errorEmail"))){
                System.out.println("3");
                validateCadastroEmailInvalido(message);
            }else if (isElementPresent(By.id("errorPassword"))){
                System.out.println("4");
                validateCadastroSenhaInvalida(message);
            }

        }

    }

    public void validateCadastroNikel(String email, String password, String message){
        validateCadastro(email,password,message);
    }
}
