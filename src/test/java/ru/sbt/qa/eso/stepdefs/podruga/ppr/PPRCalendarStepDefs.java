package ru.sbt.qa.eso.stepdefs.podruga.ppr;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.ppr.LeftSideBarPPR;
import ru.sbt.qa.eso.pages.podruga.ppr.calendar.PPRCalendarPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class PPRCalendarStepDefs {
    
    private List<String[]> testData;

    public PPRCalendarStepDefs() throws IOException {
        testData = new CSVFileReader("ППР").getDataPool();
    }
    
    @When("^Перейти на форму Календарь ППР$")
    public void informationTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCalendar();
                
                new PPRCalendarPage().verifyCalendarPage();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Перейти на форму Календарь ППР':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Проверка фильтра ЗнО$")
    public void filterZNO() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCalendar();
                
                new PPRCalendarPage().useFilterZNO();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка фильтра ЗнО':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Проверка фильтра Работы$")
    public void filterWorks() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCalendar();
                
                new PPRCalendarPage().useFilterWorks();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка фильтра Работы':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
}
