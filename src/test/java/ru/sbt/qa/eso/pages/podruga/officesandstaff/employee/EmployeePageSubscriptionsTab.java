package ru.sbt.qa.eso.pages.podruga.officesandstaff.employee;

import java.util.List;
import org.openqa.selenium.By;
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

public class EmployeePageSubscriptionsTab extends Page {
    
    
    @FindBy(id = "X143_1")
    private WebElement firstPersonalSubscriptionInList;
    
    @FindBy(id = "X156_1")
    private WebElement firstFOSSubscriptionInList;
    
    List<WebElement> allSubscriptions;
    
    @FindBy(id = "X139")
    private WebElement label;
    
    
    public EmployeePageSubscriptionsTab(){
                
        PageFactory.initElements(Init.getWebDriver(), this); 
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(label));
        
        allSubscriptions = Init.getWebDriver().findElements(By.xpath("//td/div/a/div/span[contains(text(), 'CI')]"));
    }
    
    public void goToServiceInstance() {
        
        allSubscriptions.get(0).click();
    }
}
