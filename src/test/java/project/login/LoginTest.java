package project.login;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	Logger log;
	LoginPO loginobj;
  @Test(dataProvider = "ALoginData")
  public void loginTest(String userNamen1, String passwordn1,String userName, String password) {
	  log.debug("In loginTest debug");
	  loginobj.loginNegative(userNamen1,passwordn1);
	  loginobj.login(userName, password);
	  log.info("In loginTest info");
  }
  
  @DataProvider (name="ALoginData")
  public Object[][] dataProviderMethod() {
      Object[][] retObjArr=getDataFromXLSUsingJXL("src\\test\\resources\\DDT\\login2.xls",
              "LoginData", "StartAndEnd");
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
	  loginobj=new LoginPO();
	  
	  DOMConfigurator.configure("src/test/resources/log4j-alternate.xml");
		//log = Logger.getLogger(LoginTest.class.getName());
	  
	  log = Logger.getLogger("devpinoyLogger");
	  
	  loginobj.get();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("in after");
  }
  

}
