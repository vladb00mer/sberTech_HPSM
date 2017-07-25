package ru.sbt.qa.eso.stepdefs.podruga.subscriptions;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.officesandstaff.LeftSideBarOfficesAndStaff;
import ru.sbt.qa.eso.pages.podruga.officesandstaff.employee.EmployePage;
import ru.sbt.qa.eso.pages.podruga.officesandstaff.employee.EmployeePageSubscriptionsTab;
import ru.sbt.qa.eso.pages.podruga.officesandstaff.employee.FindEmployePage;
import ru.sbt.qa.eso.pages.podruga.sla.LeftSideBarSubscription;
import ru.sbt.qa.eso.pages.podruga.sla.subscriptions.FindSubscriptionsPage;
import ru.sbt.qa.eso.pages.podruga.sla.subscriptions.SubscriptionPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class SubscriptionsStepDefs {
    
    private List<String[]> testData;

    public SubscriptionsStepDefs() throws IOException {
        testData = new CSVFileReader("Подписки").getDataPool();
    }
    
    @When("^Создать Подписку$")
    public void createSubscription() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().createSubscription(record[2], "Отдельное лицо", record[3], record[4], record[5], "Новая");
                
                new SubscriptionPage().activateSubscription();
                
                new LogRecordsListPage().checkResult("Запись типа \"Конфигурационная единица\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Подписку':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Дубликат Подписки$")
    public void createDoubleSubscription() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().createSubscription(record[2], "Отдельное лицо", record[3], record[4], record[5], "Дубликат");
                
                new LogRecordsListPage().checkResult("Подписка с такими данными уже существует");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Дубликат Подписки':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Удаление подписки у Сотрудника$")
    public void deleteSubscription() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().findSubscription(record[2], "Отдельное лицо", record[3]);
                
                new SubscriptionPage().deleteSubscription();
                
                new LogRecordsListPage().checkResult("Запись элемента \"Subscription\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удаление подписки у Сотрудника':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Удаление подписки у Подразделения$")
    public void deleteFosSubscription() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().findSubscription(record[2], "Подразделение", record[6]);
                
                new SubscriptionPage().deleteSubscription();
                
                new LogRecordsListPage().checkResult("Запись элемента \"Subscription\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Удаление подписки у Подразделения':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    
    @When("^Отображение Подписок$")
    public void showSubscriptionList() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().findSubscription("", "Отдельное лицо", record[3]).countSubscriptions();
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка отображения Подписок':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Создание подписки на подразделение$")
    public void fosSubscription() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarSubscription().goToSubscriptions();
                
                new FindSubscriptionsPage().createSubscription(record[2], "Подразделение", record[6], record[4], record[5], "Новая");
                
                new SubscriptionPage().activateSubscription();
                
                new LogRecordsListPage().checkResult("Запись типа \"Конфигурационная единица\" обновлена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Создание подписки на подразделение':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Изменение статуса ЭУ$")
    public void changeServiceInstanceStatus() {
        
        for (String[] record: testData) {
        
            try {                       
            
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
            
                new LeftSideBarOfficesAndStaff().goToEmployees();
                
                new FindEmployePage().findEmploye(record[3]);
                
                new EmployePage().goToSubscriptions();
                
                new EmployeePageSubscriptionsTab().goToServiceInstance();
                
                new SubscriptionPage().archivateSubscription()
                                      .deleteSubscription();
                
                new LogRecordsListPage().checkResult("Запись элемента \"Subscription\" удалена.");
            
            } catch (Error | Exception er) {
                throw new AutotestError("Внимание! Ошибка на шаге 'Изменения статуса ЭУ':\n", er);
            
            } finally {            
                new MainPage().doLogOut();
            }
        }
    }
}
