package ru.sbt.qa.eso.pages.podruga.checklist.segment;

import java.util.List;
import java.util.Random;
import junit.framework.Assert;
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

public class AddBuildingsToSegmentPage extends Page{
    
    @FindBy(xpath = "//input[@id='X4']")
    private WebElement region;
    
    @FindBy(xpath = "//input[@id='X7']")
    private WebElement gosb;
    
    @FindBy(id = "X16Btn")
    private WebElement searchButton;
    
    @FindBy(id = "X17Btn")
    private WebElement confirmButton;
    
    @FindBy(xpath = "//td/a[contains(text(),'Выбрать')]")
    private WebElement selectLink;
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(id = "commonMsg")
    private WebElement resultMessage;
    
    
    public AddBuildingsToSegmentPage() {
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(region));
    }
    
    public void addBuilding(String addRegion) {
        
        region.sendKeys(addRegion);        
        gosb.click();
        searchButton.click();
        
        List<WebElement> allBuildings = Init.getWebDriver().findElements(By.xpath("//td/a[contains(text(),'Выбрать')]"));
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(selectLink));        
        allBuildings.get(new Random().nextInt(allBuildings.size()-2)).click();
        
        confirmButton.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));        
        saveButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));        
        /*
        Assert.assertTrue(resultMessage.getText().equals("Запись типа \"segment\" обновлена."));
        */
        backButton.click();
    }               
}