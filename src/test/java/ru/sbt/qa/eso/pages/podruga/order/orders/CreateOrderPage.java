package ru.sbt.qa.eso.pages.podruga.order.orders;

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

public class CreateOrderPage extends Page {
        
    @FindBy(xpath = "//button[contains(text(),'Создать обращение')]")
    private WebElement createRequest;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//div[@id='cwcCenterPanel']//iframe")
    private WebElement externalFrame;
    
    @FindBy(xpath = "//div[@id='X5Border']/iframe[@id='X5']")
    private WebElement internalFrame;    
        
    @FindBy(xpath = "//a[contains(text(),'Управление услугами ЕСО')]")
    private WebElement manageEsoServices;
    
    @FindBy(xpath = "//a[contains(text(),'Создание/изменение/удаление услуг ЕСО')]")
    private WebElement crudEsoServices;
    
    @FindBy(xpath = "//a[contains(text(),'Создание новой услуги')]")
    private WebElement createEsoService;
    
    @FindBy(xpath = "//div[@id='X56Edit']//input[@id = 'X56']")
    private WebElement ordererInput;
    
    @FindBy(xpath = "//div[@id = 'X56Fill']")
    private WebElement ordererInputFillButton;
    
    @FindBy(xpath = "//input[@name = 'instance/svc.options.disp/naim']")
    private WebElement newServiceNameInput;
    
    @FindBy(xpath = "//input[@name = 'instance/svc.options.disp/hoz']")
    private WebElement newServiceOwnerInput;
    
    @FindBy(xpath = "//textarea[@name = 'instance/svc.options.disp/opis']")
    private WebElement newServiceTextInput;
    
    @FindBy(xpath = "//input[@name = 'instance/svc.options.disp/podr']")
    private WebElement newServiceFOSInput;
    
    @FindBy(xpath = "//input[@name = 'instance/svc.options.disp/klient']")
    private WebElement newServiceVKInput;
    
    @FindBy(xpath = "//input[@name = 'instance/svc.options.disp/shablon1']")
    private WebElement newServiceVKTemplateInput;
        
    
    public CreateOrderPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createRequest));
    }
       
    public void createOrder(String name) {
        
        createRequest.click();
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(externalFrame).switchTo().frame(internalFrame);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(manageEsoServices));
        manageEsoServices.click();
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(externalFrame).switchTo().frame(internalFrame);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(crudEsoServices));
        crudEsoServices.click();
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(externalFrame).switchTo().frame(internalFrame);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createEsoService));
        createEsoService.click();
        
        
        Init.getWebDriver().switchTo().defaultContent().switchTo().frame(externalFrame);        
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(ordererInput));
        ordererInput.sendKeys(name);
        ordererInputFillButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(newServiceNameInput));
        newServiceNameInput.sendKeys("Новая услуга автотест");
        newServiceOwnerInput.sendKeys(name);
        newServiceTextInput.sendKeys("Описание услуги автотест");        
        newServiceFOSInput.sendKeys("Подразделение, оказывающее услугу автотест");
        newServiceVKInput.sendKeys("Риски");
        newServiceVKTemplateInput.sendKeys("Наименование шаблона обращения для ВК авто");
        newServiceVKTemplateInput.sendKeys(Keys.ENTER);        
    }
}
