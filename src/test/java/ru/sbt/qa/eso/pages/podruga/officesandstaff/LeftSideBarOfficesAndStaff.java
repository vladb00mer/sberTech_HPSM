package ru.sbt.qa.eso.pages.podruga.officesandstaff;

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

public class LeftSideBarOfficesAndStaff extends Page{
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(xpath = "//span[contains(text(),'Справочники')]")
    private WebElement directories;

    @FindBy(xpath = "//span[contains(text(),'Подразделения и персонал')]")
    private WebElement officesandstaff;

    @FindBy(xpath = "//span[contains(text(),'Сотрудники')]")
    private WebElement employe;
    
    
    public LeftSideBarOfficesAndStaff(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToEmployees() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(officesandstaff));
        officesandstaff.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(employe));
        employe.click();
    }
}
