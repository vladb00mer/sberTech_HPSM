package ru.sbt.qa.eso.stepdefs.podruga.ppr;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.ppr.LeftSideBarPPR;
import ru.sbt.qa.eso.pages.podruga.ppr.search.PPRSearchPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class PPRSearchStepDefs {
    
    private List<String[]> testData;

    public PPRSearchStepDefs() throws IOException {
        testData = new CSVFileReader("ППР").getDataPool();
    }
    
    @When("^Переход на форму Поиск ППР$")
    public void informationTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToSearchPPR();
                
                new PPRSearchPage().verifyFields();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Переход на форму Поиск ППР':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }        
}
