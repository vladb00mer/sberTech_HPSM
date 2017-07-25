package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

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

public class ApprovalPPRTab extends Page {
    
    @FindBy(xpath = "//a[@id='X155_t']")
    private WebElement tabHeader;
    
    @FindBy(xpath = "//input[@id='X161']")
    private WebElement mainService;    
    
    @FindBy(xpath = "//input[@id='X169_1']")
    private WebElement addApprover1; 
    
    @FindBy(xpath = "//div[@id='X169_1Fill']")
    private WebElement addApprover1Fill; 
    
    @FindBy(xpath = "//input[@id='X179_1']")
    private WebElement fio1;
    
    @FindBy(xpath = "//div[@id='X179_1Fill']")
    private WebElement fio1Fill; 
    
    @FindBy(xpath = "//button[@id='X163Btn']")
    private WebElement approversMPU; 
    
    
    public ApprovalPPRTab(){
        
        Init.getWebDriver().switchTo().defaultContent();
        Init.getWebDriver().switchTo().frame(1);
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(tabHeader));
        tabHeader.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(addApprover1));
    }
    
    public void autoFillApprover() {
        
        approversMPU.click();
    }
    
    public void fillAllData(String approver) {
        
        addApprover1.click();
        addApprover1.sendKeys(approver);
        addApprover1Fill.click();
        
        fio1.click();
        fio1.sendKeys(approver);
        fio1Fill.click();
        
        Assert.assertTrue("Некорректное значение поля Добавить Согласующего: "+addApprover1.getAttribute("value"), addApprover1.getAttribute("value").contains(approver));        
        Assert.assertTrue("Некорректное значение поля ФИО: "+fio1.getAttribute("value"), fio1.getAttribute("value").contains(approver));
    }
}
