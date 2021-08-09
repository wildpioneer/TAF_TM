package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutCompletionPage extends BasePage {
    private final static String endpoint = "checkout-complete.html";

    private final static By checkout_Completion_By = By.className("complete-header");

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getCompletionTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public CheckoutCompletionPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    public WebElement getCompletionTitle() {
        return browsersService.getDriver().findElement(checkout_Completion_By);
    }

    //atomic methods
    public String getCompletionMessage() {
        return getCompletionTitle().getText();
    }
}