package ru.sbt.qa.eso.stepdefs.podruga.checklist;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.checklist.LeftSideBarCheckList;
import ru.sbt.qa.eso.pages.podruga.checklist.checklisttemplate.CheckListTemplatePage;
import ru.sbt.qa.eso.pages.podruga.checklist.checklisttemplate.FindCheckListTemplatePage;

/**
 *
 * @author sbt-murashov-vv
 */

public class CheckListTemplateStepDefs {
    
    private List<String[]> testData;

    public CheckListTemplateStepDefs() throws IOException {
        testData = new CSVFileReader("Шаблоны_Чек-Листа").getDataPool();
    }
    
    @When("^Создать Шаблон Чек-Листа$")
    public void createCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
                
                new FindCheckListTemplatePage().createCheckListTemplate(record[2]);
                
                new LogRecordsListPage().checkResult("Запись \"tplchecklist\" добавлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Шаблон Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Проверить Шаблон Чек-Листа$")
    public void verifyCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
            
                new FindCheckListTemplatePage().findCheckListTemplate(record[2]);
                
                new CheckListTemplatePage().verifyCheckListTemplate(record[2]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверить Шаблон Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Добавить Задания в Шаблон Чек-Листа$")
    public void addTaskToCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
            
                new FindCheckListTemplatePage().findCheckListTemplate(record[4]);
                
                new CheckListTemplatePage().addTasks(record[3]);
                
                new LogRecordsListPage().checkResult("Запись типа \"tplchecklist\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Добавить Задания в Шаблон Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Удалить Задания из Шаблона Чек-Листа$")
    public void removeTaskFromCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
            
                new FindCheckListTemplatePage().findCheckListTemplate(record[4]);
                
                new CheckListTemplatePage().deleteTasks();
                
                new LogRecordsListPage().checkResult("Запись типа \"tplchecklist\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Задания из Шаблона Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }    
    
    @When("^Отредактировать Шаблон Чек-Листа$")
    public void modifyCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
            
                new FindCheckListTemplatePage().findCheckListTemplate(record[2]);
                
                new CheckListTemplatePage().modifyCheckListTemplate(record[4]);
                
                new LogRecordsListPage().checkResult("Запись типа \"tplchecklist\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Отредактировать Шаблон Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Удалить Шаблон Чек-Листа$")
    public void deleteCheckListTemplate() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCheckListTemplates();
            
                new FindCheckListTemplatePage().findCheckListTemplate(record[4]);
                
                new CheckListTemplatePage().deleteCheckListTemplate();
                
                new LogRecordsListPage().checkResult("Запись элемента \"tplchecklist\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Шаблон Чек-Листа':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
}