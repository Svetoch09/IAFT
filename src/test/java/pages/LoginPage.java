package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    public void login(String username, String password) {
        fillLoginField(username);
        fillPassword(password);
        clickSubmit();
    }

    public void fillLoginField(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}