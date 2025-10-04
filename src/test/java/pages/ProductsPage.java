package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final By PRODUCTS_TITLE_SPECIFIC = By.xpath("//*[text()='Products']");
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Add to cart']");
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final By TO_CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    @Step("Add goods'{goodsName}' to the cart using its name")
    public void addToCart(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Add goods to the cart by index {goodsIndex}")
    public void addToCart(int goodsIndex) {
        driver.findElements(ADD_TO_CART_BUTTON).get(goodsIndex).click();
    }

    @Step("Open the shopping cart")
    public void openToCart() {
        driver.findElement(TO_CART_BUTTON).click();
    }
}