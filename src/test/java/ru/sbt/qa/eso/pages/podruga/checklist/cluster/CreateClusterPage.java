package ru.sbt.qa.eso.pages.podruga.checklist.cluster;

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

public class CreateClusterPage extends Page {
    
    @FindBy(xpath = "//input[@id='X4']")
    private WebElement clusterName;

    @FindBy(xpath = "//input[@id='X6']")
    private WebElement clusterBank;

    @FindBy(xpath = "//input[@id='X8']")
    private WebElement clusterGosb;

    @FindBy(xpath = "//input[@id='X10']")
    private WebElement clusterSM;
    
    @FindBy(xpath = "//div[@id='X10Fill']")
    private WebElement fillClusterSM;
    
    @FindBy(id = "X12Btn")
    private WebElement createButton;
    
    
    public CreateClusterPage() {
        
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(clusterName));
    }
    
    public void createCluster(String name, String bank, String gosb, String sm) {
                        
        clusterName.sendKeys(name);
        clusterBank.sendKeys(bank);
        clusterGosb.sendKeys(gosb);
        
        clusterSM.sendKeys(sm);
        fillClusterSM.click();
        
        createButton.click();  
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}
