package ru.sbt.qa.eso.pages.podruga.checklist;

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

public class LeftSideBarCheckList extends Page{
    
    @FindBy(xpath = "//span[contains(text(),'СБЕРБАНК')]")
    private WebElement company;

    @FindBy(xpath = "//span[contains(text(),'Справочники')]")
    private WebElement directories;

    @FindBy(xpath = "//span[contains(text(),'Чек-лист')]")
    private WebElement checkList;

    @FindBy(xpath = "//span[contains(text(),'Группы пунктов')]")
    private WebElement itemGroups;

    @FindBy(xpath = "//span[contains(text(),'Кластер')]")
    private WebElement cluster;

    @FindBy(xpath = "//span[contains(text(),'Сегмент')]")
    private WebElement segment;

    @FindBy(xpath = "//span[contains(text(),'Шаблоны пунктов')]")
    private WebElement itemTemplates;
    
    @FindBy(xpath = "//span[contains(text(),'Шаблоны чек-листов')]")
    private WebElement checkListTemplates;    
    
    public LeftSideBarCheckList(){
        
        PageFactory.initElements(Init.getWebDriver(), this);
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(company));
    }
    
    public void goToItemGroups() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkList));
        checkList.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(itemGroups));
        itemGroups.click();
    }

    public void goToCluster() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkList));
        checkList.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(cluster));
        cluster.click();
    }
    
    public void goToSegment() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkList));
        checkList.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(segment));
        segment.click();
    }
    
    public void goToItemTemplates() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkList));
        checkList.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(itemTemplates));
        itemTemplates.click();
    }
    
    public void goToCheckListTemplates() {
        
        company.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(directories));
        directories.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkList));
        checkList.click();
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(checkListTemplates));
        checkListTemplates.click();
    }
}
