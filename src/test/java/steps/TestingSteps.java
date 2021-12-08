package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.BookingPage;
import pages.HomePage;
import tests.BaseTest;

import java.io.IOException;

public class TestingSteps extends BaseTest {

    @Before
    public void initCucumber() {
        init("Chrome", "95", 30);
    }

    @After
    public void tearDown() throws IOException {
        reportScreenshot("Test", "TestAllure");
        quitDriver();
    }

    @Given("I am on Booking home page")
    public void iAmOnBookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @And("^I choose language (.*)$")
    public void iChooseLanguageSrpski(String language) {
        BookingPage bookingPage = new BookingPage(driver, wdWait);
        bookingPage.chooseLanguage(language);
    }

    @And("^I add destination (.*)$")
    public void iAddDestination(String location) {
        BookingPage bookingHomePage = new BookingPage(driver, wdWait);
        bookingHomePage.enterLocation(location);
    }

    @And("^I add start (.*) and end date (.*)$")
    public void iAddStartAndEndDate(String start, String end) {
        BookingPage bookingHomePage = new BookingPage(driver, wdWait);
        bookingHomePage.selectDates(start, end);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        BookingPage bookingPage = new BookingPage(driver, wdWait);
        bookingPage.clickSearchButton();
    }

    @And("I add guests number")
    public void iAddGuestsNumber() {
        BookingPage bookingPage = new BookingPage(driver, wdWait);
        bookingPage.guestsInput();
    }
}