package ru.sbt.qa.eso.stepdefs.podruga.checklist;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.checklist.LeftSideBarCheckList;
import ru.sbt.qa.eso.pages.podruga.checklist.itemGroup.FindItemGroupPage;
import ru.sbt.qa.eso.pages.podruga.checklist.itemGroup.ItemGroupPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class ItemGroupStepDefs {
    
    private List<String[]> testData;;

    public ItemGroupStepDefs() throws IOException {
        testData = new CSVFileReader("Группы_Пунктов").getDataPool();
    }
    
    @When("^Создать Группу Пунктов$")
    public void createItemGroup() {
        
        for (String[] record: testData) {
        
            try {  
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemGroups();
                
                new FindItemGroupPage().createItemGroup(record[2]);
                
                new LogRecordsListPage().checkResult("Запись \"tplcheckgroup\" добавлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Группу Пунктов':\n", er);
            
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Проверить Группу Пунктов")
    public void verifyItemGroup() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemGroups();
            
                new FindItemGroupPage().findItemGroup(record[2]);
                
                new ItemGroupPage().verifyItemGroup(record[2]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверить Группу Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Отредактировать Группу Пунктов")
    public void modifyItemGroup() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemGroups();
            
                new FindItemGroupPage().findItemGroup(record[3]);
                
                new ItemGroupPage().modifyItemGroup();
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Отредактировать Группу Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Удалить Группу Пунктов")
    public void deleteItemGroup() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToItemGroups();
            
                new FindItemGroupPage().findItemGroup(record[4]);
                
                new ItemGroupPage().deleteItemGroup();
                
                new LogRecordsListPage().checkResult("Запись элемента \"tplcheckgroup\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Группу Пунктов':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }    
}