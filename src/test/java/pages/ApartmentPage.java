package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApartmentPage extends BasePage {

    WebDriver driver;
    WebDriverWait wdWait;

    public ApartmentPage(WebDriver driver, WebDriverWait wdWait) {
        super(driver, wdWait);
        this.driver = driver;
        this.wdWait = wdWait;
        PageFactory.initElements(driver, this);
    }

    String apartmentHeader = "//a[@class = 'bui_breadcrumb__link_masked' and contains(text(), '$')]";

    public void getWidowData(String apartmentName) {
        for (String childTab : driver.getWindowHandles()) {
            driver.switchTo().window(childTab);
        }
        driver.findElement(By.xpath(apartmentHeader.replace("$", apartmentName))).isDisplayed();
    }
}
