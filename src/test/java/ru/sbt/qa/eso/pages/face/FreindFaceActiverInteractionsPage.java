package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.By;
import ru.sbt.qa.bdd.Init;

/**
 * Created by sbt-horunzhev-as on 01.04.2017.
 */

public class FreindFaceActiverInteractionsPage extends AbstractFacePage {

    public FreindFaceActiverInteractionsPage(){
        super();
    }

    public boolean checkInteractionsStatus(String status, String interaction){
       return Init.getWebDriver().findElement(By.xpath("//span[contains(text(),'"+ interaction +"')]/parent::div/following-sibling::div[@class='request__status']/span[@class='request__status__text']")).getText().equalsIgnoreCase(status);
    }

}
