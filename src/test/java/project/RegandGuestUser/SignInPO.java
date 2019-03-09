package project.RegandGuestUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.annotations.Test;

import project.register.RegistrationPO;

public class SignInPO extends LoadableComponent<RegistrationPO> {
	
	private WebDriver driver;
	
	@FindBy(linkText="Sign In")
	private WebElement signIn;
	
	@FindBy(name="email")
	private WebElement txtEmail;
	
	@FindBy(name="passwd")
	private WebElement txtPass;
	
	@FindBy(xpath="//div//input[@value='Sign In']")
	private WebElement btnSignin;
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart']")
	private WebElement goTocart;
	
	@FindBy(xpath="//div/a[contains(text(),'Checkout')]")
	private WebElement btnCheckout;
	
	@FindBy(xpath="//input[@value='Continue Checkout']")
	private WebElement continueCheckout;
	
	String url="http://localhost/Avactis/";
/*
	public SignInPO() {
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
	driver = new ChromeDriver();
	PageFactory.initElements(driver, this);
	}
	*/
	public SignInPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		  PageFactory.initElements(this.driver, this);
			get();
	}

  @Test
  public CheckoutPO SignIn() {
	  signIn.click();
	  txtEmail.sendKeys("abc2@gmail.com");
	  txtPass.sendKeys("test2@123");
	  btnSignin.click();
	  
	  goTocart.click();
	  btnCheckout.click();
	  continueCheckout.click();
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
