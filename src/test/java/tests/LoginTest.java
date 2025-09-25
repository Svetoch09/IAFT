package tests;

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

    @Test(description = "Wrong username error", priority = 2)
    public void checkUserNameError() {
        loginPage.open();
        loginPage.login("useruser", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service",
                "Error is not correct");
    }

    @Test(description = "Locked out user error", priority = 4)
    public void checkUserLockedOutError() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.",
                "Error is not correct");
    }

    @Test(description = "No password error", priority = 3)
    public void checkNoPasswordError() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Password is required",
                "Error is not correct");
    }
}