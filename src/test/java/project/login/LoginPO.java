package project.login;

import org.testng.annotations.Test;

import utils.TakeScreenshot;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoginPO extends LoadableComponent<LoginPO> {
	private WebDriver driver;
	TakeScreenshot screenshot=new TakeScreenshot();
	
	private String pageTitle = "Avactis Demo Store";
	String url = "http://localhost/Avactis/";
	
	@FindBy(linkText="Sign In")
	private WebElement signIn;
	
	@FindBy(name="email")
	private WebElement txtEmail;
	
	@FindBy(name="passwd")
	private WebElement txtPass;
	
	@FindBy(xpath="//div//input[@value='Sign In']")
	private WebElement btnSignin;
		
	@FindBy(xpath="//span[contains(text(),'Welcome,')]")
	private WebElement loginSuccessmsg;
	
	@FindBy(xpath="//div[contains(text(),'Account and password could not be identified. Try again or create an account.')]")
	private WebElement loginSuccessmsgn1;
	
	
	public LoginPO() {
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	driver = new ChromeDriver();
	PageFactory.initElements(driver, this);
	}
	
  public LoginPO(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(this.driver, this);
		get();
	}

  public LoginPO login(String user,String pass) {
	 // signIn.click();
	  txtEmail.sendKeys(user);
	  txtPass.sendKeys(pass);
	  btnSignin.click();
	  try {
	  String actualmsg=loginSuccessmsg.getText();
	  String expectedmsg="Welcome,";
	  assertEquals(actualmsg,expectedmsg,"Login failed");
	  }
	  catch(AssertionError e) {
		  String actualmsg=loginSuccessmsg.getText();
		  String expectedmsg="Welcome,";
		  assertEquals(actualmsg,expectedmsg,"Login failed");
	  }
	  
	  try {
		screenshot.takeSnapShot(driver, "c:\\temp\\login_page_success.png");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	  return new LoginPO(driver);
	  
  }
  
  
  public LoginPO loginNegative(String usern1,String passn2) {
	  signIn.click();
	  txtEmail.sendKeys(usern1);
	  txtPass.sendKeys(passn2);
	  btnSignin.click();
	  try {
	  String actualmsgn1=loginSuccessmsgn1.getText();
	  String expectedmsgn1="Account and password could not be identified. Try again or create an account.";
	  assertEquals(actualmsgn1,expectedmsgn1,"Login failed");
	  }
	  catch(AssertionError e) {
		  String actualmsgn1=loginSuccessmsgn1.getText();
		  String expectedmsgn1="Account and password could not be identified. Try again or create an account.";
		  assertEquals(actualmsgn1,expectedmsgn1,"Login failed");
	  }
	  
	  try {
		screenshot.takeSnapShot(driver, "c:\\temp\\login_page_nagativetest.png");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	  return new LoginPO(driver);
	  
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
