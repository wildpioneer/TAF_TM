package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableRow {
    private UIElement uiElement;
    private List<Cell> cellList = new ArrayList<>();

    public TableRow(BrowsersService browsersService, By by) {
        this.uiElement = new UIElement(browsersService, by);

        for (WebElement element : this.uiElement.findElements(By.tagName("td"))) {
            cellList.add(new Cell(browsersService, element));
        }
    }

    public TableRow(BrowsersService browsersService, WebElement webElement) {
        this.uiElement = new UIElement(browsersService, webElement);

        for (WebElement element : this.uiElement.findElements(By.tagName("td"))) {
            cellList.add(new Cell(browsersService, element));
        }
    }

    public int getCellsCount() {
        return cellList.size();
    }

    public Cell getCellByIndex(int columnIndex) {
        return cellList.get(columnIndex);
    }
}
