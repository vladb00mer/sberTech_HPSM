package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbt.qa.bdd.Init;


public class MainPage extends AbstractFacePage {

    @FindBy(xpath = "//input[@class='idle']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//label[text()='Версия']/following-sibling::div")
    private WebElement versionLabel;

    @FindBy(xpath = "(//div[@class='nav-extra__fav nav-extra__list show']//div[@class='title'])[1]")
    private WebElement firstElementInSearch;

    @FindBy(xpath = "//label[text()='Сообщение']/following-sibling::textarea")
    private WebElement  complaintRichTextField;

    @FindBy(xpath = "(//input[@class='gwt-TextBox'])[2]")
    private WebElement  complaintTextField;

    @FindBy(xpath = "//button[@class='submit link_btn link_btn_fill_green']")
    private WebElement requestButton;

    @FindBy(xpath = "//a[@class='siteSectionLink' and contains(text(), 'SD')]")
    private WebElement requestId;

    @FindBy(xpath = "//div[@class='link-user']")
    private WebElement linkUser;

    public MainPage(){
        PageFactory.initElements(Init.getWebDriver(), this);
    }

    public boolean isLogin(){
        return (!Init.getWebDriver().findElements( By.xpath("(//div[@class='link-user'])[1]") ).isEmpty());
    }

    public void setSearchInput(String input){
        searchInput.sendKeys(input);
    }

    public void  searchButtonClick(){
        searchButton.click();
    }

    public void firstElementInSearchClick() throws InterruptedException {
        firstElementInSearch.click();
    }

    public void setComplaintRichTextField(){
        complaintRichTextField.sendKeys("Some Value");
    }

    public void setComplaintTextField(){
        complaintTextField.sendKeys("SD123456789");
    }

    public void requestButtonClick() throws InterruptedException {
        requestButton.click();
        //this.WaitForAjax();
    }

    public Boolean isRequestIdExist(){
        return (requestId.getText()!= "");
    }

    public String getRequestId(){
        return requestId.getText();
    }

    public void clickLinkUser(){
        linkUser.click();
    }

    public boolean getVersionLabel(){
        return (versionLabel.getText()!="");
    }

    public void setMarkToRequest(String requestId) throws InterruptedException {
        Init.getWebDriver().findElement( By.xpath("//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']/div[1]/a[2]")).click();
        Init.getWebDriver().findElement( By.xpath("//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']//a[@class='smile excellent']")).click();
        Init.getWebDriver().findElement( By.xpath("(//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']//div[contains(text(),'Отправить')])[1]")).click();
        waitForAjax();
    }

    public void rejectRequest(String requestId, String someString) throws InterruptedException {
        Init.getWebDriver().findElement( By.xpath("//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']/div[1]/a[1]")).click();
        Init.getWebDriver().findElement( By.xpath("(//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']//textarea[@class='gwt-TextArea'])[2]")).sendKeys(someString);
        Init.getWebDriver().findElement( By.xpath("(//div[@class='num' and contains(text(),'"+ requestId +"')]/parent::div/parent::div/following-sibling::div[@class='item__actions']//div[contains(text(),'Отправить')])[2]")).click();
        waitForAjax();
    }
}
