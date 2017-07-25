package ru.sbt.qa.eso.pages.podruga.workgroups.tabs;

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

public class EmployeTab extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//div[@id='X2Tabs']//a[@id='X38_t']")
    private WebElement employeTabLink;    
    
    @FindBy(xpath = "//input[@id='X42_1']")
    private WebElement employe1Input;
    
    @FindBy(xpath = "//div[@id='X42_1Fill']")
    private WebElement employe1InputFillButton;
    
    @FindBy(xpath = "//input[@id='X42_2']")
    private WebElement employe2Input;
    
    @FindBy(xpath = "//div[@id='X42_2Fill']")
    private WebElement employe2InputFillButton;
    
    
    public EmployeTab(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(employeTabLink));
        employeTabLink.click();
    }
    
    public void fillEmployeTab(int count) {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(employe1Input));
        employe1Input.clear();
        employe1Input.sendKeys("Сивова Мария");
        employe1InputFillButton.click();
        
        
        if (count>1) 
            {
                new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(employe2Input));
                employe2Input.clear();
                employe2Input.sendKeys("Мурашов Влад");
                employe2InputFillButton.click();
            }
                
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
}
