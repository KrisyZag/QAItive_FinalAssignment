package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.ApartmentPage;
import pages.BookingPage;
import pages.SearchResultsPage;
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

    @And("I add guests with child age (.*)$")
    public void iAddGuestsNumber(String childAge) {
        BookingPage bookingPage = new BookingPage(driver, wdWait);
        bookingPage.guestsInput(childAge);
    }

    @And("^I choose apartment (.*)$")
    public void iChooseApartment(String apartment) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.chooseApartment(apartment);
    }

    @And("^I verify that for atribute (.*) location (.*)$")
    public void iVerifyLocation(String atribute, String location) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.checkLocation(atribute, location);
    }

    @And("^I verify dates from (.*) to (.*)$")
    public void iVerifyDates(String dateFrom, String dateTo) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.checkDates(dateFrom, dateTo);
    }

    @And("I verify adultCount (.*), childrenCount (.*), roomCount (.*)$")
    public void iVerifyPersonRooomCount(String adultCount, String childrenCount, String roomCount) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wdWait);
        searchResultsPage.checkPersonRooomCount(adultCount, childrenCount, roomCount);
    }

    @And("^I checked header in new tab (.*)$")
    public void iCheckedDataInNewTab(String apartmentHeader) {
        ApartmentPage apartmentPage = new ApartmentPage(driver, wdWait);
        apartmentPage.getWidowData(apartmentHeader);
    }
}
