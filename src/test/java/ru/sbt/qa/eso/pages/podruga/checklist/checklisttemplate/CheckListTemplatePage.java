package ru.sbt.qa.eso.pages.podruga.checklist.checklisttemplate;

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

public class CheckListTemplatePage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveCheckListTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteCheckListTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okCheckListTemplate;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить задания')]")
    private WebElement addTaskToCheckListTemplate;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    @FindBy(id = "X10")
    private WebElement name; 
    
    @FindBy(id = "X4Edit")
    private WebElement isActive; 
    
    @FindBy(xpath = "//a[contains(text(),'Удалить')]")
    private WebElement deleteLink; 
    
    public CheckListTemplatePage(){ 
                
        Init.getWebDriver().switchTo().defaultContent();
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okCheckListTemplate));
    }
    
    public void verifyCheckListTemplate(String verifyName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActive));        
        isActive.isSelected();
        
        Assert.assertTrue("Название шаблона чек-листа = "+name.getAttribute("value"), name.getAttribute("value").equals(verifyName));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void modifyCheckListTemplate(String newName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(isActive));
        isActive.click();
        
        name.clear();
        name.sendKeys(newName);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveCheckListTemplate));
        saveCheckListTemplate.click();
        
        okCheckListTemplate.click();
    }
    
    public void deleteCheckListTemplate() {
        
        deleteCheckListTemplate.click();
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(confirmDeleting));
        confirmDeleting.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
    
    public void addTasks(String groupSelect) {
        
        addTaskToCheckListTemplate.click();
        new AddTasksToCheckListTemplatePage().addTask(groupSelect);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveCheckListTemplate));
        saveCheckListTemplate.click();
        
        backButton.click();
    } 
    
    public void deleteTasks() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(deleteLink));
        deleteLink.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveCheckListTemplate));
        saveCheckListTemplate.click();
        
        backButton.click();
    }
}
