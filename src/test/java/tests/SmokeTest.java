package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SmokeTest extends BaseTest {

    @Test
    public void criticalPathTest() {
        new LoginPage(browsersService, true)
                .setUsername("standard_user")
                .setPassword("secret_sauce")
                .loginBtnClick()
                .addItemToCart("Sauce Labs Backpack")
                .cartBadgeClick()
                .clickCheckoutButton()
                .setFirstNameInput("Name")
                .setLastNameInput("Surname")
                .setZipcodeInput("00001")
                .clickContinueButton();
    }
}
