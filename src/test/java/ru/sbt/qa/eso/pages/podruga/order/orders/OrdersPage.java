package ru.sbt.qa.eso.pages.podruga.order.orders;

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

public class OrdersPage extends Page {
    
    @FindBy(xpath = "//button[contains(text(),'Создать')]")
    private WebElement createButton;
    
    public OrdersPage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        Init.getWebDriver().switchTo().defaultContent();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createButton));
    }
}
