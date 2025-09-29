package tests;

import org.testng.annotations.Test;
import parent.BaseTest;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * test description */

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Successfull add goods to cart", priority = 1)
    public void checkSuccessfullAddGoodsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart(0);
        productsPage.addToCart(2);
        //productsPage.openCart();
        loginPage.open("/cart.html");
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Onesie"));
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Fleece Jacket"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
        System.out.println(cartPage.getProductsNames());
    }
}