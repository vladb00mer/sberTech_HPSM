package ru.sbt.qa.eso.pages.podruga.officesandstaff.employee;

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

public class FindEmployePage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createEmployeButton; 
    
    @FindBy(id = "X6")
    private WebElement searchID;
    
    @FindBy(id = "X10")
    private WebElement searchFIO;
    
    
    public FindEmployePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createEmployeButton));
    }    
    
    public void findEmploye(String fio) {
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(searchID));
        searchFIO.sendKeys(fio);
        searchFIO.sendKeys(Keys.ENTER);
    }
}
