package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private List<TableRow> rowList = new ArrayList<>();
    private List<String> columnList = new ArrayList<>();

    /***
     * Универсальный GUI element таблицы
     * @param browsersService
     * @param by основывается на тэге table
     */
    public Table(BrowsersService browsersService, By by) {
        this.uiElement = new UIElement(browsersService, by);

        for (WebElement element: this.uiElement.findElements(By.xpath("//tr[@class = 'header']/th"))) {
            columnList.add(element.getText());
        }

        for (WebElement element: this.uiElement.findElements(By.xpath("//tr[@class !='header']"))) {
            rowList.add(new TableRow(browsersService, element));
        }
    }

    public int rowsCount() {
        return rowList.size();
    }

    public UIElement getElementFromCell(int rowIndex, int columnIndex) {
        return rowList.get(rowIndex).getCellByIndex(columnIndex).getUIElement();
    }

    public UIElement getElementFromCell(String expectedText, int expectedColumn, int columnIndex) {
        for (TableRow row : rowList) {
            if (row.getCellByIndex(expectedColumn).getUIElement().getText().equalsIgnoreCase(expectedText)) {
                return row.getCellByIndex(columnIndex).getUIElement();
            }
        }
        return null;
    }

    public UIElement getElementFromCell(String expectedText, int expectedColumn, String columnName) {
        return getElementFromCell(expectedText, expectedColumn, columnList.indexOf(columnName));
    }
}
