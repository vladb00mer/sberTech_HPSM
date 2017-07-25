package ru.sbt.qa.eso.pages.podruga.sla.subscriptions;

import junit.framework.Assert;
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

public class SubscriptionPage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Активна')]")
    private WebElement isActiveButton;
        
    @FindBy(xpath = "//button[contains(text(),'Архив')]")
    private WebElement isArchiveButton;
        
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    @FindBy(id = "X5Readonly")
    private WebElement subscriberType;
    
    @FindBy(id = "X9Readonly")
    private WebElement serviceInstance;
    
    @FindBy(id = "X12Readonly")
    private WebElement subscriber;
    
    public SubscriptionPage(){
                
        PageFactory.initElements(Init.getWebDriver(), this);        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void activateSubscription() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActiveButton));
        isActiveButton.click();
    }
    
    public void saveSubscription() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
    
    public void deleteSubscription() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(confirmDeleting));
        confirmDeleting.click();
    }
 
    public SubscriptionPage archivateSubscription() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isArchiveButton));
        isArchiveButton.click();
        
        return this;        
    }
    
    public void verifySubscription(String instance, String type, String signer) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        Assert.assertTrue("Экземпляр подписки заполнен некорректно: "+serviceInstance.getAttribute("value"), serviceInstance.getAttribute("value").equals(instance));
        Assert.assertTrue("Тип подписчика заполнен некорректно: "+subscriberType.getAttribute("value"), subscriberType.getAttribute("value").equals(type));
        Assert.assertTrue("Экземпляр подписки заполнен некорректно: "+subscriber.getAttribute("value"), subscriber.getAttribute("value").contains(signer));
    }
}
