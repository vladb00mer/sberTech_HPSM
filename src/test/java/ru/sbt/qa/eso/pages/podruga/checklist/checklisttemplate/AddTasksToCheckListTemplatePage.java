package ru.sbt.qa.eso.pages.podruga.checklist.checklisttemplate;

import java.util.List;
import java.util.Random;
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

public class AddTasksToCheckListTemplatePage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Поиск')]")
    private WebElement groupSearch;
    
    @FindBy(xpath = "//button[contains(text(),'Применить')]")
    private WebElement acceptGroupSearch;
    
    @FindBy(xpath = "//input[@id='X2']")
    private WebElement selectGroup;
    
    @FindBy(xpath = "//td/a[contains(text(),'Выбрать')]")
    private WebElement selectLink;
    
    public AddTasksToCheckListTemplatePage(){ 
        
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(selectGroup));
    }
    
    public void addTask(String group) {
        
        selectGroup.click();
        selectGroup.sendKeys(group);
        groupSearch.click();
        
        List<WebElement> allBuildings = Init.getWebDriver().findElements(By.xpath("//td/a[contains(text(),'Выбрать')]"));        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(selectLink));        
        allBuildings.get(new Random().nextInt(allBuildings.size()-1)).click();
        
        acceptGroupSearch.click();
    }    
}