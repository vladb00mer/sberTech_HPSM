package ru.sbt.qa.eso.pages.podruga.workgroups.create;

import java.util.List;
import java.util.Random;
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

public class WorkGroupPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement yesButton;
    
    @FindBy(xpath = "//input[@id = 'X6']")
    private WebElement statusInput;
    
    @FindBy(xpath = "//input[@id = 'X11']")
    private WebElement nameInput;
    
    @FindBy(xpath = "//input[@id = 'X13']")
    private WebElement coordinatorInput;
    
    @FindBy(xpath = "//div[@id = 'X13Edit']")
    private WebElement coordinatorInputFillButton;
    
    @FindBy(xpath = "//input[@id = 'X15']")
    private WebElement techCoordinatorInput;
    
    @FindBy(xpath = "//div[@id = 'X15Edit']")
    private WebElement techCoordinatorInputFillButton;
    
    @FindBy(xpath = "//input[@id = 'X21']")
    private WebElement parentWGinput;
    
    @FindBy(xpath = "//div[@id = 'X21Edit']")
    private WebElement parentWGinputFillButton;
    
    @FindBy(xpath = "//input[@id = 'X23']")
    private WebElement emailInput;
    
    @FindBy(xpath = "//input[@id = 'X25']")
    private WebElement phoneInput;
    
    @FindBy(xpath = "//input[@id = 'X27']")
    private WebElement nameOPinput;
    
    @FindBy(xpath = "//input[@id = 'X29']")
    private WebElement territoryCodeInput;
    
    @FindBy(xpath = "//div[@id = 'X29Edit']")
    private WebElement territoryCodeInputFillButton;
    
    @FindBy(xpath = "//input[@id = 'X31']")
    private WebElement organisationInput;
    
    @FindBy(xpath = "//div[@id = 'X31Edit']")
    private WebElement organisationInputFillButton;
    
    @FindBy(xpath = "//input[@id = 'X33']")
    private WebElement timeZoneInput;
    
    @FindBy(xpath = "//input[@id = 'X35']")
    private WebElement sheduleInput;
    
    
    public WorkGroupPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void verifyWG(String name, String coordinator) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(nameInput));
        Assert.assertTrue("Внимание! Значение поля Наименование не соответствует ожидаемому: " + nameInput.getAttribute("value"), 
                nameInput.getAttribute("value").equals(name));
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(coordinatorInput));
        Assert.assertTrue("Внимание! Значение поля Координатор не соответствует ожидаемому: " + coordinatorInput.getAttribute("value"), 
                coordinatorInput.getAttribute("value").contains(coordinator));
                       
    }
    
    public void modifyWG() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(techCoordinatorInput));
        techCoordinatorInput.sendKeys("Сивова Мария");
        techCoordinatorInputFillButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(emailInput));
        emailInput.sendKeys("email@mail.ru");
        
        phoneInput.sendKeys("123654789");
        nameOPinput.sendKeys("Рабочее место");
        
        territoryCodeInputFillButton.click();        
        List<WebElement> territoryCodes = Init.getWebDriver().findElements(By.xpath("//div[@role='row']//a"));
        territoryCodes.get(new Random().nextInt(territoryCodes.size()-1));
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(organisationInputFillButton));
        organisationInputFillButton.click();        
        List<WebElement> organisations = Init.getWebDriver().findElements(By.xpath("//div[@role='row']//a"));
        territoryCodes.get(new Random().nextInt(organisations.size()-1));
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(timeZoneInput));
        timeZoneInput.sendKeys("MSK");
        
        sheduleInput.sendKeys("10x5");
        sheduleInput.sendKeys(Keys.ENTER);
    }
    
    public void renameWG(String newName, String coordinator) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.clear();
        nameInput.sendKeys(newName);
                
        if (!coordinator.equals("")) 
            {
                coordinatorInput.clear();
                coordinatorInput.sendKeys(coordinator);
                coordinatorInputFillButton.click(); 
            }
                
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
    
    public void deleteWG() {
        
        Init.getWebDriver().switchTo().defaultContent();        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
    }
}
