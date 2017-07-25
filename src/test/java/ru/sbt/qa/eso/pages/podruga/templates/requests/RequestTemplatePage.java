package ru.sbt.qa.eso.pages.podruga.templates.requests;

import junit.framework.Assert;
import org.openqa.selenium.Keys;
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

public class RequestTemplatePage {
    
    @FindBy(id = "X3")
    private WebElement isActiveCheckBox;
    
    @FindBy(id = "X5")
    private WebElement enabledOnPortalCheckBox;
    
}
