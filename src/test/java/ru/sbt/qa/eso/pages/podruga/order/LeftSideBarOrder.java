package ru.sbt.qa.eso.pages.podruga.order;

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

public class LeftSideBarOrder extends Page{
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;
    
    @FindBy(id = "ROOT/СБЕРБАНК/Управление Обращениями")
    private WebElement orderManagement;
    
    @FindBy(id = "ROOT/СБЕРБАНК/Управление Обращениями/Обращения")
    private WebElement orders;
    
    @FindBy(id = "ROOT/СБЕРБАНК/Управление Обращениями/Поиск записей обращений")
    private WebElement orderSearch;
    
    public LeftSideBarOrder(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToOrders() {
        
        company.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(orderManagement));
        orderManagement.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(orders));
        orders.click();
    }
    
    public void goToOrderSearch() {
        
        company.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(orderManagement));
        orderManagement.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(orderSearch));
        orderSearch.click();
    }
}
