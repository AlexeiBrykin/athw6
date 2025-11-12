package Pobeda;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tests {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Рекомендуется использовать меньше 15 секунд
        driver.manage().window().maximize();
        driver.get("https://www.flypobeda.ru/");
    }

    @Test
    public void checkPopup() {
        Popup popup = new Popup(driver);

        // Ожидание появления кнопки информации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(popup.informationButton));

        // Наведение курсора на кнопку информации
        popup.hoverToInformationButton();

        // Ожидание появления всплывающего окна
        wait.until(ExpectedConditions.visibilityOf(popup.popup));

        // Проверка видимости всплывающего окна
        Assert.assertTrue("Всплывающее окно должно быть видимым", popup.isPopupVisible());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null; // Очистка ссылки
        }
    }
}