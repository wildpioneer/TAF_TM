package core;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Waits;

public class BrowsersService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;
    private Waits waiters;

    public BrowsersService() {
        switch (ReadProperties.getInstance().getBrowserName().toLowerCase()) {
            case "chrome" -> {
                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ReadProperties.getInstance().isHeadless());
                chromeOptions.addArguments("--disable-gpu");
                //chromeOptions.addArguments("--window-size=1920,1200");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--silent");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
            }
            default -> System.out.println("Browser " + ReadProperties.getInstance().getBrowserName() + " is not supported.");
        }

        waiters = new Waits(driver, ReadProperties.getInstance().getTimeOut());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWaiters() {
        return waiters;
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
