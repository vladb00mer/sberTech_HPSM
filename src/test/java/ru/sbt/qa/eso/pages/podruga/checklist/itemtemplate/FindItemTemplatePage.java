package ru.sbt.qa.eso.pages.podruga.checklist.itemtemplate;

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

public class FindItemTemplatePage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createItemTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "X3Edit")
    private WebElement isActiveCheckBox; 
    
    @FindBy(id = "X7")
    private WebElement itemTemplateName; 
    
    @FindBy(id = "X9")
    private WebElement itemTemplateGroup;
    
    @FindBy(id = "X11")
    private WebElement hozExpCheckBox;
    
    @FindBy(id = "X18")
    private WebElement hozExpValue;
    
    @FindBy(id = "X13")
    private WebElement techExpCheckBox;
    
    @FindBy(id = "X19")
    private WebElement techExpValue;
    
    @FindBy(id = "X15")
    private WebElement engExpCheckBox;
    
    @FindBy(id = "X20")
    private WebElement engExpValue;
    
    @FindBy(id = "X29")
    private WebElement commentTemplate;
    
    public FindItemTemplatePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createItemTemplate));
    }
    
    public void createItemTemplate(String name, String group, String expType1, String expType2, String expType3, String comment) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActiveCheckBox));
        isActiveCheckBox.click();
        
        itemTemplateName.click();
        itemTemplateName.sendKeys(name);
        
        itemTemplateGroup.click();
        itemTemplateGroup.sendKeys(group);
        
        hozExpCheckBox.click();
        hozExpValue.sendKeys(expType1);
        
        techExpCheckBox.click();
        techExpValue.sendKeys(expType2);
        
        engExpCheckBox.click();
        engExpValue.sendKeys(expType3);
                
        commentTemplate.sendKeys(comment);
        
        Init.getWebDriver().switchTo().defaultContent();
        createItemTemplate.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));        
        backButton.click();
    }
    
    public void findItemTemplate(String name) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(itemTemplateName));
        
        itemTemplateName.sendKeys(name);
        itemTemplateName.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}