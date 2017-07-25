package ru.sbt.qa.eso.stepdefs.podruga.workgroups;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.workgroups.LeftSideBarWorkGroup;
import ru.sbt.qa.eso.pages.podruga.workgroups.create.CreateWorkGroupPage;
import ru.sbt.qa.eso.pages.podruga.workgroups.create.WorkGroupPage;
import ru.sbt.qa.eso.pages.podruga.workgroups.tabs.EmployeTab;

/**
 *
 * @author sbt-murashov-vv
 */

public class WorkGroupChildStepDefs {
    
    private List<String[]> testData;;

    public WorkGroupChildStepDefs() throws IOException {        
        testData = new CSVFileReader("Рабочие_Группы").getDataPool();
    }
        
    @When("^Успешное создание дочерней РГ$")
    public void createChildWGPositive() {
        
        for (String[] record: testData) {
        
            try {                
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().createWG(record[4], record[3], "child");
                
                new LogRecordsListPage().checkResult("Запись \"Рабочая группа\" добавлена.");
    
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Успешное создание РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Неуспешное создание дочерней РГ$")
    public void createChildWGNegative() {
        
        for (String[] record: testData) {
        
            try {                
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().createWG(record[4], "", "child");
                
                new LogRecordsListPage().checkResult("Поле \"Hpc Coordinator\" является обязательным.");
                
                } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Неуспешное создание РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Успешное редактирование дочерней РГ$")
    public void modifyChildWGPositive() {
        
        for (String[] record: testData) {
        
             try {                
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().findActiveWG(record[4]);
                
                new WorkGroupPage().renameWG("WG_modified", "");
                
                new LogRecordsListPage().checkResult("Запись типа \"Рабочая группа\" обновлена.");
                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Успешное редактирование дочерней РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Неуспешное редактирование дочерней РГ$")
    public void modifyChildWGNegative() {
        
        for (String[] record: testData) {
        
            try {                
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().findActiveWG("").selectRandomWG();
                
                new WorkGroupPage().renameWG(record[4], "Сивова Мария");
                
                new LogRecordsListPage().checkResult("Обновляемая запись содержит дублированный ключ. (se.base.method,update.record)");
                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Неуспешное редактирование дочерней РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Добавление нескольких сотрудников в РГ$")
    public void addEmployes() {
        
        for (String[] record: testData) {
        
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().findActiveWG(record[4]);
                
                new EmployeTab().fillEmployeTab(2);
                
                new LogRecordsListPage().checkResult("Запись типа \"Рабочая группа\" обновлена.");
                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Добавление нескольких сотрудников в РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Удаление дочерней РГ$")
    public void deleteWG() {
        
        for (String[] record: testData) {
        
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarWorkGroup().goToWorkGroups();
                
                new CreateWorkGroupPage().findActiveWG("WG_modified");
                
                new WorkGroupPage().deleteWG();
                
                new LogRecordsListPage().checkResult("Запись элемента \"Рабочая группа\" удалена.");
                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Удаление дочерней РГ':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
}
