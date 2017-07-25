package ru.sbt.qa.eso.pages.podruga.sla;

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

public class LeftSideBarSubscription extends Page {
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(xpath = "//span[contains(text(),'Управление Уровнем сервиса')]")
    private WebElement sla;

    @FindBy(xpath = "//span[contains(text(),'Подписки на Услуги')]")
    private WebElement subscriptions;
    
    public LeftSideBarSubscription(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToSubscriptions() {
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(sla));
        sla.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(subscriptions));
        subscriptions.click();
    }
}
