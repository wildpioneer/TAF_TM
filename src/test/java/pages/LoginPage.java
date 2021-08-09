package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import elements.UIElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final static String ENDPOINT = "/";

    private final static By usernameSelector = By.id("user-name");
    private final static By passwordSelector = By.id("password");
    private final static By loginBtnSelector = By.id("login-button");
    private final static By errorMessageSelector = By.cssSelector(".error-message-container.error h3");

    public LoginPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return new UIElement(browsersService, loginBtnSelector).isDisplayed();
    }

    public UIElement getUsernameField() {
        return new UIElement(browsersService, usernameSelector);
    }

    public UIElement getPasswordField() {
        return new UIElement(browsersService, passwordSelector);
    }

    public UIElement getLoginButton() {
        return new UIElement(browsersService, loginBtnSelector);
    }

    public UIElement getErrorMessage() {
        return new UIElement(browsersService, errorMessageSelector);
    }

    // Atomic Methods
    public ProductsPage successLoginBtnClick() {
        loginBtnClick();
        return new ProductsPage(browsersService, false);
    }

    public LoginPage loginBtnClick() {
        getLoginButton().click();
        return this;
    }

    public LoginPage setUsername(String username) {
        getUsernameField().sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }
}
