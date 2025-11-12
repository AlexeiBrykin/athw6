package Pobeda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Popup {
    WebDriver driver;

    @FindBy(css = "a[href=\"/information\"]")
    WebElement informationButton;

    @FindBy(css = "div.dp-51aygc-inner")
    WebElement popup;

    public Popup(WebDriver driver) {
        this.driver = driver;
        // Инициализация элементов через PageFactory
        PageFactory.initElements(driver, this);
    }

    public void hoverToInformationButton() {
        Actions actions = new Actions(driver);
        System.out.println("провалились в ховер");
        actions.moveToElement(informationButton)
                .perform();
        System.out.println("мышь сверху");
    }

    // Метод для проверки видимости всплывающего окна
    public boolean isPopupVisible() {
        return popup.isDisplayed();
    }
}