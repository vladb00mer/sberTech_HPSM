package ru.sbt.qa.eso.stepdefs.podruga;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class CommonStepDefs {
    
    private List<String[]> testData;
    
    public CommonStepDefs() throws IOException {
        testData = new CSVFileReader("СУДИР").getDataPool();
    }
    
    
    @When("^Залогиниться в ПОДРУГа через СУДИР$")
    public void doAuthoriseSUDIR() {
        
        for (String[] record: testData) {
        
            try {                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Залогиниться в ПОДРУГа через СУДИР':\n", er);
                
            } finally {
                new MainPage().doLogOut();
            }
        }                   
    }                  
}
