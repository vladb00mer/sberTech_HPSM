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

public class HistoryTab extends Page{
    
    @FindBy(id = "X394_t")
    private WebElement historyTabLink;
    
    @FindBy(id = "X396Btn")
    private WebElement showFullHistoryButton;
    
    @FindBy(id = "X28")
    private WebElement description1TextArea;
    
    
    public HistoryTab(){ 
                
        Init.getWebDriver().switchTo().defaultContent();
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(historyTabLink));
        historyTabLink.click();
    }
    
    public void showFullHistory() {
        
        historyTabLink.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(showFullHistoryButton));
        showFullHistoryButton.click();
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}
