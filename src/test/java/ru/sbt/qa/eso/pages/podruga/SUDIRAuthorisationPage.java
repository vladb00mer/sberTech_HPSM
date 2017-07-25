package ru.sbt.qa.eso.pages.podruga;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.bdd.Init;
import ru.sbt.qa.bdd.pageFactory.ElementTitle;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.sbt.qa.bdd.pageFactory.Page;

/**
 *
 * @author sbt-murashov-vv
 */

public class SUDIRAuthorisationPage extends Page{

    @FindBy(id = "username")
    @ElementTitle("Логин")
    protected WebElement userNameField;
    
    @FindBy(id = "password")
    @ElementTitle("Пароль")
    protected WebElement passwordField;
    
    @FindBy(id = "submitInter")
    @ElementTitle("Вход")
    protected WebElement doLoginButton;

    public SUDIRAuthorisationPage(){
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        
        try {
            if (Init.getWebDriver().getPageSource().contains("CertUnknownCA")) {
                Init.getWebDriver().navigate().to("javascript:document.getElementById('overridelink').click()");
            }            
        } catch (Exception | AutotestError e) {
            Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, e);
        }
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(userNameField));
    }
    
    public void doAuthorise(String login, String password){
        
        userNameField.clear();
        userNameField.sendKeys(login);
        
        passwordField.clear();
        passwordField.sendKeys(password);
        
        doLoginButton.click();
    }
}
