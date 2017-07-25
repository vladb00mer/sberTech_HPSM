package ru.sbt.qa.eso.pages.podruga.ppr.search;

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

public class PPRSearchPage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//input[@id='X3']")
    private WebElement numberPPR;
    
    @FindBy(xpath = "//input[@id='X5']")
    private WebElement statusPPR;
    
    @FindBy(xpath = "//input[@id='X7']")
    private WebElement namePPR;
    
    @FindBy(xpath = "//input[@id='X15']")
    private WebElement serviceInFoundPPR;
    
    @FindBy(xpath = "//input[@id='X15']")
    private WebElement affectedServiceInFoundPPR1;
    
    @FindBy(xpath = "//input[@id='X23']")
    private WebElement priorityInFoundPPR;
    
    @FindBy(xpath = "//input[@id='X26']")
    private WebElement workGroupInFoundPPR;
    
    @FindBy(xpath = "//input[@id='X28']")
    private WebElement coordinatorZNOInFoundPPR;
    
    @FindBy(xpath = "//input[@id='X31']")
    private WebElement summaryInFoundPPR;
    
    
    public PPRSearchPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void verifyFields() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        Assert.assertTrue("Недоступно поле Номер ППР: ", numberPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Статус: ", statusPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Название плановой работы: ", namePPR.isEnabled());
        
        Assert.assertTrue("Недоступно поле Услуга: ", serviceInFoundPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Услуга: ", serviceInFoundPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Затронутые Услуги: ", affectedServiceInFoundPPR1.isEnabled());
        Assert.assertTrue("Недоступно поле Приоритет: ", priorityInFoundPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Рабочая Группа: ", workGroupInFoundPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Координатор ЗНО: ", coordinatorZNOInFoundPPR.isEnabled());
        Assert.assertTrue("Недоступно поле Краткое описание плановой работы: ", summaryInFoundPPR.isEnabled());
    }
}
