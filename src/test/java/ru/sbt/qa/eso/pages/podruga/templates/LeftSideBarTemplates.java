package ru.sbt.qa.eso.pages.podruga.templates;

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

public class LeftSideBarTemplates extends Page{
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(xpath = "//span[contains(text(),'Справочники')]")
    private WebElement directories;
    
    @FindBy(id="ROOT/СБЕРБАНК/Справочники/Шаблоны")
    private WebElement templates;
    
    @FindBy(id="ROOT/СБЕРБАНК/Справочники/Шаблоны/Обращения")
    private WebElement requests;
    
    public LeftSideBarTemplates(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToRequestTemplateSearchPage() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(templates));
        templates.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(requests));
        requests.click();
    }
}
