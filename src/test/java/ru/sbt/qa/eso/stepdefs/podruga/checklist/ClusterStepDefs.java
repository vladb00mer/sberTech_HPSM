package ru.sbt.qa.eso.stepdefs.podruga.checklist;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.checklist.LeftSideBarCheckList;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.checklist.cluster.ClusterFormPage;
import ru.sbt.qa.eso.pages.podruga.checklist.cluster.CreateClusterPage;
import ru.sbt.qa.eso.pages.podruga.checklist.cluster.FindClusterPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class ClusterStepDefs {
    
    private List<String[]> testData;;

    public ClusterStepDefs() throws IOException {
        testData = new CSVFileReader("Кластеры").getDataPool();
    }
        
    @When("^Создать Кластер$")
    public void createCluster() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCluster();
            
                new FindClusterPage().beginClusterCreation();
            
                new CreateClusterPage().createCluster(record[2], record[3], record[4], record[5]);
                
                new ClusterFormPage().verifyCluster(record[2], record[3], record[4], record[5]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Кластер':\n", er);
            
            } finally {                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Проверить Кластер$")
    public void verifyCluster() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCluster();
            
                new FindClusterPage().findCluster(record[2]);
            
                new ClusterFormPage().verifyCluster(record[2], record[3], record[4], record[5]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверить Кластер':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
    
    @When("^Отредактировать Кластер$")
    public void modifyCluster() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarCheckList().goToCluster();
            
                new FindClusterPage().findCluster(record[2]);
            
                new ClusterFormPage().changeSM(record[6]);
                
                new LogRecordsListPage().checkResult("Запись типа \"cluster\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Отредактировать Кластер':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }        
        }
    }
    
    @When("^Удалить Кластер$")
    public void deleteCluster() {
        
        for (String[] record: testData) {
        
            try {            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarCheckList().goToCluster();
            
                new FindClusterPage().findCluster(record[2]);
            
                new ClusterFormPage().deleteCluster();
                
                new LogRecordsListPage().checkResult("Запись элемента \"cluster\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удалить Кластер':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }            
        }
    }
}