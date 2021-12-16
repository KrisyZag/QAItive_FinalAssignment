package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BookingPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public BookingPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@data-modal-id= 'language-selection']")
    WebElement chooseLanguage;

    String languageLinkXpath = "//*[@class='bui-group bui-group--large']/div[2]//div[@lang = '$']/../..";

    @FindBy(css = "#ss")
    WebElement location;

    @FindBy(css = ".xp__dates.xp__group")
    WebElement dates;

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    WebElement next;

    @FindBy(css = ".xp__input")
    WebElement guestsNo;

    @FindBy(xpath = "//button[@class='sb-searchbox__button ']")
    WebElement searchButton;

    @FindBy(xpath = "//button[@aria-label ='Deca: povećajte broj']")
    WebElement addChildren;

    @FindBy(xpath = "//select[@aria-label ='Uzrast deteta 1']")
    WebElement firstChildAgeList;

    @FindBy(xpath = "//button[@aria-label='Jedinice: povećajte broj']")
    WebElement addRoomNo;

    public void chooseLanguage(String language) {
        click(chooseLanguage);
        click(driver.findElement(By.xpath(languageLinkXpath.replace("$", language))));
    }

    public void enterLocation(String locationValue) {
        typeText(location, locationValue);
    }

    public void selectDates(String startDate, String endDate) {
        click(dates);

        while (true) {
            List<WebElement> startDateList = driver.findElements(By.xpath("//span[@aria-label='" + startDate + "']"));

            if (startDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + startDate + "']")));
                break;
            }
        }

        while (true) {
            List<WebElement> endDateList = driver.findElements(By.xpath("//span[@aria-label='" + endDate + "']"));

            if (endDateList.size() == 0) {
                click(next);
            } else {
                click(driver.findElement(By.xpath("//span[@aria-label='" + endDate + "']")));
                break;
            }
        }
    }

    public void selectFirstChildAge(String value) {
        selectByVisibleText(firstChildAgeList, value);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void guestsInput(String firstChildAge) {
        click(guestsNo);
        click(addChildren);
        click(firstChildAgeList);
        selectFirstChildAge(firstChildAge);
        click(addRoomNo);
    }
}
