package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login", priority = 1)
    public void checkSuccessfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitlePresent());
    }

    @DataProvider(name = "inc")
    public Object[][] loginData() {
        return new Object[][]{
                {"useruser", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "inc", description = "Wrong login data", priority = 2)
    public void checkIncorrectData(String username, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }
}