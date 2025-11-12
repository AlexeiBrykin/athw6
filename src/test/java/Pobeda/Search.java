package Pobeda;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Search {
    private WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[placeholder=\"Откуда\"]")
    WebElement departureField;

    @FindBy(css = "input[placeholder=\"Куда\"]")
    WebElement arrivalField;

    @FindBy(css = ".dp-zxyhce-root div.dp-20s1up-root-suggestionName")
    WebElement snippetMoskva;

    @FindBy(css = ".dp-k64vy3-root-root-root")
    WebElement searchButton;

    @FindBy(css = "a img[src=\"/_next/static/media/logo-rus-white.b9d69d0a.svg\"]")
    WebElement departureDate;

    @FindBy(css = ".dp-1dr6zbu-root[data-failed]")
    WebElement departureDateFrame;

    public Search(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Инициализация WebDriverWait с переданным WebDriver
        PageFactory.initElements(driver, this);
    }

    public void enterDeparture(String departureCity) {
        System.out.println("Провалились в ввод деп");
        departureField.click();
        System.out.println("клик в деп");
        snippetMoskva.click();
        System.out.println("клик в москву");
        Assert.assertEquals(departureField.getAttribute("value"), departureCity);
        System.out.println("Деп верный");
    }

    public void enterArrival(String arrivalCity) {
        System.out.println("Провалились в ввод арр");
        arrivalField.sendKeys(arrivalCity);
        System.out.println("Установили арр");
        Assert.assertEquals(arrivalField.getAttribute("value"), arrivalCity);
        System.out.println("арр верный");
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getFrameColor() throws InterruptedException {
      //  Thread.sleep(1000);
        wait.until(ExpectedConditions.attributeContains(departureDateFrame, "border-color", "rgb(213, 0, 98)"));
        System.out.println(departureDateFrame.getCssValue("border-color"));
        if (departureDateFrame.getCssValue("border-color").equals("rgb(213, 0, 98)"))
            return "red";
        return "not red";
    }
}
