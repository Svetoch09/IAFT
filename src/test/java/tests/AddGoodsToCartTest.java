package tests;

import org.testng.annotations.Test;
import parent.BaseTest;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static user.UserFactory.*;

/**
 * test description */

public class AddGoodsToCartTest extends BaseTest {

    @Test(description = "Successfull add goods to cart", priority = 1)
    public void checkSuccessfullAddGoodsToCart() {
        System.out.println("Checking AddGoods in thread: " + Thread.currentThread().getName());
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(0);
        productsPage.openToCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}