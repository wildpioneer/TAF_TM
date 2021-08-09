package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;

    @BeforeClass
    public void openPage() {
        browsersService = new BrowsersService();
        browsersService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @AfterClass
    public void closePage() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}