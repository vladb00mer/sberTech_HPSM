package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.By;
import ru.sbt.qa.bdd.Init;

/**
 * Created by sbt-horunzhev-as on 02.04.2017.
 */

public class FriendFaceClosedInteractionsPage extends AbstractFacePage {

    public FriendFaceClosedInteractionsPage(){
        super();
    }

    public boolean isInteractionsExist(String interaction){
        System.out.print(Init.getWebDriver().findElements(By.xpath("//span[contains(text(),'"+ interaction +"')]")));
        return Init.getWebDriver().findElements(By.xpath("//span[contains(text(),'"+ interaction +"')]")) != null;
    }

}
