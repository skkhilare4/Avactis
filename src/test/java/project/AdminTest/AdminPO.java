package project.AdminTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utils.TakeScreenshot;


public class AdminPO extends LoadableComponent<AdminPO>{
	private WebDriver driver;
	TakeScreenshot screenshot=new TakeScreenshot();
	
	@FindBy(name="AdminEmail")
	private WebElement adminEmail;
	
	@FindBy(name="Password")
	private WebElement password;
	
	@FindBy(xpath="//div/button[contains(text(),'Sign In')]")
	private WebElement signinBtn;
	
	@FindBy(xpath="//a/span[contains(text(),'Orders')]")
	private WebElement orders;
	
	@FindBy(xpath="//td/a[contains(text(),'00002')]")
	private WebElement orderno;
	
	@FindBy(tagName="iframe")
	private WebElement iframe;
	
	@FindBy(xpath="//h4/a[contains(text(),'Product(s) Ordered')]")
	private WebElement productOrdered;
	
	@FindBy(xpath="//tr/td[contains(text(),'Custom T-Shirt (Upload your own design!)')]")
	private WebElement prodnm1;
	
	@FindBy(xpath="//tr/td[contains(text(),'ARILD Chair')]")
	private WebElement prodnm2;
	
	@FindBy(xpath="//tr/td[contains(text(),'Classic Musicals from the Dream Factory, Vol. 3')]")
	private WebElement prodnm3;
	
	String url="http://localhost/avactis/avactis-system/admin/signin.php";
	
		public AdminPO() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}
	
		public AdminPO(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
			  PageFactory.initElements(this.driver, this);
				get();
		}
		
  @Test(dataProvider = "cNTLoginData")
  public AdminPO adminPage(String expectedP1,String expectedP2,String expectedP3) {
	  System.out.println(expectedP1);
	  System.out.println(expectedP2);
	  System.out.println(expectedP3);
	  adminEmail.sendKeys("sheetal_karande@yahoo.com");
	  password.sendKeys("satara@1234");
	  signinBtn.click();
	  orders.click();
	  orderno.click();
	  
	  WebDriverWait wait= new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOf(iframe));
	  try {
	 driver.switchTo().frame(iframe);
	  }
	  catch(NoSuchFrameException e) {
		  e.printStackTrace();		  
	  }
	//WebDriverWait wait=new WebDriverWait(driver,30);
	//wait.until(ExpectedConditions.visibilityOf(productOrdered));
	  productOrdered.click();
	  
	  try {
	  String actualp1=prodnm1.getText().toLowerCase().substring(0, 15);
	  String actualp2=prodnm2.getText().toLowerCase();
	  String actualp3=prodnm3.getText().toLowerCase().substring(0, 25);
	  	  
	  assertEquals(actualp1,expectedP1.toLowerCase().substring(0, 15),"Product is different");
	  assertEquals(actualp2,expectedP2.toLowerCase(),"Product is different");
	  assertEquals(actualp3,expectedP3.toLowerCase().substring(0, 25),"Product is different");
	  }
	  catch(AssertionError e) {
		  String actualp1=prodnm1.getText().toLowerCase().substring(0, 15);
		  String actualp2=prodnm2.getText().toLowerCase();
		  String actualp3=prodnm3.getText().toLowerCase().substring(0, 25);
		  	  
		  assertEquals(actualp1,expectedP1.toLowerCase().substring(0, 15),"Product is different");
		  assertEquals(actualp2,expectedP2.toLowerCase(),"Product is different");
		  assertEquals(actualp3,expectedP3.toLowerCase().substring(0, 25),"Product is different");  
	  }
	  
	  try {
			screenshot.takeSnapShot(driver, "c:\\temp\\AdminCheck_page_success.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  return new AdminPO(driver);
	  
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
