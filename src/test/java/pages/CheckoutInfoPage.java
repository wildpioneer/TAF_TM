package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CheckoutInfoPage extends BasePage {
    private final static String endpoint = "checkout-step-one.html";

    private final static By checkout_Title_Label_By = By.xpath("//div/span[@class ='title']");
    private final static By checkout_First_Name_By = By.id("first-name");
    private final static By checkout_Last_Name_By = By.id("last-name");
    private final static By checkout_ZipCode_By = By.id("postal-code");
    private final static By checkout_Continue_Button_By = By.id("continue");
    private final static By checkout_Error_Button_By = By.className("error-message-container");

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL()+endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTitleMessage().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public CheckoutInfoPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    public WebElement getTitleMessage() {
        return new UIElement(browsersService, checkout_Title_Label_By);
    }

    public WebElement getFirstName() {
        return new UIElement(browsersService, checkout_First_Name_By);
    }

    public WebElement getLastName() {
        return new UIElement(browsersService, checkout_Last_Name_By);
    }

    public WebElement getZipcode() {
        return new UIElement(browsersService, checkout_ZipCode_By);
    }

    public WebElement getContinueButton() {
        return new UIElement(browsersService, checkout_Continue_Button_By);
    }

    public WebElement getErrorButton(){
        return new UIElement(browsersService, checkout_Error_Button_By);
    }

    //atomic methods
    public CheckoutInfoPage setFirstNameInput(String firstNameInput) {
        getFirstName().sendKeys(firstNameInput);
        return this;
    }

    public CheckoutInfoPage setLastNameInput(String lastNameInput) {
        getLastName().sendKeys(lastNameInput);
        return this;
    }

    public CheckoutInfoPage setZipcodeInput(String zipcodeInput) {
        getZipcode().sendKeys(zipcodeInput);
        return this;
    }

    public CheckoutOverviewPage clickContinueButton() {
        getContinueButton().click();
        return new CheckoutOverviewPage(browsersService, false);
    }

    public String displayErrorButtonMessage(){
        return  getErrorButton().getText();
    }
}