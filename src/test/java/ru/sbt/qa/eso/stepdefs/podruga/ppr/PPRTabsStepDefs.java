package ru.sbt.qa.eso.stepdefs.podruga.ppr;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.ppr.LeftSideBarPPR;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.ApprovalPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.InformationAboutPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.NotificationVKPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.TasksPPRTab;

/**
 *
 * @author sbt-murashov-vv
 */

public class PPRTabsStepDefs {
    
    private List<String[]> testData;

    public PPRTabsStepDefs() throws IOException {
        testData = new CSVFileReader("ППР").getDataPool();
    }
    
    @When("^Проверка вкладки Сведения о ППР$")
    public void informationTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillAllData(record[3], record[4], record[5]);
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка вкладки Сведения о ППР':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Проверка вкладки Оповещение ВК$")
    public void notificationTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCreatePPR();
                
                new NotificationVKPPRTab().sayYes();
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarPPR().goToCreatePPR();
                
                new NotificationVKPPRTab().sayNo();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка вкладки Оповещение ВК':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Проверка вкладки Согласования ППР$")
    public void approvalTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCreatePPR();
                
                new ApprovalPPRTab().fillAllData(record[5]);
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка вкладки Согласования ППР':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Проверка вкладки Задания по ППР$")
    public void tasksTab() {        
        
        for (String[] record: testData) {
            
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
                new LeftSideBarPPR().goToCreatePPR();
                
                new TasksPPRTab().verifyFields();
                
            } catch (Error | Exception er) {
            
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка вкладки Задания по ППР':\n", er);
            
            } finally {       
            
                new MainPage().doLogOut();
            }            
        }
    }    
}
