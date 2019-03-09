package project.RegandGuestUser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import project.register.RegistrationPO;
import utils.TakeScreenshot;

public class RegisteredUserShoppingPO extends LoadableComponent<RegistrationPO> {
	
	private WebDriver driver;
	TakeScreenshot screenshot=new TakeScreenshot();
	
	@FindBy(xpath="//li/a[contains(text(),'Apparel')]")
	private WebElement lnkApparel;
	
	//@FindBy(xpath="//div/h3[contains(text(),'Custom T-Shirt (Upload your ...')]")
	//@FindBy(xpath="//div/h3[contains(text(),xlprodctnm1)]")
	private WebElement product1nm;
	
	@FindBy(xpath="//div/Strong[@class='product_sale_price']")
	private WebElement p1Price;
	
	@FindBy(xpath="//input[@value='Add To Cart']")
	private WebElement btnAddtocartp1;
	
	@FindBy(xpath="//ul/li/a[contains(text(),'Furniture')]")
	private WebElement lnkFurniture;
	
	//@FindBy(xpath="//div/h3[contains(text(),'ARILD Chair')]")
	//@FindBy(xpath="//div/h3[contains(text(),xlprodctnm2)]")
	private WebElement product2nm;
	
	@FindBy(xpath="//div/Strong[@class='product_sale_price']")
	private WebElement p2Price;
	
	@FindBy(xpath="//div/input[@value='Add To Cart']")
	private WebElement btnAddtocartp2;
	/*
	@FindBy(xpath="//li/a[contains(text(),'Apparel')]")
	private WebElement lnkApparel2;
	*/
	@FindBy(xpath="//li/a[contains(text(),'DVD')]")
	private WebElement lnkDVD;
	
	@FindBy(xpath="//div/h3/a[contains(text(),'Classic Films')]")
	private WebElement lnkCF;
	
	
	//@FindBy(xpath="//div/h3[contains(text(),'Avactis T-Shirt')]")
	//@FindBy(xpath="//div/h3[contains(text(),xlprodctnm3)]")
	private WebElement product3nm;
	
	@FindBy(xpath="//div/Strong[@class='product_sale_price']")
	private WebElement p3Price;
	
	@FindBy(xpath="//div/input[@value='Add To Cart']")
	private WebElement btnAddtocartp3;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart']")
	private WebElement goTocart;
	
	@FindBy(xpath="//div/a[contains(text(),'Checkout')]")
	private WebElement btnCheckout;
	
	@FindBy(linkText="Sign In")
	private WebElement signIn;
	
	@FindBy(xpath="//input[@value='Continue Checkout']")
	private WebElement continueCheckout;
	
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

	
	
	public RegisteredUserShoppingPO() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@Test(dataProvider = "NTLoginData")
	  public SignInPO RegisteredUserShopping(String productname1, String productname2, String productname3) {
		  
		
		  lnkApparel.click();
		  product1nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname1)]"));
		  //String expectedP1=product1nm.getText().toLowerCase().substring(0, 13);
		    System.out.println(productname1);
		  product1nm.click();
		 // expectedPricep1=p1Price.getText();
		  btnAddtocartp1.click();
		  
		  lnkFurniture.click();
		  product2nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname2)]"));
		  System.out.println(productname2);
		  product2nm.click();
		  //expectedPricep2=p2Price.getText();
		  btnAddtocartp2.click();
		  
		  lnkDVD.click();
		  lnkCF.click();
		 // String expectedP3=product3nm.getText().toLowerCase();
		  product3nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname3)]"));
		  System.out.println(productname3);
		  product3nm.click();
		  //expectedPricep3=p3Price.getText();
		  btnAddtocartp3.click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(goTocart));
		  goTocart.click();
		  wait.until(ExpectedConditions.visibilityOf(btnCheckout));
		  btnCheckout.click();
		  
		  return new SignInPO(driver);
			
		  
	  }
	
	@Test(dataProvider = "NTLoginData")
	  public GuestDetailsPO RegisteredUserShopping1(String productname1, String productname2, String productname3) {
		  
		
		  lnkApparel.click();
		  product1nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname1)]"));
		  //String expectedP1=product1nm.getText().toLowerCase().substring(0, 13);
		    System.out.println(productname1);
		  product1nm.click();
		 // expectedPricep1=p1Price.getText();
		  btnAddtocartp1.click();
		  
		  lnkFurniture.click();
		  product2nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname2)]"));
		  System.out.println(productname2);
		  //String expectedP2=product2nm.getText().toLowerCase();
		  product2nm.click();
		  //expectedPricep2=p2Price.getText();
		  btnAddtocartp2.click();
		  
		  lnkDVD.click();
		  lnkCF.click();
		 // String expectedP3=product3nm.getText().toLowerCase();
		  product3nm=driver.findElement(By.xpath("//div/h3[contains(text(),productname3)]"));
		  System.out.println(productname3);
		  product3nm.click();
		  //expectedPricep3=p3Price.getText();
		  btnAddtocartp3.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(goTocart));
		  goTocart.click();
		  wait.until(ExpectedConditions.visibilityOf(btnCheckout));
		  btnCheckout.click();
		  
		  try {
				screenshot.takeSnapShot(driver, "c:\\temp\\Checkout_page_success.png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  
		  return new GuestDetailsPO(driver);
			
		  
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
