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
import ru.sbt.qa.eso.pages.podruga.checklist.itemtemplate.FindItemTemplatePage;
import ru.sbt.qa.eso.pages.podruga.checklist.itemtemplate.ItemTemplatePage;

/**
 *
 * @author sbt-murashov-vv
 */

public class ItemTemplatesStepDefs {
    
    private List<String[]> testData;;

    public ItemTemplatesStepDefs() throws IOException {
        testData = new CSVFileReader("Шаблоны_Пунктов").getDataPool();
    }
    
    @When("^Создать Шаблон Пунктов$")
    public void createItemTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemTemplates();
                
                new FindItemTemplatePage().createItemTemplate(record[2], record[3], record[4], record[5], record[6], record[9]);
                
                new LogRecordsListPage().checkResult("Запись \"tplchecktask\" добавлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Шаблон Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Проверить Шаблон Пунктов$")
    public void verifyItemTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemTemplates();
                
                new FindItemTemplatePage().findItemTemplate(record[2]);
                
                new ItemTemplatePage().verifyItemTemplate(record[2], record[3], record[4], record[5], record[6], record[9]);
                        
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверить Шаблон Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Привязать шаблоны SMIT и ПОДРУГа$")
    public void addTemplatesSMITandPODRUGA() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemTemplates();
                
                new FindItemTemplatePage().findItemTemplate(record[2]);
                
                new ItemTemplatePage().addTemplatesPODRUGAandSMIT(record[7], record[8]);
                
                new LogRecordsListPage().checkResult("Запись типа \"tplchecktask\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Привязать шаблоны SMIT и ПОДРУГа':\n", er);
            
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Отредактировать Шаблон Пунктов$")
    public void modifyItemTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemTemplates();
                
                new FindItemTemplatePage().findItemTemplate(record[2]);
                
                new ItemTemplatePage().modifyItemTemplate(record[10], record[11], record[4], record[5], record[6]);
                
                new LogRecordsListPage().checkResult("Запись типа \"tplchecktask\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Отредактировать Шаблон Пунктов':\n", er);
            
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Удалить Шаблон Пунктов$")
    public void deleteItemTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemTemplates();
                
                new FindItemTemplatePage().findItemTemplate(record[10]);
                
                new ItemTemplatePage().deleteItemTemplate();
                
                new LogRecordsListPage().checkResult("Запись элемента \"tplchecktask\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Шаблон Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
}