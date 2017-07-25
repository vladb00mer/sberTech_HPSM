package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.sbt.qa.bdd.Init;
import org.openqa.selenium.JavascriptExecutor;


public class AbstractFacePage {

    WebDriver driver;

    public AbstractFacePage(){
        PageFactory.initElements(Init.getWebDriver(), this);
    }

    public void goToFreindFaceActiverInteractions(){
        driver = Init.getWebDriver();
        driver.get("http://sbt-oapou-021.ca.sbrf.ru:9080/FriendFace/#activeInteractions");
    }

    public void goToFreindFaceClosedInteractions(){
        driver = Init.getWebDriver();
        driver.get("http://sbt-oapou-021.ca.sbrf.ru:9080/FriendFace/#closedInteractions");
    }

    public void goToFreindFace(){
        driver = Init.getWebDriver();
        driver.get("http://sbt-oapou-021.ca.sbrf.ru:9080/FriendFace/");
    }

    public void goToFreindFaceCatalog(){
        driver = Init.getWebDriver();
        driver.get("http://sbt-oapou-021.ca.sbrf.ru:9080/FriendFace/#viewCatalog");
    }

    public void waitForAjax() throws InterruptedException {
        while (true) // Handle timeout somewhere
        {
            Boolean ajaxIsComplete = (Boolean)((JavascriptExecutor)Init.getWebDriver()).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete)
                break;
            Thread.sleep(100);
        }
    }


}
