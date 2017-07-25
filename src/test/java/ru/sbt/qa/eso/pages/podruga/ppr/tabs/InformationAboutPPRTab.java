package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

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

public class InformationAboutPPRTab extends Page {
    
    @FindBy(xpath = "//a[@id='X9_t']")
    private WebElement tabHeader;
    
    @FindBy(xpath = "//input[@id='X15']")
    private WebElement servicePPR;
    
    @FindBy(xpath = "//div[@id='X15Fill']")
    private WebElement fillServicePPR;    
    
    @FindBy(xpath = "//input[@id='X23']")
    private WebElement priorityPPR;
    
    @FindBy(xpath = "//input[@id='X26']")
    private WebElement workgroupPPR;
    
    @FindBy(xpath = "//div[@id='X26Fill']")
    private WebElement fillWorkgroupPPR;
    
    @FindBy(xpath = "//input[@id='X28']")
    private WebElement znoCoordinatorPPR;
    
    @FindBy(xpath = "//input[@id='X31']")
    private WebElement summaryPPR;
    
    @FindBy(xpath = "//textarea[@id='X33']")
    private WebElement fullInformationPPR;
    
    @FindBy(xpath = "//input[@id='X18_1']")
    private WebElement firstServicePPR;
    
    @FindBy(xpath = "//input[@id='X35Btn']")
    private WebElement selectTerritoryButton;
    
    
    public InformationAboutPPRTab(){
        
        Init.getWebDriver().switchTo().defaultContent();
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(tabHeader));
        tabHeader.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(servicePPR));
    }
    
    public void fillRequiredData(String service, String group, String coordinator) {
        
        Assert.assertTrue("Недоступно поле Услуга!", servicePPR.isEnabled());
        servicePPR.sendKeys(service);
        fillServicePPR.click();
        
        Assert.assertTrue("Недоступно поле Затронутые услуги №1!", firstServicePPR.isEnabled());
        firstServicePPR.sendKeys(service);
        
        Assert.assertTrue("Недоступно поле Рабочая группа!", workgroupPPR.isEnabled());
        workgroupPPR.sendKeys(group);
        //fillWorkgroupPPR.click();
        
        Assert.assertTrue("Недоступно поле Координатор ЗнО!", znoCoordinatorPPR.isEnabled());
        znoCoordinatorPPR.sendKeys(coordinator);
        
        Assert.assertTrue("Недоступно поле Краткое описание плановой работы!", summaryPPR.isEnabled());
        summaryPPR.sendKeys("краткое описание");
        
        Assert.assertTrue("Недоступно поле Детальное описание!", fullInformationPPR.isEnabled());
        fullInformationPPR.sendKeys("детальное описание");
    }
    
    public void fillAllData(String service, String group, String coordinator) {
        
        Assert.assertTrue("Недоступно поле Приоритет!", priorityPPR.isEnabled());
        priorityPPR.clear();
        priorityPPR.sendKeys("1 - высокий");
        
        Assert.assertTrue("Недоступно поле Услуга!", servicePPR.isEnabled());
        servicePPR.sendKeys(service);
        fillServicePPR.click();
        
        priorityPPR.click();
        priorityPPR.clear();
        priorityPPR.sendKeys("2 - средний");
        
        Assert.assertTrue("Недоступно поле Затронутые услуги №1!", firstServicePPR.isEnabled());
        firstServicePPR.click();
        firstServicePPR.sendKeys(service);
        
        priorityPPR.click();
        priorityPPR.clear();
        priorityPPR.sendKeys("3 - низкий");

        Assert.assertTrue("Недоступно поле Рабочая группа!", workgroupPPR.isEnabled());
        workgroupPPR.sendKeys(group);
        //fillWorkgroupPPR.click();
        
        Assert.assertTrue("Недоступно поле Координатор ЗнО!", znoCoordinatorPPR.isEnabled());
        znoCoordinatorPPR.sendKeys(coordinator);
        
        Assert.assertTrue("Недоступно поле Краткое описание плановой работы!", summaryPPR.isEnabled());
        summaryPPR.sendKeys("краткое описание");
        
        Assert.assertTrue("Недоступно поле Детальное описание!", fullInformationPPR.isEnabled());
        fullInformationPPR.sendKeys("детальное описание");
    }
}
