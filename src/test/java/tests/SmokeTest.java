package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletionPage;
import pages.LoginPage;
import pages.ShoppingCartPage;

public class SmokeTest extends BaseTest {

    @Test
    public void criticalPathTest() {
        CheckoutCompletionPage completionPage = new LoginPage(browsersService, true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginBtnClick()
                .addItemToCart("Sauce Labs Backpack")
                .cartBadgeClick()
                .clickCheckoutButton()
                .setFirstNameInput("Name")
                .setLastNameInput("Surname")
                .setZipcodeInput("00001")
                .clickContinueButton()
                .clickFinishButton();

        Assert.assertEquals(completionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void loginFailedTest() {
        LoginPage loginPage = new LoginPage(browsersService, true)
                .setUsername(incorrectUser.getUsername())
                .setPassword(incorrectUser.getPassword())
                .loginBtnClick();

        Assert.assertEquals(loginPage.getErrorMessage().getText().trim(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void removeItemFromCartTest() {
        ShoppingCartPage shoppingCartPage = new LoginPage(browsersService, true)
                .setUsername(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginBtnClick()
                .addItemToCart("Sauce Labs Backpack")
                .addItemToCart("Sauce Labs Bolt T-Shirt")
                .cartBadgeClick()
                .clickRemoveButton("Sauce Labs Bolt T-Shirt");

        Assert.assertEquals(shoppingCartPage.getItemsCount(), 1);
    }
}
