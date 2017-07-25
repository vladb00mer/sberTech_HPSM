package ru.sbt.qa.eso.pages.podruga;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;
import ru.sbt.qa.bdd.pageFactory.Page;

/**
 *
 * @author sbt-murashov-vv
 */

public class MainPage extends Page {
    
    @FindBy(id = "masthead-user-name")
    protected WebElement userNameField;    
        
    @FindBy(xpath = "//a/span[contains(text(),'Выход')]")
    protected WebElement logOutButton;
    
    
    public MainPage() {
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        PageFactory.initElements(Init.getWebDriver(), this); 
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(logOutButton));
    }
        
    public void doLogOut() {
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
            
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.alertIsPresent());
        Init.getWebDriver().switchTo().alert().accept();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Внимание! Ошибка при таймауте!!!\n".concat(ex.toString()));
        }
    }
}
