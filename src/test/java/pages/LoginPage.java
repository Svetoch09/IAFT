package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        browser.findElement(USERNAME_INPUT).sendKeys(username);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BTN).click();
    }
}