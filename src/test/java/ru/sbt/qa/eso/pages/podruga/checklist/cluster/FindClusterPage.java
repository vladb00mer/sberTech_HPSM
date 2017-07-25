package ru.sbt.qa.eso.pages.podruga.checklist.cluster;

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

public class FindClusterPage extends Page {

    @FindBy(xpath = "//button[contains(text(),'Создать кластер')]")
    private WebElement createCluster;
    
    @FindBy(id = "X3")
    private WebElement name;
        
    public FindClusterPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createCluster));
    }
    
    public void beginClusterCreation() { createCluster.click(); }
    
    public void findCluster(String setName) {
        
        Init.getWebDriver().switchTo().frame(1);
        name.sendKeys(setName);
        name.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}
