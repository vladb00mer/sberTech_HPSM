package ru.sbt.qa.eso.pages.podruga.checklist.itemtemplate;

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

public class ItemTemplatePage {
        
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "X3")
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
    
    @FindBy(id = "X26_1")
    private WebElement templatePODRUGA_1;
    
    @FindBy(id = "X26_1Fill")
    private WebElement fillTemplatePODRUGA_1;
    
    @FindBy(id = "X27")
    private WebElement templateSMIT;
    
    @FindBy(id = "X29")
    private WebElement commentTemplate;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    public ItemTemplatePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));
    }
    
    public void verifyItemTemplate(String name, String group, String expType1, String expType2, String expType3, String comment) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        Assert.assertTrue("Название шаблона = "+itemTemplateName.getAttribute("value"), itemTemplateName.getAttribute("value").equals(name));
        Assert.assertTrue("Группа шаблона = "+itemTemplateGroup.getAttribute("value"), itemTemplateGroup.getAttribute("value").equals(group));
        hozExpCheckBox.isSelected();
        techExpCheckBox.isSelected();
        engExpCheckBox.isSelected();
        Assert.assertTrue("Хозяйственная эксплуатация = "+hozExpValue.getAttribute("value"), hozExpValue.getAttribute("value").equals(expType1));
        Assert.assertTrue("Техническая эксплуатация = "+techExpValue.getAttribute("value"), techExpValue.getAttribute("value").equals(expType2));
        Assert.assertTrue("Инженерная эксплуатация = "+engExpValue.getAttribute("value"), engExpValue.getAttribute("value").equals(expType3));
        Assert.assertTrue("Описание = "+commentTemplate.getAttribute("value"), commentTemplate.getAttribute("value").equals(comment));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void modifyItemTemplate(String name, String group, String expType1, String expType2, String expType3) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActiveCheckBox));
        isActiveCheckBox.click();
        
        itemTemplateName.clear();
        itemTemplateName.sendKeys(name);
        
        itemTemplateGroup.clear();
        itemTemplateGroup.sendKeys(group);
        
        hozExpCheckBox.click();
        hozExpValue.clear();
        hozExpValue.sendKeys(expType3);
        
        techExpCheckBox.click();
        techExpValue.clear();
        techExpValue.sendKeys(expType1);
        
        engExpCheckBox.click();
        engExpValue.clear();
        engExpValue.sendKeys(expType2);
        
        Init.getWebDriver().switchTo().defaultContent();
        saveButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
    
    public void addTemplatesPODRUGAandSMIT(String templPODRUGA, String templSMIT) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(templatePODRUGA_1));
        
        templatePODRUGA_1.sendKeys(templPODRUGA);
        fillTemplatePODRUGA_1.click();
        
        templateSMIT.sendKeys(templSMIT);
        
        Init.getWebDriver().switchTo().defaultContent();        
        saveButton.click();
        
        backButton.click();
    }
    
    
    public void deleteItemTemplate() {
        
        deleteButton.click();
        
        Init.getWebDriver().switchTo().frame(1);
        confirmDeleting.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
}