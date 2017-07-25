package ru.sbt.qa.eso.pages.podruga.sla.subscriptions;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
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

public class FindSubscriptionsPage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createSubscriptionButton;
    
    @FindBy(xpath = "//button[contains(text(),'Подсчитать')]")
    private WebElement countSubscriptions;
    
    @FindBy(id = "X3")
    private WebElement idField;
    
    @FindBy(id = "X5")
    private WebElement signerTypeField;
    
    @FindBy(id = "X9")
    private WebElement serviceInstanceField;
    
    @FindBy(id = "X9Fill")
    private WebElement serviceInstanceFill;
    
    @FindBy(id = "X12")
    private WebElement signerFOSField;
    
    @FindBy(id = "X12Fill")
    private WebElement signerFOSFill;
    
    @FindBy(id = "X13")
    private WebElement signerField;
    
    @FindBy(id = "X13Fill")
    private WebElement signerFill;
    
    @FindBy(id = "X21")
    private WebElement planedStartField;
    
    @FindBy(id = "X25")
    private WebElement planedEndField;
    
    
    public FindSubscriptionsPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createSubscriptionButton));
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void createSubscription(String instance, String type, String signer, String start, String end, String res) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        signerTypeField.sendKeys(type);
        
        serviceInstanceField.sendKeys(instance);
        serviceInstanceFill.click();
        
        if (type.trim().equalsIgnoreCase("Подразделение")) {
            signerFOSField.sendKeys(signer);
            signerFOSFill.click();
        
        } else {        
            signerField.sendKeys(signer);
            signerFill.click();
        }
        
        planedStartField.sendKeys(start);
        planedEndField.sendKeys(end);
        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createSubscriptionButton));
        createSubscriptionButton.click();
    }
    
    public FindSubscriptionsPage findSubscription(String instance, String type, String signer) { 
        
        Init.getWebDriver().switchTo().frame(1);
        
        if (!"".equals(instance)) {
            serviceInstanceField.click();
            serviceInstanceField.sendKeys(instance);
            serviceInstanceFill.click();
        }
        
        signerTypeField.click();
        signerTypeField.sendKeys(type);
        idField.click();
        
        if ("Отдельное лицо".equals(type)) {
            signerField.sendKeys(signer);
            signerFill.click();
        
        } else if ("Подразделение".equals(type)) {
            signerFOSField.click();
            signerFOSField.sendKeys(signer);
            signerFOSFill.click();
        }
        
        idField.click();
        idField.sendKeys(Keys.ENTER);
        
        return this;
    }
    
    public void countSubscriptions() {
        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(countSubscriptions));
        
        Init.getWebDriver().switchTo().frame(1);
        
        List<WebElement> allSubscriptions = Init.getWebDriver().findElements(By.xpath("//td/div/a"));
        
        Assert.assertTrue(allSubscriptions.size()>0);
    }
}
