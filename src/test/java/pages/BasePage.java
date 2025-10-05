package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public static final String BASE_URL = PropertyReader.getProperty("sandbox.url");
    protected static final By PAGE_TITLE = By.xpath("//*[@data-test='title']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Checking the correctness of the page title")
    public String getPageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)).getText();
    }

    @Step("Checking the page title display")
    public boolean isPageTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)).isDisplayed();
    }
}