package tests;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import parent.BaseTest;
import static org.testng.Assert.*;
import static enums.DepartmentNaming.CARTS;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

/**
 * test description
 */

public class AddGoodsToCartTest extends BaseTest {

    @Step("Checking if items have been added to the cart")
    @Test(description = "Successful add goods to a cart", priority = 1)
    public void checkSuccessfulAddGoodsToCart() {
        System.out.println("Checking AddGoods in thread: " + Thread.currentThread().getName());
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(0);
        productsPage.openToCart();
        assertTrue(cartPage.isPageTitleDisplayed());
        assertEquals(cartPage.getPageTitleText(), CARTS.getDisplayName());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 1);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}