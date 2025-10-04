package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    @Step("Oppening a browser")
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String url) {
        driver.get(BASE_URL + url);
    }

    @Step("Log in with credentials Username={user.username}, Password= ********")
    public void login(User user) {
        fillLoginField(user.getUsername());
        fillPassword(user.getPassword());
        clickSubmit();
    }

    @Step("Input: username")
    public void fillLoginField(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    @Step("Input: user password")
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Pressing 'Login' button")
    public void clickSubmit() {
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Validating the error message")
    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}