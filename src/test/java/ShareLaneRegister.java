import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ShareLaneRegister {

    @Test
    public void checkLogin() throws InterruptedException {

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        Thread.sleep(1000);
        browser.findElement(By.xpath("//*[@name= 'zip_code']")).sendKeys("123456");
        Thread.sleep(1000);
        browser.findElement(By.cssSelector("*[value= 'Continue']")).click();
        browser.findElement(By.xpath("//*[@name= 'first_name']")).sendKeys("Qwerty");
        browser.findElement(By.xpath("//*[@name= 'last_name']")).sendKeys("Poiuyt");
        browser.findElement(By.xpath("//*[@name= 'email']")).sendKeys("examle@mail.com");
        browser.findElement(By.xpath("//*[@name= 'password1']")).sendKeys("xxxqwer123");
        browser.findElement(By.xpath("//*[@name= 'password2']")).sendKeys("xxxqwer123");
        browser.findElement(By.cssSelector("*[value= 'Register']")).click();
        browser.quit();
    }
}



