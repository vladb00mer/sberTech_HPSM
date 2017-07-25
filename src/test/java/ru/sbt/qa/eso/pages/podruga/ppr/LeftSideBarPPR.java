package ru.sbt.qa.eso.pages.podruga.ppr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;

/**
 *
 * @author sbt-murashov-vv
 */

public class LeftSideBarPPR {
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(id = "ROOT/СБЕРБАНК/ППР")
    private WebElement ppr;
    
    @FindBy(id = "ROOT/СБЕРБАНК/ППР/Календарь")
    private WebElement calendar;
    
    @FindBy(id = "ROOT/СБЕРБАНК/ППР/Поиск ППР")
    private WebElement findPPR;
    
    @FindBy(id = "ROOT/СБЕРБАНК/ППР/Создать ППР")
    private WebElement createPPR;
    
    public LeftSideBarPPR(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToCalendar() {
        
        company.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(ppr));
        ppr.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(calendar));
        calendar.click();
    }
    
    public void goToSearchPPR() {
        
        company.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(ppr));
        ppr.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(findPPR));
        findPPR.click();
    }
    
    public void goToCreatePPR() {
        
        company.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(ppr));
        ppr.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createPPR));
        createPPR.click();
    }    
}
