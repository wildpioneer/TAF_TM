package elements;

import core.BrowsersService;
import org.openqa.selenium.By;

public class Checkbox {
    private final UIElement element;

    public Checkbox(BrowsersService browsersService, By by) {
        this.element = new UIElement(browsersService, by);
    }

    public void click() {
        this.element.click();
    }

    public boolean isSelected() {
        return this.element.isSelected();
    }

    public void changeState(boolean makeSelected) {
        if (this.isSelected() != makeSelected) this.click();
    }
}
