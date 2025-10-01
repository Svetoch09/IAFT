package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    final By title = By.xpath("//*[@data-test='title']");
    final By title2 = By.xpath("//*[text()='Products']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Add to cart']");
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By TO_CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean isTitlePresent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
    }

    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int goodsIndex) {

        driver.findElements(ADD_TO_CART_BUTTON).get(goodsIndex).click();
    }

    public void openToCart() {

        driver.findElement(TO_CART_BUTTON).click();
    }
}