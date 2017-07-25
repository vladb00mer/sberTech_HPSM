package ru.sbt.qa.eso.pages.podruga;

import org.junit.Assert;
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

public class LogRecordsListPage extends Page {
    
    @FindBy(id = "head-button-messagehelp")
    protected WebElement viewLogButton;
    
    @FindBy(xpath = "//div[@id='message_div']/div/div/p[3]")
    protected WebElement lastRecordInLog;
    
    @FindBy(xpath = "//button[contains(text(),'Очистить и закрыть')]")
    protected WebElement clearAndCloseButton;
    
    public LogRecordsListPage() {
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(viewLogButton));
        viewLogButton.click();
    }
    
    public void checkResult(String result) {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(lastRecordInLog));
        
        Assert.assertTrue("Результат выполнения операции: "+lastRecordInLog.getText(), lastRecordInLog.getText().contains(result));
        
        clearAndCloseButton.click();
    }
}
