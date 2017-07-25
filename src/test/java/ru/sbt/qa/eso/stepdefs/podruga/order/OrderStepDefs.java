package ru.sbt.qa.eso.stepdefs.podruga.order;

import cucumber.api.java.en.When;
import java.io.IOException;
import java.util.List;
import ru.sbt.qa.bdd.AutotestError;
import ru.sbt.qa.eso.csvreader.CSVFileReader;
import ru.sbt.qa.eso.pages.podruga.LogRecordsListPage;
import ru.sbt.qa.eso.pages.podruga.MainPage;
import ru.sbt.qa.eso.pages.podruga.SUDIRAuthorisationPage;
import ru.sbt.qa.eso.pages.podruga.order.LeftSideBarOrder;
import ru.sbt.qa.eso.pages.podruga.order.orders.CreateOrderPage;
import ru.sbt.qa.eso.pages.podruga.order.orders.FindOrderPage;
import ru.sbt.qa.eso.pages.podruga.order.orders.OrderPage;

/**
 *
 * @author sbt-murashov-vv
 */

public class OrderStepDefs {
    
    private List<String[]> testData;;

    public OrderStepDefs() throws IOException {
        testData = new CSVFileReader("Заявки").getDataPool();
    }
    
    @When("^Создать Заявку из Обращения в ПО ДРУГа$")
    public void createOrder() {
        
        for (String[] record: testData) {
        
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new CreateOrderPage().createOrder("Мурашов Влад");
                
                new LogRecordsListPage().checkResult("!!!!!!!!!!!!!!!!!!!!!!!!");
                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Создать Заявку из Обращения':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }
    
    @When("^Проверка состава полей Заявки$")
    public void verifyOrder() {
        
        for (String[] record: testData) {
        
            try {
                
                new SUDIRAuthorisationPage().doAuthorise(record[0], record[1]);
                
                new LeftSideBarOrder().goToOrderSearch();
                
                new FindOrderPage().findOrder("Заявка на С/И/У Услуги","SR000187");
                
                new OrderPage().verifyOrderParameters("Челышков Сергей", "управление каталогом услуг", "Удаление");
                
                                
            } catch (Error | Exception er) {
                
                throw new AutotestError("Внимание! Ошибка на шаге 'Проверка заполнения полей Заявки':\n", er);
            
            } finally {
                
                new MainPage().doLogOut();
            }
        }
    }    
}
