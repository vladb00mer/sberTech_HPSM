package ru.sbt.qa.eso.pages.podruga.checklist.segment;

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

public class CreateSegmentPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;
    
    @FindBy(xpath = "//input[@id='X4']")
    private WebElement segmentName;

    @FindBy(xpath = "//input[@id='X6']")
    private WebElement segmentCluster;
    
    @FindBy(xpath = "//div[@id='X6Fill']")
    private WebElement fillSegmentCluster;
    
    @FindBy(xpath = "//input[@id='X9']")
    private WebElement segmentSM;
    
    @FindBy(xpath = "//div[@id='X9Fill']")
    private WebElement fillSegmentSM;
    
    @FindBy(id = "X11Btn")
    private WebElement createButton;
    
    @FindBy(id = "commonMsg")
    private WebElement resultMessage;
    
    
    public CreateSegmentPage() {
        
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(segmentName));
    }
    
    public void createSegment(String segment, String cluster, String sm) {
        
        segmentName.sendKeys(segment);   
        
        segmentCluster.sendKeys(cluster);
        fillSegmentCluster.click();  
        
        segmentSM.sendKeys(sm);
        fillSegmentSM.click();   
        
        createButton.click();
        
        Init.getWebDriver().switchTo().defaultContent();
         
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }
}
