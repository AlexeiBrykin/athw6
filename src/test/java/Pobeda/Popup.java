package Pobeda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Popup {
    private final WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(null, Duration.ofSeconds(30));

    @FindBy(css = "a[href=\"/information\"]")
    WebElement informationButton;

    @FindBy(css = "div.dp-51aygc-inner")
    WebElement popup;

    public Popup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverToInformationButton() {
        Actions actions = new Actions(driver);
        System.out.println("провалились в ховер");
        wait.until(ExpectedConditions.visibilityOf(informationButton));
        actions.moveToElement(informationButton)
                .perform();
        System.out.println("мышь сверху");
    }

    public boolean isPopupVisible() {
        wait.until(ExpectedConditions.visibilityOf(popup));
        return popup.isDisplayed();
    }
}