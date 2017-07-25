package ru.sbt.qa.eso.pages.podruga.checklist.checklisttemplate;

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

public class FindCheckListTemplatePage {
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createCheckListTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "X10")
    private WebElement name; 
    
    @FindBy(id = "X4Edit")
    private WebElement isActive; 
    
    @FindBy(id = "commonMsg")
    private WebElement resultMessage;
    
    public FindCheckListTemplatePage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createCheckListTemplate));
    }
    
    public void findCheckListTemplate(String setName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(setName);
        name.sendKeys(Keys.ENTER);
    }
    
    public void createCheckListTemplate(String createName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActive));
        isActive.click();
        
        name.sendKeys(createName);        
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createCheckListTemplate));
        createCheckListTemplate.click();
        
        backButton.click();
    }
}