package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

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

public class ShedulePPRTab extends Page {
    
    @FindBy(xpath = "//a[@id='X37_t']")
    private WebElement tabHeader;
    
    @FindBy(xpath = "//div[@id='X42Edit']")
    private WebElement byIntervalRadioButton;
    
    @FindBy(xpath = "//input[@id='X47']")
    private WebElement byIntervalValue;
    
    @FindBy(xpath = "//div[@id='X51Edit']")
    private WebElement byDayRadioButton;
    
    @FindBy(xpath = "//input[@id='X54']")
    private WebElement byDayValue;
    
    @FindBy(xpath = "//div[@id='X56Edit']")
    private WebElement byWeekRadioButton;
    
    @FindBy(xpath = "//input[@id='X59']")
    private WebElement byWeekValue;
    
    @FindBy(xpath = "//input[@id='X117']")
    private WebElement dayTimeValue;
    
    @FindBy(xpath = "//div[@id='X67Edit']")
    private WebElement byMonthRadioButton;
    
    @FindBy(xpath = "//input[@id='X70']")
    private WebElement everyByMonthValue;
    
    @FindBy(xpath = "//input[@id='X76']")
    private WebElement ofMonthByMonthValue;
    
    @FindBy(xpath = "//div[@id='X85Edit']")
    private WebElement byYearRadioButton;
    
    @FindBy(xpath = "//input[@id='X88']")
    private WebElement everyNumberByYearValue;
    
    @FindBy(xpath = "//input[@id='X94']")
    private WebElement everyDayOfWeekByYearValue;
    
    @FindBy(xpath = "//input[@id='X103']")
    private WebElement fromMonthByYearValue;
    
    @FindBy(xpath = "//div[@id='X119Edit']")
    private WebElement byRandomRadioButton;
    
    @FindBy(xpath = "//input[@id='X123_1']")
    private WebElement byRandomValue1;
    
    @FindBy(xpath = "//input[@id='X123_2']")
    private WebElement byRandomValue2;
    
    @FindBy(xpath = "//div[@id='X126Edit']")
    private WebElement finishAfterRadioButton;
    
    @FindBy(xpath = "//input[@id='X128']")
    private WebElement finishAfterValue;
    
    @FindBy(xpath = "//div[@id='X130Edit']")
    private WebElement finishDateRadioButton;
    
    @FindBy(xpath = "//input[@id='X132']")
    private WebElement finishDateValue;
    
    public ShedulePPRTab(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(tabHeader));
        tabHeader.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byIntervalRadioButton));
    }
    
    public void fillByInterval() {
        
        byIntervalRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byIntervalValue));
        byIntervalValue.click();
        byIntervalValue.sendKeys("20:00:40");
        
        finishAfterRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(finishAfterValue));
        finishAfterValue.sendKeys("20");
    }
    
    public void fillByDay() {
        
        byDayRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byDayValue));
        byDayValue.click();
        byDayValue.sendKeys("20:00:00");
        
        finishDateRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(finishDateValue));
        finishDateValue.click();
        finishDateValue.sendKeys("01/04/18 05:20:00");
    }
    
    public void fillByWeek() {
        
        byWeekRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byWeekValue));
        byWeekValue.click();
        byWeekValue.sendKeys("воскресенье");
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(dayTimeValue));
        dayTimeValue.click();
        dayTimeValue.sendKeys("10:00:30");
        
        finishAfterRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(finishAfterValue));
        finishAfterValue.sendKeys("10");
    }
    
    public void fillByMonth() {
        
        byMonthRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(everyByMonthValue));
        everyByMonthValue.click();
        everyByMonthValue.sendKeys("Последний");
        
        ofMonthByMonthValue.click();
        ofMonthByMonthValue.sendKeys("вторник");
        
        dayTimeValue.click();
        dayTimeValue.sendKeys("03:00:00");
        
        finishDateRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(finishDateValue));
        finishDateValue.click();
        finishDateValue.sendKeys("01/05/18 00:30:00");
    }   
    
    public void fillByYear() {
        
        byYearRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(everyNumberByYearValue));
        everyNumberByYearValue.click();
        everyNumberByYearValue.sendKeys("Второй");
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(everyDayOfWeekByYearValue));
        everyDayOfWeekByYearValue.click();
        everyDayOfWeekByYearValue.sendKeys("четверг");
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(fromMonthByYearValue));
        fromMonthByYearValue.click();
        fromMonthByYearValue.sendKeys("Март");
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(dayTimeValue));
        dayTimeValue.click();
        dayTimeValue.sendKeys("01:00:00");
        
        finishAfterRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(finishAfterValue));
        finishAfterValue.sendKeys("15");
    }
    
    public void fillByRandom() {
        
        byRandomRadioButton.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byRandomValue1));
        byRandomValue1.click();
        byRandomValue1.sendKeys("04/05/18 00:00:00");
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(byRandomValue2));
        byRandomValue2.click();
        byRandomValue2.sendKeys("03/05/19 00:00:00");
    }       
}
