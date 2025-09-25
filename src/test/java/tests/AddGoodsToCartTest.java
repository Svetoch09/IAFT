package tests;

import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertTrue;

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Successfull add goods to cart", priority = 1)
    public void checkSuccessfullAddGoodsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitlePresent());

        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart(0);
        productsPage.addToCart(3);
        productsPage.addToCart(2);

        loginPage.open("/cart.html");
    }
}

