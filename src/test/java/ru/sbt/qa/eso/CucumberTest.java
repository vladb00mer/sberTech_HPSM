package ru.sbt.qa.eso;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import ru.sbt.qa.reruner.ExtendedCucumber;

/**
 *
 * @author sbt-murashov-vv
 */
 
@RunWith(ExtendedCucumber.class)
@CucumberOptions(monochrome = true, format = {"pretty"},
    glue = {"ru.sbt.qa.eso.stepdefs"},
    features = {"src/test/resources/features"},
    tags = {"~@vsekromemenya"})
public class CucumberTest {
}