package pageobjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        elementClick(By.id("link-conta"));
        validateModalCadastro();

    }

    public void btnCriarConta(){
        elementClick(By.cssSelector("#create-form > div.modal-footer > button.btn.button-default"));
    }

    public void inputEmailCadastro(String email){
        elementSendKeys(By.id("email-create-input"), email);
    }

    public void inputSenhaCadastro(String senha){
        elementSendKeys(By.id("create-password-input"), senha);
    }

    public void validateModalCadastro(){
        validatePage(By.id("create-form"),"0");
    }

    public void validatePagLogin(){
        Assert.assertTrue(getElement(By.id("login-form")).isDisplayed(),
                "Não foi possível validar a página ");
        appendToReport();
    }

    public void validatePop(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
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


}
