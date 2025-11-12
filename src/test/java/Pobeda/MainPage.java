package Pobeda;

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
}