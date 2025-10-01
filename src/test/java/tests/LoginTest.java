package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parent.BaseTest;
import utils.PropertyReader;
import user.User;

import static org.testng.Assert.*;
import static user.UserFactory.*;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login", priority = 1)
    public void checkSuccessfulLogin() {
        System.out.println("Checking Successful Login in thread: " + Thread.currentThread().getName());
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isTitlePresent());
    }

    @DataProvider(name = "inc")
    public Object[][] loginData() {
        String invalidMsg = PropertyReader.getProperty("invalid.error.msg");
        String lockedMsg = PropertyReader.getProperty("locked.error.msg");
        String emptyPassMsg = PropertyReader.getProperty("empty_password.error.msg");

        User invalidUser = withInvalidUserPermission();
        User lockedUser = withLockedUserPermission();
        User emptyPassUser = withUserEmptyPasswordPermission();

        return new Object[][]{
                {invalidUser, invalidMsg},
                {lockedUser, lockedMsg},
                {emptyPassUser, emptyPassMsg}
        };
    }

    @Test(dataProvider = "inc", description = "Wrong login data", priority = 2)
    public void checkIncorrectData(User user, String errorMessage) {
        System.out.println("Checking unsuccessful Login in thread: " + Thread.currentThread().getName());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }
}