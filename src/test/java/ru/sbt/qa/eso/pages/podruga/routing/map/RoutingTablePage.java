package ru.sbt.qa.eso.pages.podruga.routing.map;

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

public class RoutingTablePage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//div[@id='X5Edit']")
    private WebElement routingByTemplateCheckBox;
    
    @FindBy(xpath = "//div[@id='X12']")
    private WebElement nameInput;
    
    @FindBy(xpath = "//div[@id='X14']")
    private WebElement objectDropDown;
    
    @FindBy(xpath = "//div[@id='X24_1']")
    private WebElement codeTerritoryInput;
    
    @FindBy(xpath = "//div[@id='X27_1']")
    private WebElement serviceInput;
    
    @FindBy(xpath = "//div[@id='X27_1Fill']")
    private WebElement serviceInputFillButton;
    
    @FindBy(xpath = "//div[@id='X30_1']")
    private WebElement templateInput;
    
    @FindBy(xpath = "//div[@id='X30_1Fill']")
    private WebElement templateInputFillButton;
    
    @FindBy(xpath = "//div[@id='X33_1']")
    private WebElement buildingASUNInput;
    
    @FindBy(xpath = "//div[@id='X33_1Fill']")
    private WebElement buildingASUNInputFillButton;
    
    @FindBy(xpath = "//div[@id='X35']")
    private WebElement workGroupInput;
    
    @FindBy(xpath = "//div[@id='X35Fill']")
    private WebElement workGroupInputFillButton;
    
    
    public RoutingTablePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void createRouteMap() {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(objectDropDown));
        objectDropDown.sendKeys("Обращение");
                
        workGroupInput.sendKeys("ввб-атб0042/эксплуатирующая организация");
        workGroupInputFillButton.click();
                
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(nameInput));
        nameInput.sendKeys("falseCreation");
        nameInput.sendKeys(Keys.ENTER);
    }
    
    
}
