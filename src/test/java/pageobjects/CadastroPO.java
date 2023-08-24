package pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import static report.Report.appendToReport;
import static utils.Utils.*;

public class CadastroPO {

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
    public void validateMessage(String message){
        String notify = getElement(By.cssSelector("#swal2-html-container")).getText();
        Assert.assertEquals(message,notify,"A mensagem não corresponde com a desejada");
    }

}
