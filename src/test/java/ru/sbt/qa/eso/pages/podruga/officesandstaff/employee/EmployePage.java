package ru.sbt.qa.eso.pages.podruga.officesandstaff.employee;

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

public class EmployePage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveButton;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить Рабочие группы')]")
    private WebElement addWorkGroups;
    
    @FindBy(xpath = "//button[contains(text(),'Рабочие группы')]")
    private WebElement workGroups;
    
    @FindBy(id = "X6")
    private WebElement userID;
    
    @FindBy(id = "X10")
    private WebElement userFIO;
    
    @FindBy(id = "X137_t")
    private WebElement subscriptions;
    
    
    public EmployePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(subscriptions));
    }
    
    public void goToSubscriptions() {
        
        userID.click();
        userFIO.click();
        subscriptions.click();
    }
}
