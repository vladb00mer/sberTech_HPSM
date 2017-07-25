package ru.sbt.qa.eso.pages.podruga;

import org.openqa.selenium.Keys;
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

public class EventOutPage extends Page {
    
    @FindBy(xpath = "//table[@id='cwc_Masthead']//input[@aria-label='Команда']")
    protected WebElement commandInputArea;
    
    @FindBy(xpath = "//button[contains(text(),'Поиск')]")
    protected WebElement searchButton;
    
    public EventOutPage() {
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        PageFactory.initElements(Init.getWebDriver(), this); 
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(commandInputArea));
        commandInputArea.sendKeys("eventout");
        commandInputArea.sendKeys(Keys.ENTER);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }
    
    
}
