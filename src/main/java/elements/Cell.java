package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cell {
    private UIElement uiElement;

    public Cell(BrowsersService browsersService, By by) {
        uiElement = new UIElement(browsersService, by);
    }

    public Cell(BrowsersService browsersService, WebElement webElement) {
        uiElement = new UIElement(browsersService, webElement);
    }

    public UIElement getUIElement() {
        return uiElement;
    }
}
