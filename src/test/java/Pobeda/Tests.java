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
    public void chekMainPage(){
        String title = "Авиакомпания «Победа» - купить авиабилеты онлайн," +
                " дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(title, mp.getTitleText());
        System.out.println("проверен титул");
        Assert.assertTrue(mp.isLogoVisible());
        System.out.println("проверено лого");
    }

    @Test
    public void checkPopup() {
        Popup popup = new Popup(driver);
        popup.hoverToInformationButton();
        Assert.assertTrue(popup.isPopupVisible());
        System.out.println("асерт успешен");
    }

    @Test
    public void checkDepDateFrame()  {
        Search search = new Search(driver);
        String departureCity = "Москва";
        String arrivalCity = "Санкт-Петербург";
        search.enterDeparture(departureCity);
        System.out.println("деп в тесте готов");
        search.enterArrival(arrivalCity);
        System.out.println("арр в тесте готов");
        search.clickSearchButton();
        System.out.println("поиск кликнут");
        Assert.assertEquals("red",search.getFrameColor());
    }

    @Test
    public void checkBookingBottom() {
        MainPage mp = new MainPage(driver);
        mp.bookingManagementBottomButtonClick();
        BookingManagement bm = new BookingManagement(driver);
        bm.chekUrl();
        Assert.assertTrue(bm.elementsArePresent());
        bm.searchFail();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}