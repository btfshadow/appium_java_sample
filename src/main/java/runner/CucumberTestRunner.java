package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helper.AppiumDriverHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
        features = {"src/main/resources/features"},
        tags = {"~@instrumentado/unitário","~@testeContrato","~@visualRegression","~@massaDedados"},
        glue = {"stepDefinition"})


public class CucumberTestRunner {

    @BeforeClass
    public static void tearUp(){
        AppiumDriverHelper.createDriver();

    }

    @AfterClass
    public static void tearDown(){
        AppiumDriverHelper.closeDriver();

    }



}
