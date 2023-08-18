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

    public void validatePagLogin(){
        Assert.assertTrue(getElement(By.id("login-form")).isDisplayed(),
                "Não foi possível validar a página ");
        appendToReport();
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
