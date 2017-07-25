package ru.sbt.qa.eso.pages.podruga.checklist.segment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;
import java.util.List;
import junit.framework.Assert;
import ru.sbt.qa.bdd.pageFactory.Page;

/**
 *
 * @author sbt-murashov-vv
 */

public class SegmentFormPage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveSegment; 
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteSegment; 
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;    
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton; 
    
    @FindBy(xpath = "//input[@id='X4']")
    private WebElement segmentName;

    @FindBy(xpath = "//input[@id='X6']")
    private WebElement segmentBank;

    @FindBy(xpath = "//input[@id='X8']")
    private WebElement segmentGosb;
    
    @FindBy(xpath = "//input[@id='X10']")
    private WebElement segmentCluster;
    
    @FindBy(id = "X10Fill")
    private WebElement clusterTextAreaFill;

    @FindBy(xpath = "//input[@id='X12']")
    private WebElement segmentSM;
    
    @FindBy(id = "X12Fill")
    private WebElement smTextAreaFill;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить здания')]")
    private WebElement addBuildingToSegment; 
    
    @FindBy(xpath = "//td/a[contains(text(),'Удалить')]")
    private WebElement deleteLink;
    
    
    public SegmentFormPage() { 
        
        PageFactory.initElements(Init.getWebDriver(), this); 
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
    }  
    
    public void confirmOK() { okButton.click(); }
    
    public void modifySegment(String newCluster, String newSM) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        segmentCluster.clear();
        segmentCluster.sendKeys(newCluster);  
        clusterTextAreaFill.click();
        
        segmentSM.clear();
        segmentSM.sendKeys(newSM);  
        smTextAreaFill.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        saveSegment.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }
    
    public void verifySegment(String segment, String cluster, String sm) {
        
        Init.getWebDriver().switchTo().frame(1);     
        
        Assert.assertTrue("Название сегмента = "+segmentName.getAttribute("value"), segmentName.getAttribute("value").equals(segment));
        segmentBank.click();
        segmentGosb.click();  
        Assert.assertTrue("Название кластера = "+segmentCluster.getAttribute("value"), segmentCluster.getAttribute("value").equals(cluster));
        Assert.assertTrue("SM = "+segmentSM.getAttribute("value"), segmentSM.getAttribute("value").contains(sm));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void addBuildingToSegmentClick() {
        
        Init.getWebDriver().switchTo().frame(1);        
        addBuildingToSegment.click();        
    }
    
    public void removeBuildingFromSegment() {
        
        Init.getWebDriver().switchTo().frame(1);        
        List<WebElement> allBuildings = Init.getWebDriver().findElements(By.xpath("//td/a[contains(text(),'Удалить')]"));  
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(deleteLink));
        allBuildings.get(0).click();   
        
        Init.getWebDriver().switchTo().defaultContent();
        saveSegment.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));        
        okButton.click();
    }
    
    public void deleteSegment() {
        
        deleteSegment.click();
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(confirmDeleting));
        confirmDeleting.click();
        
        Init.getWebDriver().switchTo().defaultContent();        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
}