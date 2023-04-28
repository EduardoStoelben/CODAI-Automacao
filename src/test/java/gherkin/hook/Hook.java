package gherkin.hook;

import driver.AppWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static driver.Drivers.getDriver;
import static driver.Drivers.testScenario;
import static report.Report.appendToReport;

public class Hook {

    @Before
    public void init(Scenario scenario) {
        AppWeb appWeb = new AppWeb();
        appWeb.setUpDriver();
        getDriver().manage().window().maximize();
        getDriver().get("http://127.0.0.1:5501/public/index.html");
        testScenario.set(scenario);
    }

    @After
    public void tearDown() {
        if (testScenario.get().isFailed()) {
            appendToReport();
        }
        getDriver().quit();
    }
}
