package javautils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HtmlTableUtils {
    private WebDriver driver;

    public HtmlTableUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Get the number of rows in a table (excluding header)
    public int getRowCount(WebElement table) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size() - 1;  // Subtracting 1 to exclude the header row
    }

    // Get the number of columns in a table
    public int getColumnCount(WebElement table) {
        WebElement headerRow = table.findElement(By.tagName("tr"));
        List<WebElement> columns = headerRow.findElements(By.tagName("th"));
        return columns.size();
    }

    // Get a specific cell (row and column are 0-indexed)
    public WebElement getCell(WebElement table, int row, int column) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement specificRow = rows.get(row + 1);  // +1 to skip the header row
        List<WebElement> cells = specificRow.findElements(By.tagName("td"));
        return cells.get(column);
    }

    // Get the text from a specific cell
    public String getCellText(WebElement table, int row, int column) {
        WebElement cell = getCell(table, row, column);
        return cell.getText();
    }

    // Get all data from the table as a list of lists
    public List<List<String>> getTableData(WebElement table) {
        List<List<String>> tableData = new ArrayList<>();
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {  // Start from 1 to skip header row
            List<String> rowData = new ArrayList<>();
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                rowData.add(cell.getText());
            }

            tableData.add(rowData);
        }

        return tableData;
    }

    // Get data from a specific column
    public List<String> getColumnData(WebElement table, int column) {
        List<String> columnData = new ArrayList<>();
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {  // Start from 1 to skip header row
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            columnData.add(cells.get(column).getText());
        }

        return columnData;
    }

    // Get data from a specific row
    public List<String> getRowData(WebElement table, int row) {
        List<String> rowData = new ArrayList<>();
        WebElement specificRow = table.findElements(By.tagName("tr")).get(row + 1);  // +1 to skip the header row
        List<WebElement> cells = specificRow.findElements(By.tagName("td"));

        for (WebElement cell : cells) {
            rowData.add(cell.getText());
        }

        return rowData;
    }

    // Find a cell by its text content and return the cell element
    public WebElement findCellByText(WebElement table, String searchText) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {  // Start from 1 to skip header row
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                if (cell.getText().equalsIgnoreCase(searchText)) {
                    return cell;
                }
            }
        }

        return null;  // Return null if no cell with the given text is found
    }

    // Click on a specific cell based on row and column
    public void clickCell(WebElement table, int row, int column) {
        WebElement cell = getCell(table, row, column);
        cell.click();
    }
}
