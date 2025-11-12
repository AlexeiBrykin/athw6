package Pobeda;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "head > title")
    WebElement title;

    @FindBy(css = "a img[src=\"/_next/static/media/logo-rus-white.b9d69d0a.svg\"]")
    WebElement logo;

    @FindBy(css = "#__next > div.dp-lw1vya-root > footer > div > div.dp-16lw1pq-root-root > div:nth-child(1) > div:nth-child(3) > a")
    WebElement bookingManagementBottomButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        // Инициализация WebDriverWait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Инициализация элементов через PageFactory
        PageFactory.initElements(driver, this);
    }

    // Метод для проверки заголовка страницы
    public String getTitleText() {
        System.out.println(title.getAttribute("textContent"));
        return title.getAttribute("textContent");
    }

    // Метод для проверки видимости логотипа
    public boolean isLogoVisible() {
        wait.until(ExpectedConditions.visibilityOf(logo));
        return logo.isDisplayed();
    }

    private void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void bookingManagementBottomButtonClick() {
        scrollTo(bookingManagementBottomButton);
        bookingManagementBottomButton.click();
    }
}