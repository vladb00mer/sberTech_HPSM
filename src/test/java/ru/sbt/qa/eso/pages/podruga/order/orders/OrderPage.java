package ru.sbt.qa.eso.pages.podruga.order.orders;

import org.junit.Assert;
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

public class OrderPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//span[@id='X1']/span")
    private WebElement numberValueField;
    
    @FindBy(xpath = "//input[@dvdvar='instance/ast.status']")
    private WebElement statusValueField;
    
    @FindBy(xpath = "//input[@id='X55']")
    private WebElement actionValueField;
    
    @FindBy(xpath = "//input[@id='X57']")
    private WebElement initiatorValueField;
        
    @FindBy(xpath = "//input[@id='X59']")
    private WebElement companyValueField;
    
    @FindBy(xpath = "//input[@id='X61']")
    private WebElement placementValueField;
    
    @FindBy(xpath = "//input[@id='X63']")
    private WebElement sheduleValueField;
    
    @FindBy(xpath = "//input[@id='X65']")
    private WebElement departmentValueField;
    
    @FindBy(xpath = "//input[@id='X67']")
    private WebElement phonesValueField;
    
    @FindBy(xpath = "//input[@id='X69']")
    private WebElement tabNumberValueField;
    
    @FindBy(xpath = "//input[@id='X71']")
    private WebElement workGroupValueField;
    
    @FindBy(xpath = "//input[@id='X73']")
    private WebElement executorValueField;
    
    @FindBy(xpath = "//input[@id='X75']")
    private WebElement headerValueField;
    
    
    public OrderPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        
        Init.getWebDriver().switchTo().defaultContent();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void verifyOrderNumber(String number) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(numberValueField));
        
        Assert.assertTrue("Внимание! Номер Заявки ".concat(numberValueField.getText()).concat(" не совпадает с ожидаемым ").concat(number), 
                numberValueField.getText().equals(number));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void verifyOrderParameters(String initiator, String workGroup, String header) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(numberValueField));
        
        Assert.assertTrue("Внимание! Статус ".concat(statusValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat("Новая"), 
                statusValueField.getAttribute("value").equals("Новая"));
        
        Assert.assertTrue("Внимание! Действие ".concat(actionValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat("Удаление"), 
                actionValueField.getAttribute("value").equals("Удаление"));
        
        Assert.assertTrue("Внимание! Инициатор ".concat(initiatorValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(initiator), 
                initiatorValueField.getAttribute("value").contains(initiator));
        
        Assert.assertTrue("Внимание! Компания ".concat(companyValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat("Волго-Вятский банк"), 
                companyValueField.getAttribute("value").equals("Волго-Вятский банк"));
        
        Assert.assertTrue("Внимание! Расположение ".concat(placementValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat("не указано"), 
                placementValueField.getAttribute("value").equals("не указано"));
        
        Assert.assertTrue("Внимание! Рабочий график ВСП ".concat(sheduleValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat("8x5"), 
                sheduleValueField.getAttribute("value").equals("8x5"));
        
        Assert.assertTrue("Внимание! Департамент ".concat(departmentValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(""), 
                departmentValueField.getAttribute("value").equals(""));
        
        Assert.assertTrue("Внимание! Телефоны ".concat(phonesValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(""), 
                phonesValueField.getAttribute("value").equals(""));
        
        Assert.assertTrue("Внимание! Табельный номер ".concat(tabNumberValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(""), 
                tabNumberValueField.getAttribute("value").equals(""));
        
        Assert.assertTrue("Внимание! Рабочая Группа ".concat(workGroupValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(workGroup), 
                workGroupValueField.getAttribute("value").contains(workGroup));
        
        Assert.assertTrue("Внимание! Исполнитель ".concat(executorValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(""), 
                executorValueField.getAttribute("value").equals(""));
        
        Assert.assertTrue("Внимание! Заголовок ".concat(headerValueField.getAttribute("value")).concat(" не совпадает с ожидаемым значением: ").concat(header), 
                headerValueField.getAttribute("value").contains(header));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
}
