package project.register;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import utils.TakeScreenshot;


public class RegistrationPO extends LoadableComponent<RegistrationPO> {
	
private WebDriver driver;
TakeScreenshot screenshot=new TakeScreenshot();
RegistrationData regData=new RegistrationData();
	
	private String pageTitle = "Avactis Demo Store";

@FindBy (linkText = "My Account")
private WebElement myAccount;	


@FindBy (xpath ="//button[contains(text(),'Register')]")
private WebElement btnRegister;

@FindBy (name ="customer_info[Customer][Email]")
private WebElement txtEmail;

@FindBy (name ="customer_info[Customer][Password]")
private WebElement txtPassword;

@FindBy (name ="customer_info[Customer][RePassword]")
private WebElement txtrePassword;

@FindBy (name ="customer_info[Customer][FirstName]")
private WebElement txtfName;

@FindBy (name ="customer_info[Customer][LastName]")
private WebElement txtlName;

@FindBy (name ="customer_info[Customer][Country]")
private WebElement comboCountry;

@FindBy (name ="customer_info[Customer][State]")
private WebElement comboState;

@FindBy (name ="customer_info[Customer][ZipCode]")
private WebElement txtzip;

@FindBy (name ="customer_info[Customer][City]")
private WebElement txtCity;

@FindBy (name ="customer_info[Customer][Streetline1]")
private WebElement txtAddrl1;

@FindBy (name ="customer_info[Customer][Streetline2]")
private WebElement txtAddrl2;

@FindBy (name ="customer_info[Customer][Phone]")
private WebElement txtContactno;

@FindBy (xpath ="//input[@type='submit']")
private WebElement btnRegister1;

@FindBy (xpath ="//div[contains(text(),'Account created successfully. You are now registered.')]")
private WebElement registerSuccessmsg;

@FindBy (xpath ="//div[contains(text(),'The password you entered is incorrect. Please enter the correct password.')]")
private WebElement registerSuccessmsgn1;

@FindBy (xpath ="//div[contains(text(),\"Invalid data in field 'E-mail'.\")]")
private WebElement registerSuccessmsgn2;

String url = "http://localhost/Avactis/";
	

  public RegistrationPO(String browser) {
	 // System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		//driver = new ChromeDriver();
	 
	  try {
	  		if (browser.equalsIgnoreCase("Firefox")) {
	  			System.setProperty("webdriver.gecko.driver",
	  					"C:\\SeleniumTraining\\Workspace\\avactistest\\src\\test\\resources\\geckodriver-64bit.exe");
	  			driver = new FirefoxDriver();
	  			PageFactory.initElements(driver, this);
	  		} else if (browser.equalsIgnoreCase("chrome")) {
	  			System.setProperty("webdriver.chrome.driver",
	  					"C:\\SeleniumTraining\\Workspace\\avactistest\\src\\test\\resources\\chromedriver.exe");
	  			driver = new ChromeDriver();
	  			PageFactory.initElements(driver, this);
	  		} else if (browser.equalsIgnoreCase("IE")) {
	  			System.setProperty("webdriver.ie.driver",
	  					"C:\\SeleniumTraining\\Workspace\\avactistest\\src\\test\\resources\\IEDriverServer.exe");
	  			driver = new InternetExplorerDriver();
	  			PageFactory.initElements(driver, this);
	  		}
	  	
	  	} catch (WebDriverException e) {
	  		System.out.println(e.getMessage());
	  	}
	  
		//PageFactory.initElements(driver, this);		
  }
/*

public RegistrationPO() {
	 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	 driver = new ChromeDriver();
	 PageFactory.initElements(driver, this);		
	  }
	*/
public RegistrationPO register() {
	  System.out.println("in po");
	 /* myAccount.click();
	  
	  try {
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  WebElement element = wait.until(
              ExpectedConditions.visibilityOf(btnRegister));

	  element.click();
	  }
	  catch(ElementNotVisibleException e) {
		  e.printStackTrace();
	  }
	  */
	  regData.setEmail("abc8@gmail.com");
	  txtEmail.sendKeys(regData.getEmail());
	  regData.setPassword("test8@123");
	  txtPassword.sendKeys(regData.getPassword());
	  regData.setRePassword("test8@123");
	  txtrePassword.sendKeys(regData.getRePassword());
	  regData.setFname("sheetal8");
	  txtfName.sendKeys(regData.getFname());
	  regData.setLname("karande8");
	  txtlName.sendKeys(regData.getLname());
	  
	  Select select=new Select(comboCountry);
	  select.selectByVisibleText(regData.getCountry());
	  
	  select=new Select(comboState);
	  select.selectByVisibleText(regData.getState());
	  
	  regData.setZip("411015");
	  txtzip.sendKeys(regData.getZip());
	  regData.setCity("Pune");
	  txtCity.sendKeys(regData.getCity());
	  regData.setAddl1("MG Road");
	  txtAddrl1.sendKeys(regData.getAddl1());
	  regData.setAddl2("Flat no15");
	  txtAddrl2.sendKeys(regData.getAddl2());
	  regData.setContact("1234567895");
	  txtContactno.sendKeys(regData.getContact());
	  btnRegister1.click();
	  
	  try {
	  String expectedmsg="Account created successfully. You are now registered.";
	  String actualmsg=registerSuccessmsg.getText();
	  assertEquals(actualmsg,expectedmsg,"Registration failed");
	  }
	  catch(AssertionError e) {
		  String expectedmsg="Account created successfully. You are now registered.";
		  String actualmsg=registerSuccessmsg.getText();
		  assertEquals(actualmsg,expectedmsg,"Registration failed");
	  }
	  
	  try {
			screenshot.takeSnapShot(driver, "c:\\temp\\registration_page_success.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  	  
	//return new RegistrationPO(driver);
	  return null;
	  
  }

public RegistrationPO negativeTestregister() {
	
	System.out.println("in po");
	  myAccount.click();
	  
	  try {
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  WebElement element = wait.until(
            ExpectedConditions.visibilityOf(btnRegister));

	  element.click();
	  }
	  catch(ElementNotVisibleException e) {
		  e.printStackTrace();
	  }
	  
	  regData.setEmail("asdfg");
	  txtEmail.sendKeys(regData.getEmail());
	  regData.setPassword("123");
	  txtPassword.sendKeys(regData.getPassword());
	  regData.setRePassword("456");
	  txtrePassword.sendKeys(regData.getRePassword());
	  regData.setFname("123");
	  txtfName.sendKeys(regData.getFname());
	  regData.setLname("456");
	  txtlName.sendKeys(regData.getLname());
	  regData.setZip("zip");
	  txtzip.sendKeys(regData.getZip());
	  regData.setCity("city");
	  txtCity.sendKeys(regData.getCity());
	  regData.setAddl1("asd12");
	  txtAddrl1.sendKeys(regData.getAddl1());
	  regData.setAddl2("asde");
	  txtAddrl2.sendKeys(regData.getAddl2());
	  regData.setContact("1sdf");
	  txtContactno.sendKeys(regData.getContact());
	  btnRegister1.click();
	  
	  try {
	  String expectedmsgn1="The password you entered is incorrect. Please enter the correct password.";
	  String actualmsgn1=registerSuccessmsgn1.getText();
	  assertEquals(actualmsgn1,expectedmsgn1,"Registration nagative test1");
	  
	  String expectedmsgn2="Invalid data in field 'E-mail'.";
	  String actualmsgn2=registerSuccessmsgn2.getText();
	  assertEquals(actualmsgn2,expectedmsgn2,"Registration nagative test1");
	  }
	  catch(AssertionError e) {
		  String expectedmsgn1="The password you entered is incorrect. Please enter the correct password.";
		  String actualmsgn1=registerSuccessmsg.getText();
		  assertEquals(actualmsgn1,expectedmsgn1,"Registration nagative test1");
		  
		  String expectedmsgn2="Invalid data in field 'E-mail'.";
		  String actualmsgn2=registerSuccessmsg.getText();
		  assertEquals(actualmsgn2,expectedmsgn2,"Registration nagative test1");
	  }
	  
	  try {
			screenshot.takeSnapShot(driver, "c:\\temp\\registration_page_negativetest.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  	  
	return null;
	
}
  
  public String getNextPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
  
@Override
protected void load() {
	// TODO Auto-generated method stub
	driver.get(url);
}
@Override
protected void isLoaded() throws Error {
	// TODO Auto-generated method stub
	assertEquals(driver.getTitle(),pageTitle,"Page Not Loaded.");
	
}

}
