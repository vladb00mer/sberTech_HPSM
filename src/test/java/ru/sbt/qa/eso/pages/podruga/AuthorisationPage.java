package ru.sbt.qa.eso.pages.podruga;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;
import ru.sbt.qa.bdd.pageFactory.ElementTitle;
import ru.sbt.qa.bdd.pageFactory.Page;

/**
 *
 * @author sbt-murashov-vv
 */

public class AuthorisationPage extends Page {
    
    @FindBy(xpath = "//input[@id='LoginUsername']")
    @ElementTitle("Логин")
    protected WebElement userNameField;
    
    @FindBy(xpath = "//input[@id='LoginPassword']")
    @ElementTitle("Пароль")
    protected WebElement passwordField;
    
    @FindBy(xpath = "//input[@id='loginBtn']")
    @ElementTitle("Вход")
    protected WebElement doLoginButton;

    public AuthorisationPage(){
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(userNameField));
    }

    public void doAuthorise(String login, String password){
        
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        doLoginButton.click();                     
    }
}
