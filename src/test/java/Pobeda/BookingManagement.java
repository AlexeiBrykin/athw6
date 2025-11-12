package Pobeda;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BookingManagement {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div:nth-child(3) > div.dp-i13qbi-root > form > div > div:nth-child(2) > div > div > input")
    WebElement orderNumber;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div:nth-child(3) > div.dp-i13qbi-root > form > div > div:nth-child(1) > div > div > input")
    WebElement clientName;

    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div:nth-child(3) > div.dp-i13qbi-root > form > div > div.dp-1larn3f-root")
    WebElement searchButton;

    public BookingManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void chekUrl() {
        Assert.assertEquals("https://www.flypobeda.ru/services/booking-management",driver.getCurrentUrl());
    }
    private boolean elementIsPresent(WebElement we) {
        return we.isDisplayed();
    }
    public boolean elementsArePresent(){
        return elementIsPresent(orderNumber)
                && elementIsPresent(clientName)
                && elementIsPresent(searchButton);
    }
    public void searchFail()  {
        orderNumber.sendKeys("XXXXXX");
        clientName.sendKeys("Qwerty");
        searchButton.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //получаем новый таб
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        //переключаемся на новый таб
        for (String handle : windowHandles) {
            if (!handle.equals(currentWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        BookingChek bc = new BookingChek(driver);
        bc.getErrorText();
    }
}
