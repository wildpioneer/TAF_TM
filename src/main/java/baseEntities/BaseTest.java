package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import models.User;
import org.testng.annotations.*;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    protected User correctUser;
    protected User incorrectUser;

    @BeforeSuite
    public void prepareData() {
        correctUser = User.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();

        incorrectUser = User.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();
    }

    @BeforeMethod
    public void openPage() {
        browsersService = new BrowsersService();
        browsersService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @AfterMethod
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}