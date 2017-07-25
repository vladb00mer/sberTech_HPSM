package ru.sbt.qa.eso.pages.podruga.checklist.cluster;

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

public class ClusterFormPage extends Page {

    @FindBy(xpath = "//button[contains(text(),'Сохранить')]")
    private WebElement saveCluster; 
    
    @FindBy(xpath = "//button[contains(text(),'Удалить')]")
    private WebElement deleteCluster; 
    
    @FindBy(xpath = "//button[contains(text(),'ОК')]")
    private WebElement okButton;
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//input[@id='X4Readonly']")
    private WebElement clusterName;

    @FindBy(xpath = "//input[@id='X6Readonly']")
    private WebElement clusterBank;

    @FindBy(xpath = "//input[@id='X8Readonly']")
    private WebElement clusterGosb;

    @FindBy(xpath = "//input[@id='X12']")
    private WebElement clusterSM;
    
    @FindBy(id = "X12Fill")
    private WebElement smTextAreaFill;
    
    @FindBy(xpath = "//input[@id='y']")
    private WebElement confirmDeleting;
    
    public ClusterFormPage() {
        
        PageFactory.initElements(Init.getWebDriver(), this); 
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
    }
    
    public void confirmOK() { okButton.click(); }
    
    public void changeSM(String newSM) {
        
        Init.getWebDriver().switchTo().frame(1);
        clusterSM.clear();
        clusterSM.sendKeys(newSM);  
        smTextAreaFill.click();
        
        Init.getWebDriver().switchTo().defaultContent();
        saveCluster.click();
        
        Init.getWebDriver().switchTo().frame(1);
        Assert.assertTrue("SM кластера = "+clusterSM.getAttribute("value"), clusterSM.getAttribute("value").contains(newSM));
        
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }
    
    public void verifyCluster(String name, String bank, String gosb, String sm) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        Assert.assertTrue("Название кластера = "+clusterName.getAttribute("value"), clusterName.getAttribute("value").equals(name));
        Assert.assertTrue("Банк кластера = "+clusterBank.getAttribute("value"), clusterBank.getAttribute("value").equals(bank));
        Assert.assertTrue("ГОСБ кластера = "+clusterGosb.getAttribute("value"), clusterGosb.getAttribute("value").equals(gosb));
        Assert.assertTrue("SM кластера = "+clusterSM.getAttribute("value"), clusterSM.getAttribute("value").contains(sm));
        
        Init.getWebDriver().switchTo().defaultContent();
    }
    
    public void deleteCluster() {
        
        deleteCluster.click();
        
        Init.getWebDriver().switchTo().frame(1);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(confirmDeleting));
        confirmDeleting.click();
        
        Init.getWebDriver().switchTo().defaultContent();        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }
}
