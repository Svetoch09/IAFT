import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class ShareLaneRegister {

    @Test
    public void successRegistration() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--guest");
        WebDriver browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        browser.get("https://www.sharelane.com/cgi-bin/register.py");

        browser.findElement(By.xpath("//*[@name= 'zip_code']")).sendKeys("123456");
        browser.findElement(By.cssSelector("*[value= 'Continue']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name= 'first_name']")));
        browser.findElement(By.xpath("//*[@name= 'first_name']")).sendKeys("Qwerty");
        browser.findElement(By.xpath("//*[@name= 'last_name']")).sendKeys("Poiuyt");
        browser.findElement(By.xpath("//*[@name= 'email']")).sendKeys("examle@mail.com");
        browser.findElement(By.xpath("//*[@name= 'password1']")).sendKeys("xxxqwer123");
        browser.findElement(By.xpath("//*[@name= 'password2']")).sendKeys("xxxqwer123");
        browser.findElement(By.cssSelector("*[value= 'Register']")).click();
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class= 'confirmation_message']")));
        assertTrue(confirmationMessage.isDisplayed(), "Account is created!");
        browser.quit();
    }
}