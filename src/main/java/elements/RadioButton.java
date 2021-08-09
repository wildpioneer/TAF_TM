package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<UIElement> options = new ArrayList<>();

    /***
     * RadioButton ui element для улучшения работы
     * @param browsersService обертка браузера
     * @param by необходимо передать значение аттрибута name
     */
    public RadioButton(BrowsersService browsersService, By by) {
        for (WebElement element: browsersService.getDriver().findElements(by)) {
            options.add(new UIElement(browsersService, element));
        }
    }

    public void selectByIndex(int index) {
        for (UIElement element : options) {
            if (Integer.parseInt(element.getAttribute("value")) == index) {
                element.click();
                break;
            }
        }
    }

    public void selectByText(String optionName) {
        for (UIElement element : options) {
            String textValue = element.getParent().findElement(By.tagName("strong")).getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }
}
