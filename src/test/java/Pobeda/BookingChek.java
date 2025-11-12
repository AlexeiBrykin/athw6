package Pobeda;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingChek {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "body > div.app-container > section > div.content > div > div > div > div.orderSearchForm__i > div > form > div.iconfirm.iconfirm--order > div > div > label > span")
    WebElement policyChek;

    @FindBy(css = "body > div.app-container > section > div.content > div > div > div > div.orderSearchForm__i > div > form > div.formBodyItem > div > div > button")
    WebElement searchButton;

    @FindBy(css = "body > div.app-container > section > div.content > div > div > div.message_error")
    WebElement errorTest;

    public BookingChek(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void getErrorText() {
        policyChek.click();
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOf(errorTest));
        Assert.assertEquals("Заказ с указанными параметрами не найден",errorTest.getText());
    }
}
