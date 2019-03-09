package project;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class productName {
	WebDriver driver;
  @Test(dataProvider = "bNTLoginData")
  public void f(String productname1, String productname2, String productname3) {
	  System.out.println("In test");
	  System.out.println("productname1"+productname1);
	  System.out.println("productname2"+productname2);
	  System.out.println("productname3"+productname3);
  }
  
  @DataProvider (name="bNTLoginData")
  public Object[][] dataProviderMethod() {
	  System.out.println("In dataprovider");
      Object[][] retObjArr=getDataFromXLSUsingJXL("src\\test\\resources\\DDT\\product.xls",
              "ProductData", "StartAndEnd");
        return(retObjArr);	  
  }
  
  public String[][] getDataFromXLSUsingJXL(String xlFilePath, String sheetName, String tableName){
      String[][] tabArray=null;
      try{
          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
          //Workbook class is provied by jxl.jar
          //WebDriver provided by Selenium 
          //File is class provided by Java to read a physical file
          Sheet sheet = workbook.getSheet(sheetName);
          Cell tableStart=sheet.findCell(tableName);
          
          int startRow,startCol, endRow, endCol,ci,cj;
          
          startRow=tableStart.getRow();//2
          startCol=tableStart.getColumn();//1

          Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

          endRow=tableEnd.getRow();//6
          endCol=tableEnd.getColumn();//4
          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                  "startCol="+startCol+", endCol="+endCol);
          tabArray=new String[endRow-startRow-1][endCol-startCol-1];//5,4
          ci=0; //array row
          //ci=0,i=3, j=3,cj=1
          for (int i=startRow+1;i<endRow;i++,ci++){//i represents xls row
              cj=0;//array column
              for (int j=startCol+1;j<endCol;j++,cj++){//j represents xls column
                  tabArray[ci][cj]=sheet.getCell(j,i).getContents();
              }
          }
      }
      catch (Exception e)    {
          System.out.println("Please check if file path, sheet name and tag name are correct");
          
      }

      return(tabArray);
  }
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://localhost/Avactis/";
		  driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
