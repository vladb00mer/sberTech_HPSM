package ru.sbt.qa.eso.pages.podruga.checklist.segment;

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

public class FindSegmentPage extends Page{
    
    @FindBy(xpath = "//button[contains(text(),'Создать сегмент')]")
    private WebElement createSegment;
    
    @FindBy(id = "X3")
    private WebElement segmentName;
        
    public FindSegmentPage(){ 
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createSegment));
    }
    
    public void beginSegmentCreation() { 
    
        createSegment.click(); 
    }
    
    public void findSegment(String setName) {
        
        Init.getWebDriver().switchTo().frame(1);
        segmentName.sendKeys(setName);
        segmentName.sendKeys(Keys.ENTER);
        
        Init.getWebDriver().switchTo().defaultContent();
    }
}