package ru.sbt.qa.eso.pages.podruga.order.orders;

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

public class HistoryPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//a[contains(text(),'Связь')]")
    private WebElement relationLink;
    
    
    public HistoryPage(){ 
        
        Init.getWebDriver().switchTo().defaultContent();
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void verifyLink() {
        
        Init.getWebDriver().switchTo().frame(1);
        relationLink.click();
    }
}
