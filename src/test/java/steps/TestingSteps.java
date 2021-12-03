package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import tests.BaseTest;

import java.io.IOException;

public class GSteps extends BaseTest {

    @Before
    public void initCucumber() {
        init("Chrome", "95", 30);
    }

    @After
    public void tearDown() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

    @Given("I am on products page")
    public void iAmOnSwagLabsPage() {
        driver.get("https://www.saucedemo.com/");
    }


}