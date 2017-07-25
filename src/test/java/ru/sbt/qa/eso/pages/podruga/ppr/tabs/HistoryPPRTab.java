package ru.sbt.qa.eso.pages.podruga.ppr.tabs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author sbt-murashov-vv
 */

public class HistoryPPRTab {
    
    @FindBy(xpath = "//input[@id='X204']")
    private WebElement creator;
    
    @FindBy(xpath = "//button[@id='X221Btn']")
    private WebElement historyButton;
    
    
}
