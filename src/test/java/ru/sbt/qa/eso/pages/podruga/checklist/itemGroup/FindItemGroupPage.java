package ru.sbt.qa.eso.pages.podruga.checklist.itemGroup;

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

public class FindItemGroupPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createItemGroup;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "X7")
    private WebElement name;
    
    public FindItemGroupPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createItemGroup));
    }
        
    public void createItemGroup(String setName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(setName);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createItemGroup));
        createItemGroup.click();
        
        backButton.click();
    }
    
    public void findItemGroup(String setName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(name));
        name.sendKeys(setName);
        name.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
    }   
}