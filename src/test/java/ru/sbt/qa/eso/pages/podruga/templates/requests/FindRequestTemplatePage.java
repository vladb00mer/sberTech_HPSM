package ru.sbt.qa.eso.pages.podruga.templates.requests;

import junit.framework.Assert;
import org.openqa.selenium.Keys;
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

public class FindRequestTemplatePage {
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createRequestTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'Подсчитать')]")
    private WebElement countTemplates;
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement comebackButton;
    
    @FindBy(id = "o")
    private WebElement okNotFoundButton; 
    
    @FindBy(id = "X3")
    private WebElement isActiveCheckBox;
    
    @FindBy(id = "X33")
    private WebElement templateVisibleName;
    
    public FindRequestTemplatePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createRequestTemplate));
    }
    
    public void findRequestTemplate(String visibleName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActiveCheckBox));
        templateVisibleName.sendKeys(visibleName);
        templateVisibleName.sendKeys(Keys.ENTER);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(templateVisibleName));
        
        Assert.assertTrue(templateVisibleName.isEnabled());
        Assert.assertTrue("Отображаемое имя = "+templateVisibleName.getAttribute("value"), templateVisibleName.getAttribute("value").equals(visibleName));
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));     
        okButton.click();
    }
    
    public void findEmptyRequestTemplate() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(templateVisibleName));
        templateVisibleName.clear();
        templateVisibleName.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(countTemplates));
        
        Assert.assertTrue(countTemplates.isDisplayed());
        
        comebackButton.click();
    }
    
    public void findMissingRequestTemplate() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(templateVisibleName));
        templateVisibleName.sendKeys("такого шаблона нет и быть не может!!!");
        templateVisibleName.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okNotFoundButton));
        
        Assert.assertTrue(okNotFoundButton.isDisplayed());
        
        okNotFoundButton.click();
    }
}
