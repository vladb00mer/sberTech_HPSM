package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

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

public class TasksPPRTab extends Page {
    
    @FindBy(xpath = "//a[@id='X180_t']")
    private WebElement tabHeader;
    
    @FindBy(xpath = "//input[@id='X184Edit']")
    private WebElement workGroup;
    
    @FindBy(xpath = "//input[@id='X190_1']")
    private WebElement taskExecutor1;
    
    @FindBy(xpath = "//input[@id='X193_1']")
    private WebElement period1;
    
    @FindBy(xpath = "//input[@id='X196_1']")
    private WebElement description1;    
    
    
    public TasksPPRTab() {
        
        Init.getWebDriver().switchTo().defaultContent();
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(tabHeader));
        tabHeader.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(taskExecutor1));
    }
    
    public void verifyFields() {
    
        Assert.assertTrue("Недоступно поле Исполнители заданий: ", taskExecutor1.isEnabled());
        Assert.assertTrue("Недоступно поле Продолжительность ", period1.isEnabled());
        Assert.assertTrue("Недоступно поле Краткое описание заданий: ", description1.isEnabled());
    }
    
    public void fillRequired(String executor) {
        
        taskExecutor1.click();
        taskExecutor1.sendKeys(executor);
        
        period1.click();
        period1.sendKeys("10:00:00");
        
        description1.sendKeys("краткое описание заданий");
    }
}
