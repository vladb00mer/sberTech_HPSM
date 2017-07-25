package ru.sbt.qa.eso.pages.podruga.order.orders;

import org.openqa.selenium.Keys;
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

public class FindOrderPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Назад')]")
    private WebElement backButton;
    
    @FindBy(xpath = "//input[@id = 'X3']")
    private WebElement searchDropDown;
    
    @FindBy(xpath = "//input[@id = 'X5']")
    private WebElement viewDropDown;
        
    @FindBy(id = "X11")
    private WebElement numberInput;
    
    
    public FindOrderPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
    }
    
    public void findOrder(String type, String id) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        if (!type.equals("")) {
            
            searchDropDown.clear();
            viewDropDown.click();
        
            new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(backButton));
        }
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(searchDropDown));
        searchDropDown.sendKeys(type);
        viewDropDown.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(numberInput));
        numberInput.sendKeys(id);
        numberInput.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}
