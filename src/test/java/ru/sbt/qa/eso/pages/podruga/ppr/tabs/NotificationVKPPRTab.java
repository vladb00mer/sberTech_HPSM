package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

import junit.framework.Assert;
import org.openqa.selenium.By;
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

public class NotificationVKPPRTab extends Page {
    
    @FindBy(xpath = "//a[@id='X135_t']")
    private WebElement tabHeader;
    
    @FindBy(xpath = "//input[@id='X139']")
    private WebElement userNotificationDropBox;
    
    @FindBy(xpath = "//span[@id='X138']")
    private WebElement labelToClick;
    
    @FindBy(xpath = "//input[@id='X148']")
    private WebElement notificationHeader;
    
    @FindBy(xpath = "//textarea[@id='X150']")
    private WebElement notificationBody;
    
    @FindBy(xpath = "//button[@id='X153Btn']")
    private WebElement selectTerritoryButton;
    
    
    public NotificationVKPPRTab(){
        
        Init.getWebDriver().switchTo().defaultContent();
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(tabHeader));
        tabHeader.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(userNotificationDropBox));
    }
    
    public void sayYes() {
        
        userNotificationDropBox.clear();
        userNotificationDropBox.sendKeys("Да");
        tabHeader.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(notificationHeader));        
        Assert.assertTrue(notificationHeader.isDisplayed());
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(notificationBody));        
        Assert.assertTrue(notificationBody.isDisplayed());
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(selectTerritoryButton));        
        Assert.assertTrue(selectTerritoryButton.isDisplayed());
    }
    
    public void sayNo() {
        
        userNotificationDropBox.clear();
        userNotificationDropBox.sendKeys("Нет");
        labelToClick.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.invisibilityOfElementLocated(By.id("X148")));
        
        Assert.assertFalse(notificationHeader.isDisplayed());
        Assert.assertFalse(notificationBody.isDisplayed());
        Assert.assertFalse(selectTerritoryButton.isDisplayed());
    }    
}
