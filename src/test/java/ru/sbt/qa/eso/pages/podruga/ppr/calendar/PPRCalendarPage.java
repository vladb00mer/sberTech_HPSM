package ru.sbt.qa.eso.pages.podruga.ppr.calendar;

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

public class PPRCalendarPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Сменить фильтры')]")
    private WebElement changeFiltersButton;
    
    @FindBy(xpath = "//input[@id='X2']")
    private WebElement module;
    
    @FindBy(xpath = "//input[@id='X13']")
    private WebElement service;
    
    @FindBy(xpath = "//input[@id='X13Fill']")
    private WebElement fillService;
    
    @FindBy(xpath = "//input[@id='X21']")
    private WebElement territory;
    
    @FindBy(xpath = "//input[@id='X21Fill']")
    private WebElement fillTerritory;
    
    @FindBy(xpath = "//input[@id='X7']")
    private WebElement workGroup;
    
    @FindBy(xpath = "//input[@id='X7Fill']")
    private WebElement fillworkGroup;
    
    @FindBy(xpath = "//input[@id='X15']")
    private WebElement executorZnO;
    
    @FindBy(xpath = "//input[@id='X15Fill']")
    private WebElement fillExecutorZnO;
    
    @FindBy(xpath = "//div[@id='X22Edit']")
    private WebElement cardViewCheckBox;
    
    @FindBy(xpath = "//div[@id='X8Edit']")
    private WebElement myWorkGroupsCheckBox;
    
    @FindBy(xpath = "//div[@id='X16Edit']")
    private WebElement assignedToMeCheckBox;
    
    @FindBy(xpath = "//div[@id='X24Edit']")
    private WebElement createdByMeCheckBox;
    
    @FindBy(xpath = "//div[@id='X10Edit']")
    private WebElement allRadioButton;
    
    @FindBy(xpath = "//div[@id='X18Edit']")
    private WebElement existedRadioButton;
    
    @FindBy(xpath = "//div[@id='X26Edit']")
    private WebElement futureRadioButton;
    
    @FindBy(xpath = "//button[@id='X31Btn']")
    private WebElement clearFiltersButton;
    
    @FindBy(xpath = "//button[@id='X32Btn']")
    private WebElement useFiltersButton;
    
    
    public PPRCalendarPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void verifyCalendarPage() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(clearFiltersButton));      
        
        Assert.assertTrue("Не найдено поле Модуль! ", module.isEnabled());
        Assert.assertTrue("Не найдено поле Услуга! ", service.isEnabled());
        Assert.assertTrue("Не найдено поле Территория! ", territory.isEnabled());
        Assert.assertTrue("Не найдено поле Рабочая Группа! ", workGroup.isEnabled());
        Assert.assertTrue("Не найдено поле Исполнитель ЗнО! ", executorZnO.isEnabled());
        Assert.assertTrue("Не найден чекбокс Разрешить просмотр карточек! ", cardViewCheckBox.isEnabled());
        Assert.assertTrue("Не найден чекбокс Мои Рабочие Группы! ", myWorkGroupsCheckBox.isEnabled());
        Assert.assertTrue("Не найден чекбокс Назначенные на меня! ", assignedToMeCheckBox.isEnabled());
        Assert.assertTrue("Не найден чекбокс Созданные мной! ", createdByMeCheckBox.isEnabled());
        Assert.assertTrue("Не найден радиобатон Все! ", allRadioButton.isEnabled());
        Assert.assertTrue("Не найден радиобатон Только существующие! ", existedRadioButton.isEnabled());
        Assert.assertTrue("Не найден радиобатон Только будущие! ", futureRadioButton.isEnabled());
    }
    
    public void useFilterZNO() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(module));
        module.clear();
        module.sendKeys("ЗнО");
        
        useFiltersButton.click();
        
        Assert.assertTrue("Не отработал фильтр ЗнО! ", changeFiltersButton.isEnabled());
    }
    
    public void useFilterWorks() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(module));
        module.clear();
        module.sendKeys("Работы");
        
        useFiltersButton.click();
        
        Assert.assertTrue("Не отработал фильтр Работы! ", changeFiltersButton.isEnabled());
    }
}
