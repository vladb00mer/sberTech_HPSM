package ru.sbt.qa.eso.pages.podruga.workgroups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sbt.qa.bdd.Init;

/**
 *
 * @author sbt-murashov-vv
 */

public class LeftSideBarWorkGroup {
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(xpath = "//span[contains(text(),'Справочники')]")
    private WebElement directories;

    @FindBy(xpath = "//span[contains(text(),'Рабочие группы')]")
    private WebElement workgroups;
    
    public LeftSideBarWorkGroup(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToWorkGroups() {
        
        Init.getWebDriver().navigate().to("https://all-sh-sudiws1.ca.sbrf.ru/podruga/index.do");
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(workgroups));
        workgroups.click();
    }
}
