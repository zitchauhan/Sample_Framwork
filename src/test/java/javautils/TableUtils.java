package javautils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableUtils {
    private WebDriver driver;

    public TableUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get all row elements in a table
    public List<WebElement> getAllRows(WebElement table) {
        return table.findElements(By.tagName("tr"));
    }

    // Method to get all cell elements in a row
    public List<WebElement> getAllCells(WebElement row) {
        return row.findElements(By.tagName("td"));
    }

    // Method to get the text of all cells in a specific row
    public List<String> getRowData(WebElement row) {
        List<WebElement> cells = getAllCells(row);
        List<String> cellData = new ArrayList<>();
        for (WebElement cell : cells) {
            cellData.add(cell.getText());
        }
        return cellData;
    }

    // Method to get data from a specific cell
    public String getCellData(WebElement table, int rowIndex, int colIndex) {
        List<WebElement> rows = getAllRows(table);
        if (rowIndex >= rows.size()) {
            throw new IndexOutOfBoundsException("Row index out of bounds");
        }
        List<WebElement> cells = getAllCells(rows.get(rowIndex));
        if (colIndex >= cells.size()) {
            throw new IndexOutOfBoundsException("Column index out of bounds");
        }
        return cells.get(colIndex).getText();
    }

    // Method to click on a cell in the table
    public void clickCell(WebElement table, int rowIndex, int colIndex) {
        List<WebElement> rows = getAllRows(table);
        if (rowIndex >= rows.size()) {
            throw new IndexOutOfBoundsException("Row index out of bounds");
        }
        List<WebElement> cells = getAllCells(rows.get(rowIndex));
        if (colIndex >= cells.size()) {
            throw new IndexOutOfBoundsException("Column index out of bounds");
        }
        cells.get(colIndex).click();
    }

    // Method to find a row based on the text in a specific cell
    public WebElement findRowByCellText(WebElement table, int colIndex, String text) {
        List<WebElement> rows = getAllRows(table);
        for (WebElement row : rows) {
            List<WebElement> cells = getAllCells(row);
            if (colIndex < cells.size() && cells.get(colIndex).getText().equals(text)) {
                return row;
            }
        }
        return null; // or throw an exception if not found
    }
}
