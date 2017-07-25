package ru.sbt.qa.eso.stepdefs.podruga.templates;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.templates.LeftSideBarTemplates;
import ru.sbt.qa.eso.pages.podruga.templates.requests.CreateRequestTemplatePage;
import ru.sbt.qa.eso.pages.podruga.templates.requests.FindRequestTemplatePage;

/**
 *
 * @author sbt-murashov-vv
 */

public class RequestTemplatesStepDefs {
    
    private List<String[]> testData;

    public RequestTemplatesStepDefs() throws IOException {
        testData = new CSVFileReader("Шаблоны_Обращений").getDataPool();
    }
    
    @When("^Создать Шаблон Обращения$")
    public void createRequestTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarTemplates().goToRequestTemplateSearchPage();
                
                new CreateRequestTemplatePage().beforeErrorCreationRequestTemplate(record[3], record[4], record[5], record[6]);
                
                new LogRecordsListPage().checkResult("Укажите Услугу");
                
                new CreateRequestTemplatePage().afterErrorCreationRequestTemplate();
                
                new LogRecordsListPage().checkResult("Ожидаемый текст сообщения об успехе операции");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Шаблон Обращения':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Найти существующий Шаблон Обращения$")
    public void findRequestTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarTemplates().goToRequestTemplateSearchPage();
                
                new FindRequestTemplatePage().findRequestTemplate(record[2]);
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Найти существующий Шаблон Обращения':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Найти все Шаблоны Обращений$")
    public void findAllRequestTemplates() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarTemplates().goToRequestTemplateSearchPage();
                
                new FindRequestTemplatePage().findEmptyRequestTemplate();
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Найти все Шаблоны Обращений':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Найти несуществующий Шаблон Обращения$")
    public void findMissingRequestTemplate() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarTemplates().goToRequestTemplateSearchPage();
                
                new FindRequestTemplatePage().findMissingRequestTemplate();
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Найти несуществующий Шаблон Обращения':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
}
