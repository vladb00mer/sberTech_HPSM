package ru.sbt.qa.eso.pages.podruga.workgroups.create;

import java.util.List;
import java.util.Random;
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

public class CreateWorkGroupPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement addButton;
    
    @FindBy(xpath = "//input[@id = 'X6']")
    private WebElement statusInput;
    
    @FindBy(xpath = "//input[@id = 'X11']")
    private WebElement nameInput;
    
    @FindBy(xpath = "//input[@id = 'X13']")
    private WebElement coordinatorInput;
    
    @FindBy(xpath = "//div[@id = 'X13Fill']")
    private WebElement fillCoordinatorButton;
    
    @FindBy(xpath = "//input[@id = 'X21']")
    private WebElement parentWG;
    
    @FindBy(xpath = "//td/div/a")
    private WebElement parentWGselectLink;
        
    @FindBy(xpath = "//div[@id = 'X21Fill']")
    private WebElement fillParentWG;
    
    @FindBy(xpath = "//input[@id = 'X31']")
    private WebElement companyInput;
    
    @FindBy(xpath = "//div[@id = 'X31Fill']")
    private WebElement companyInputFillButton;    
    
    public CreateWorkGroupPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void createWG(String name, String coordinator, String type) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(nameInput));
        
        nameInput.sendKeys(name);
        
        if (!coordinator.equals("")) 
            {
                coordinatorInput.sendKeys(coordinator);
                fillCoordinatorButton.click();
            }
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(companyInput));
        companyInput.sendKeys("Волго-Вятский банк");
        companyInputFillButton.click();
        
        if (type.equalsIgnoreCase("child"))
            {
                fillParentWG.click();
                selectRandomWG();
            }
        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(addButton));
        addButton.click();
    }
    
    public CreateWorkGroupPage findActiveWG(String name) {
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(statusInput));
        
        nameInput.clear();
        nameInput.sendKeys(name);
        
        statusInput.clear();
        statusInput.sendKeys("Активна");
        statusInput.sendKeys(Keys.ENTER);
        
        return this;
    }
    
    public void selectRandomWG() {
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(parentWGselectLink));
        List<WebElement> allWG = Init.getWebDriver().findElements(By.xpath("//td/div/a"));
        allWG.get(new Random().nextInt(allWG.size()-1)).click();
    }
}
