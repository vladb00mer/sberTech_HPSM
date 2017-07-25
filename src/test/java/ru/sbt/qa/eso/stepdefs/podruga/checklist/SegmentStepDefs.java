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
import ru.sbt.qa.eso.pages.podruga.checklist.segment.FindSegmentPage;
import ru.sbt.qa.eso.pages.podruga.checklist.segment.SegmentFormPage;
import ru.sbt.qa.eso.pages.podruga.checklist.segment.CreateSegmentPage;
import ru.sbt.qa.eso.pages.podruga.checklist.segment.AddBuildingsToSegmentPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class SegmentStepDefs {
    
    private List<String[]> testData;;

    public SegmentStepDefs() throws IOException {
        testData = new CSVFileReader("Сегменты").getDataPool();
    }
    
    @When("^Создать Сегмент$")
    public void createSegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
                
                new FindSegmentPage().beginSegmentCreation();
            
                new CreateSegmentPage().createSegment(record[2], record[3], record[4]);
                
                new LogRecordsListPage().checkResult("Создаём сегмент");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Сегмент':\n", er);
            
            } finally {
                new MainPage().doLogOut();
            } 
        }
    }
    
    @When("^Проверить Сегмент$")
    public void verifySegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
            
                new FindSegmentPage().findSegment(record[2]);
            
                new SegmentFormPage().verifySegment(record[2], record[3], record[4]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверить Сегмент':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Отредактировать Сегмент$")
    public void modifySegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
            
                new FindSegmentPage().findSegment(record[2]);
            
                new SegmentFormPage().modifySegment(record[7], record[5]);
                
                new LogRecordsListPage().checkResult("Запись типа \"segment\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Отредактировать Сегмент':\n", er);
           
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Добавить здания в Сегмент$")
    public void addBuildingsToSegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
            
                new FindSegmentPage().findSegment(record[2]);
            
                new SegmentFormPage().addBuildingToSegmentClick();
            
                new AddBuildingsToSegmentPage().addBuilding(record[6]);
                
                new LogRecordsListPage().checkResult("Запись типа \"segment\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Добавить здания в Сегмент':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }  
        }
    }
        
    @When("^Удалить здания из Сегмента$")
    public void deleteBuildingsFromSegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
            
                new FindSegmentPage().findSegment(record[2]);
            
                new SegmentFormPage().removeBuildingFromSegment();
                
                new LogRecordsListPage().checkResult("Запись типа \"segment\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить здания из Сегмента':\n", er);
           
            } finally {
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Удалить Сегмент$")
    public void deleteSegment() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToSegment();
            
                new FindSegmentPage().findSegment(record[2]);
            
                new SegmentFormPage().deleteSegment();
                
                new LogRecordsListPage().checkResult("Запись элемента \"segment\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Сегмент':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
}