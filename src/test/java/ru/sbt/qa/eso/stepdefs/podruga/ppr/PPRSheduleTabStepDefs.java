package ru.sbt.qa.eso.stepdefs.podruga.ppr;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.ppr.LeftSideBarPPR;
import ru.sbt.qa.eso.pages.podruga.ppr.create.PPRCreatePage;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.ApprovalPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.InformationAboutPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.NotificationVKPPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.ShedulePPRTab;
import ru.sbt.qa.eso.pages.podruga.ppr.tabs.TasksPPRTab;

/**
 *
 * @author sbt-murashov-vv
 */

public class PPRSheduleTabStepDefs {
    
    private List<String[]> testData;

    public PPRSheduleTabStepDefs() throws IOException {
        testData = new CSVFileReader("ППР").getDataPool();
    }
    
    @When("^Перейти на форму Планировщика ППР$")
    public void goToShedulerPPR() {
        
      for (String[] record: testData) {  
        
        try {
                
            new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                            
            new LeftSideBarPPR().goToCreatePPR();
                
            new PPRCreatePage().verifyTabs();
                
        } catch (Error | Exception er) {
            throw new AutotestError("Внимание! Ошибка на шаге 'Перейти на форму Планировщика ППР':\n", er);
            
        } finally {            
            new MainPage().doLogOut();
        }        
      }
    }
    
    @When("^Повторить работу Интервально$")
    public void repeatByInterval() {
        
        for (String[] record: testData) {
        
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByInterval();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Интервально$':\n", er);
            
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Повторить работу Ежедневно")
    public void repeatByDay() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByDay();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Ежедневно':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Повторить работу Еженедельно")
    public void repeatByWeek() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByWeek();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Еженедельно':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Повторить работу Ежемесячно")
    public void repeatByMonth() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByMonth();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Ежемесячно':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }    
    
    @When("^Повторить работу Ежегодно")
    public void repeatByYear() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByYear();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Ежегодно':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Повторить работу Произвольно")
    public void repeatByRandom() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarPPR().goToCreatePPR();
                
                new InformationAboutPPRTab().fillRequiredData(record[3], record[4], record[5]);
                
                new ShedulePPRTab().fillByRandom();
                
                new NotificationVKPPRTab().sayNo();
                
                new ApprovalPPRTab().autoFillApprover();
                
                new TasksPPRTab().fillRequired(record[5]);
                
                new PPRCreatePage().createPPR(record[2]);
                
                new LogRecordsListPage().checkResult("Запись ППР успешно создана");
                
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Повторить работу Произвольно':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
}
