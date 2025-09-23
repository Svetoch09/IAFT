package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import parent.BaseTest;

import java.time.Duration;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
        assertTrue(productsHeader.isDisplayed(), "Вход не выполнен");
    }

    @Test
    public void testUserError() {
        loginPage.open();
        loginPage.login("useruser", "secret_sauce");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(errorElement.getText(), expectedError, "Текст ошибки неверный.");
    }
}