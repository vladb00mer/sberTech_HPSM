package ru.sbt.qa.eso.pages.podruga.checklist.itemGroup;

import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;

/**
 *
 * @author sbt-murashov-vv
 */

public class ItemGroupPage {
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "X4")
    private WebElement number;
    
    @FindBy(id = "X7")
    private WebElement name;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    
    public ItemGroupPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
    }
    
    public void verifyItemGroup(String verifyName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(name));
        Assert.assertTrue("Название группы пунктов = "+name.getAttribute("value"), name.getAttribute("value").equals(verifyName));
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }
    
    public void modifyItemGroup() {
        
        Init.getWebDriver().switchTo().frame(1);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(number));
        
        Assert.assertTrue("поле Номер задисейблено: "+number.getAttribute("readonly"), number.getAttribute("readonly").equals("true"));        
        Assert.assertTrue("поле Название задисейблено: "+name.getAttribute("readonly"), name.getAttribute("readonly").equals("true"));
        
        Init.getWebDriver().switchTo().defaultContent();  
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }
    
    public void deleteItemGroup() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
        
        Init.getWebDriver().switchTo().frame(1);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(confirmDeleting));
        confirmDeleting.click();
        
        Init.getWebDriver().switchTo().defaultContent();        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.visibilityOf(backButton));
        backButton.click();
    }
}