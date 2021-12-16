package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class = 'sb-date-field__wrapper']//div[@data-placeholder='Datum prijavljivanja']")
    WebElement arrivalDate;

    @FindBy(xpath = "//div[@class = 'sb-date-field__wrapper']//div[@data-placeholder='Datum odjavljivanja']")
    WebElement departureDate;

    @FindBy(xpath = "//span[@class = 'adults-count']")
    WebElement adultsCount;

    @FindBy(xpath = "//span[@class = 'children-count']")
    WebElement childrenCount;

    @FindBy(xpath = "//span[@data-room-count]")
    WebElement roomCount;

    @FindBy(css = "#ss")
    WebElement location;

    String selectApartment = "//a[@role = 'button' and contains(@href, '$')]";

    public void chooseApartment(String apartment) {
        click(driver.findElement(By.xpath(selectApartment.replace("$", apartment))));
    }

    public void checkLocation(String atribute, String reserveLocation) {
        assertEqualsGetAtribute(location, atribute, reserveLocation);
    }

    public void checkDates(String arrDate, String depDate) {
        assertEqualsGetText(arrivalDate, arrDate);
        assertEqualsGetText(departureDate, depDate);
    }

    public void checkPersonRooomCount(String adultNo, String childrenNo, String roomNo) {
        assertEqualsGetText(adultsCount, adultNo);
        assertEqualsGetText(childrenCount, childrenNo);
        assertEqualsGetText(roomCount, roomNo);
    }

}
