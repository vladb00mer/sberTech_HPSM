package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sbt.qa.bdd.Init;

public class RequestFacePage {

    @FindBy(xpath = "(//label[text()='Сообщение']/following-sibling::textarea")
    private WebElement  complaintRichTextField;

    @FindBy(xpath = "(//input[@class='gwt-TextBox'])[2]")
    private WebElement  complaintTextField;

    @FindBy(xpath = "//button[@class='submit link_btn link_btn_fill_green']")
    private WebElement requestButton;

    @FindBy(xpath = "//a[@class='siteSectionLink' and contains(text(), 'SD')]")
    private WebElement requestId;

    public RequestFacePage(){
        PageFactory.initElements(Init.getWebDriver(), this);
    }

    public boolean isRequestOpen(){
        return (!Init.getWebDriver().findElements( By.xpath("//h1[@class='request__header' and text()='АвтоЖалоба']") ).isEmpty());
    }
}
