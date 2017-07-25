package ru.sbt.qa.eso.pages.podruga.routing;

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

public class LeftSideBarRouting extends Page{
    
    @FindBy(xpath = "//div[@id='ROOT/СБЕРБАНК']")
    private WebElement company;

    @FindBy(xpath = "//div[@id='ROOT/СБЕРБАНК/Справочники']")
    private WebElement directories;

    @FindBy(xpath = "//div[@id='ROOT/СБЕРБАНК/Справочники/Маршрутизация']")
    private WebElement routing;
    
    @FindBy(xpath = "//div[@id='ROOT/СБЕРБАНК/Справочники/Маршрутизация/Маршрутные карты(NEW)']")
    private WebElement routingMapsNEW;
    
    
    public LeftSideBarRouting(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToRoutingMaps() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(routing));
        routing.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(routingMapsNEW));
        routingMapsNEW.click();
    }
}
