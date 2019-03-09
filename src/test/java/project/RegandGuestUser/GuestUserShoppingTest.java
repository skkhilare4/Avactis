package project.RegandGuestUser;

import org.testng.annotations.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.io.File;
import org.testng.annotations.AfterMethod;

public class GuestUserShoppingTest {
	RegisteredUserShoppingPO regshop;
	GuestDetailsPO guestobj;
	CheckoutPO checkoutobj;
  @Test(dataProvider = "NTLoginData")
  public void guest(String ep1,String ep2,String ep3,String epr1,String epr2,String epr3) {
	  	  guestobj=regshop.RegisteredUserShopping1(ep1, ep2, ep3);
		  checkoutobj=guestobj.guestDetails();
		  checkoutobj.checkout(ep1, ep2, ep3,epr1,epr2,epr3);
	  
  }
  
  @DataProvider (name="NTLoginData")
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
	  regshop=new RegisteredUserShoppingPO();
	  regshop.load();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
