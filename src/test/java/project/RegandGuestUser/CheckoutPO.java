package project.RegandGuestUser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import project.register.RegistrationPO;
import utils.TakeScreenshot;

public class CheckoutPO extends LoadableComponent<RegistrationPO>{
	
	private WebDriver driver;
	TakeScreenshot screenshot=new TakeScreenshot();
	
	@FindBy(xpath="//div[5]/div/div[3]/div/div[2]/div[1]/label/input")
	private WebElement grdShip;
	
	@FindBy(xpath="//div/input[@value='Continue Checkout'][@onclick='submitStep(2);']")
	private WebElement continueCheckout2;
	
	@FindBy(xpath="//*[@id=\"checkout_3\"]/div[7]/table/tbody/tr[2]/td[1]/a")
	private WebElement p1txt;
	
	@FindBy(xpath="//div/input[@value='Place Order']")
	private WebElement btnPlaceOrder;
	
	@FindBy(name="email")
	private WebElement txtEmail;
	
	@FindBy(name="passwd")
	private WebElement txtPass;
	
	@FindBy(xpath="//div//input[@value='Sign In']")
	private WebElement btnSignin;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[2]/td[1]/a")
	private WebElement actTblR1;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[3]/td[1]/a")
	private WebElement actTblR2;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[4]/td[1]/a")
	private WebElement actTblR3;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[2]/td[2]")
	private WebElement actualQtyp11;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[3]/td[2]")
	private WebElement actualQtyp22;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[4]/td[2]")
	private WebElement actualQtyp33;	
	
	@FindBy(xpath="//div[7]/table/tbody/tr[2]/td[3]")
	private WebElement actualPricep11;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[3]/td[3]")
	private WebElement actualPricep22;
	
	@FindBy(xpath="//div[7]/table/tbody/tr[4]/td[3]")
	private WebElement actualPricep33;
	
	@FindBy(xpath="//div/h1[contains(text(),'Thank you for your order!')]")
	private WebElement actualMsgtxt;
	
	String url="http://localhost/Avactis/";
	
	public CheckoutPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		  PageFactory.initElements(this.driver, this);
			get();
	}
	
	
	
  @Test(dataProvider = "NTLoginData")
  public CheckoutPO checkout(String expectedP1,String expectedP2,String expectedP3,String expectedPricep1,String expectedPricep2, String expectedPricep3) {
	  
	  WebDriverWait wait = new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOf(grdShip));
	  grdShip.click();
	  continueCheckout2.click();
	  
	  try {
		Thread.sleep(30);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  //WebTable table = new WebTable(driver.findElement(By.xpath("//*[@id=\"checkout_3\"]/div[7]/table")));
	  wait.until(ExpectedConditions.visibilityOf(actTblR1));
	  String actualP1=actTblR1.getText().toLowerCase().substring(0, 15);
	 // String actualP1=p1txt.getText();
	  String actualP2=actTblR2.getText().toLowerCase();
	 
	  wait.until(ExpectedConditions.visibilityOf(actTblR3));
	  String actualP3=actTblR3.getText().toLowerCase().substring(0, 25);
	  
	  
		
	  System.out.println("actualP3:"+actualP1);
	  System.out.println("expectedP3:"+expectedP1);

	  assertTrue(actualP1.contains(expectedP1.toLowerCase().substring(0, 15)));
	  assertTrue(actualP2.contains(expectedP2.toLowerCase()));
	  assertTrue(actualP3.contains(expectedP3.toLowerCase().substring(0, 25)));
	  
	  String expectedQtyp1="1";
	  String expectedQtyp2="1";
	  String expectedQtyp3="1";
	  
	  String actualQtyp1=actualQtyp11.getText();
	  String actualQtyp2=actualQtyp22.getText();
	  String actualQtyp3=actualQtyp33.getText();
	  
	  assertEquals(actualQtyp1,expectedQtyp1,"Quantity is different");
	  assertEquals(actualQtyp2,expectedQtyp2,"Quantity is different");
	  assertEquals(actualQtyp3,expectedQtyp3,"Quantity is different");
	  
	  String actualPricep1=actualPricep11.getText();
	  String actualPricep2=actualPricep22.getText();
	  String actualPricep3=actualPricep33.getText();
	 
	  assertEquals(actualPricep1,expectedPricep1,"Price is different");
	  assertEquals(actualPricep2,expectedPricep2,"Price is different");
	  assertEquals(actualPricep3,expectedPricep3,"Price is different");
	  
	  btnPlaceOrder.click();
	  
	  String expectedMsg="THANK YOU FOR YOUR ORDER!";
	  wait.until(ExpectedConditions.visibilityOf(actualMsgtxt));
	  String actualMsg=actualMsgtxt.getText();
	  assertEquals(actualMsg,expectedMsg,"error in Order place");
	  
	  try {
			screenshot.takeSnapShot(driver, "c:\\temp\\Checkout_page_success.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
	  driver.quit();
	  return new CheckoutPO(driver);
  }

@Override
protected void load() {
	// TODO Auto-generated method stub
	driver.get(url);
}

@Override
protected void isLoaded() throws Error {
	// TODO Auto-generated method stub
	
}
}
