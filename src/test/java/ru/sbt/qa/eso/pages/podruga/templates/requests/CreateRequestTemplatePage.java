package ru.sbt.qa.eso.pages.podruga.templates.requests;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class CreateRequestTemplatePage {
    
    @FindBy(xpath = "//button[contains(text(),'Добавить')]")
    private WebElement createRequestTemplate;
    
    @FindBy(id = "X16")
    private WebElement nameTextBox;
    
    @FindBy(id = "X22")
    private WebElement includedInGroupTextBox;
    
    @FindBy(id = "X22Fill")
    private WebElement includedInGroupFillButton;
    
    @FindBy(id = "X31")
    private WebElement fullNameTextBox;
    
    @FindBy(id = "X33")
    private WebElement displayedNameTextBox;
    
    @FindBy(id = "X18")
    private WebElement typeDropDown;
    
    @FindBy(id = "X24")
    private WebElement sortingOrder;
    
    @FindBy(id = "X29")
    private WebElement categoryDropDown;
    
    @FindBy(id = "X85")
    private WebElement serviceNameTextBox;
        
    @FindBy(id = "X85FillButton")
    private WebElement serviceNameFillButton;
    
    @FindBy(id = "X90Readonly")
    private WebElement serviceCodeTextBox;
    
    @FindBy(xpath = "//a[contains(text(),'Шаблон Обращения')][1]")
    private WebElement requestTemplateTab;
    
    @FindBy(xpath = "//a[contains(text(),'Перевозки сотрудников')][1]")
    private WebElement employeTransferLink;
    
    @FindBy(id = "X71")
    private WebElement shortDescriptionTextBox;
    
    @FindBy(id = "X70")
    private WebElement affectionDropDown;
    
    @FindBy(id = "X73")
    private WebElement priorityDropDown;
    
    public CreateRequestTemplatePage(){
        
        PageFactory.initElements(Init.getWebDriver(), this);        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(createRequestTemplate));
    }
    
    public void beforeErrorCreationRequestTemplate(String name, String includedInGroup, String fullName, String displayedName) {
        
        Init.getWebDriver().switchTo().frame(1);
        
        nameTextBox.sendKeys(name);
        
        includedInGroupTextBox.sendKeys(includedInGroup);
        includedInGroupFillButton.click();
        
        fullNameTextBox.sendKeys(fullName);
        
        displayedNameTextBox.sendKeys(displayedName);
        
        typeDropDown.sendKeys("item");
        
        sortingOrder.sendKeys(Integer.toString(new Random().nextInt(10)));
        
        categoryDropDown.sendKeys("запрос на обслуживание");
        
        Init.getWebDriver().switchTo().defaultContent();
        
        createRequestTemplate.click();
        
    }
    
    public void afterErrorCreationRequestTemplate() {
        
        Init.getWebDriver().switchTo().frame(1);
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(requestTemplateTab));
        requestTemplateTab.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(serviceNameTextBox));
        serviceNameTextBox.sendKeys("Перевозки сотрудников");
        serviceNameFillButton.click();

        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(employeTransferLink));
        employeTransferLink.click();
        
        new WebDriverWait(Init.getWebDriver(), Init.getTimeOutInSeconds()).until(ExpectedConditions.elementToBeClickable(serviceCodeTextBox));
        Assert.assertTrue("Внимание! Ожидаемый ID Услуги = CI23049 не соответствует актуальному = ".concat(serviceCodeTextBox.getAttribute("value")), 
                (serviceCodeTextBox.getAttribute("value")).equals("CI23049"));
        
        shortDescriptionTextBox.sendKeys("произвольное значение");
        
        affectionDropDown.sendKeys("Влияет на 1 Сотрудника");
        
        priorityDropDown.sendKeys("Не влияет");
        
        Init.getWebDriver().switchTo().defaultContent();
        
        createRequestTemplate.click();        
    }
}
