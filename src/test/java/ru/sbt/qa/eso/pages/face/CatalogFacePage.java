package ru.sbt.qa.eso.pages.face;

import org.openqa.selenium.By;
import ru.sbt.qa.bdd.Init;

/**
 * Created by sbt-horunzhev-as on 03.04.2017.
 */

public class CatalogFacePage extends AbstractFacePage {

    public CatalogFacePage(){
        super();
    }

    public void checkCatalogNavigation(String firstElementInTree, String secondElementInTree){
        Init.getWebDriver().findElement( By.xpath("//a[@class='name' and text()='"+ firstElementInTree +"']")).click();
        Init.getWebDriver().findElement( By.xpath("//a[@class='link' and text()='"+ secondElementInTree +"']")).click();
    }
}
