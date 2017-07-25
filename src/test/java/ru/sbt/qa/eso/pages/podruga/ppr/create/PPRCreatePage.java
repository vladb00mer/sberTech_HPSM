package ru.sbt.qa.eso.pages.podruga.ppr.create;

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

public class PPRCreatePage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement addButton;
    
    @FindBy(xpath = "//button[contains(text(),'Копировать ППР')]")
    private WebElement copyPPRButton;
    
    @FindBy(xpath = "//input[@id='X3']")
    private WebElement numberPPR;
    
    @FindBy(xpath = "//input[@id='X5']")
    private WebElement statusPPR;
    
    @FindBy(xpath = "//input[@id='X7']")
    private WebElement namePPR;
    
    @FindBy(xpath = "//a[@id='X9_t']")
    private WebElement informationAboutPPRTabLink;
    
    @FindBy(xpath = "//a[@id='X37_t']")
    private WebElement shedulePPRTabLink;
    
    @FindBy(xpath = "//a[@id='X135_t']")
    private WebElement notificationVKPPRTabLink;
    
    @FindBy(xpath = "//a[@id='X155_t']")
    private WebElement approvalPPRTabLink;
    
    @FindBy(xpath = "//a[@id='X180_t']")
    private WebElement tasksPPRTabLink;
    
    @FindBy(xpath = "//a[@id='X200_t']")
    private WebElement historyPPRTabLink;
    
    
    public PPRCreatePage(){ 
        
        Init.getWebDriver().switchTo().defaultContent();
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(addButton));
    }
    
    public void verifyTabs() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(informationAboutPPRTabLink));
        Assert.assertTrue("Недоступен таб Сведения о ППР!", informationAboutPPRTabLink.isEnabled());
        Assert.assertTrue("Недоступен таб График проведения ППР!", shedulePPRTabLink.isEnabled());
        Assert.assertTrue("Недоступен таб Оповещение ВК!", notificationVKPPRTabLink.isEnabled());
        Assert.assertTrue("Недоступен таб Согласование ППР!", approvalPPRTabLink.isEnabled());
        Assert.assertTrue("Недоступен таб Задания по ППР!", tasksPPRTabLink.isEnabled());
        Assert.assertTrue("Недоступен таб История!", historyPPRTabLink.isEnabled());
    }
    
    public void createPPR(String name) {
        
        Init.getWebDriver().switchTo().frame(1);
        namePPR.sendKeys(name);
        
        Init.getWebDriver().switchTo().defaultContent();
        addButton.click();
                
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));        
        backButton.click();
    }    
}
