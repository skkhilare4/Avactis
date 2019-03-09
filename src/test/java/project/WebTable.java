package project;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.By;

import java.util.List;
public class WebTable {
	protected WebElement webTable;
    //WebTable table = new WebTable(driver.findElement(By.id("users"))
	//Select make = new Select(driver.findElement(By.id("make"))
	public WebTable(WebElement webTable) {
		  String tagName = webTable.getTagName();

		    if (null == tagName || !"table".equals(tagName.toLowerCase())) {
		      throw new UnexpectedTagNameException("table", tagName);
		    }

		    this.webTable = webTable;

		
		//this.webTable = webTable;
	//	this.webTable = webTable.findElement(By.tagName("tbody"));
	}

	public WebElement get_webTable() {
		return webTable;
	}

	public void set_webTable(WebElement webTable) {
		this.webTable = webTable;
	}
	
	public List<WebElement> getAllDataRows() {		
		return webTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));		
	}

	public int getRowCount() {
	    List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
	    return tableRows.size();
	}
	
	public int getDataRowCount() {
	    WebElement tbody = webTable.findElement(By.tagName("tbody"));
	    List<WebElement> dataRows = tbody.findElements(By.tagName("tr"));
	    return dataRows.size();
	}
	
	public int getColumnCount() {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement headerRow = tableRows.get(0);
		List<WebElement> tableCols = headerRow.findElements(By.tagName("td"));
		return tableCols.size();
	}
	
	
	//table.getCellData(2,2)
	public String getCellData(int rowIdx, int colIdx) {
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		WebElement currentRow = tableRows.get(rowIdx-1);
		List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
		WebElement cell = tableCols.get(colIdx-1);
		return cell.getText();		
	}
	//getCellEditor(3,3,1)
	public WebElement getCellEditor(int rowIdx, int colIdx, int editorIdx) throws NoSuchElementException {
		try {
			
			List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
			WebElement currentRow = tableRows.get(rowIdx-1);
			List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
			WebElement cell = tableCols.get(colIdx-1);
			WebElement cellEditor = cell.findElements(By.tagName("input")).get(editorIdx-1);
			return cellEditor;
			
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Failed to get cell editor");
		}
	}
	
	public boolean searchInColumn(String columnHeader, String searchString) {
		
		return true;
	}
	//deleteRow("Built", "2004")
	public boolean deleteRow(String columnHeader, String searchString) {
		List<WebElement> allRows = webTable.findElements(By.tagName("tr"));
		WebElement headerRow = allRows.get(0);
		List<WebElement> allHeaderColumns = headerRow.findElements(By.tagName("th"));
		int i = 0;
		int targetColumn = 0;
		for (WebElement oneHeaderCol : allHeaderColumns) {
			i++;
			if (oneHeaderCol.getText().contains(columnHeader)) {
				targetColumn = i;
			    break;
			}
		}
		
		for (WebElement Onerow: allRows) {
			
			
		}
		
		
		return true;
	}
	
	//clickOnDelete("User Name", "John")
/*	public WebElement clickOnDelete(String columnHeaderName, String toSearch) {
		return 
	}
*/

}
