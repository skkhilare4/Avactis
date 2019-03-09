package project.RegandGuestUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import project.register.RegistrationPO;
import utils.TakeScreenshot;

public class GuestDetailsPO extends LoadableComponent<RegistrationPO>  {
private WebDriver driver;
TakeScreenshot screenshot=new TakeScreenshot();

GuestData guestdataobj=new GuestData();
	
	@FindBy(xpath="//span/input[@name='billingInfo[Firstname]']")
	private WebElement firstname;
	
	@FindBy(name="billingInfo[Lastname]")
	private WebElement lastname;
	
	@FindBy(name="billingInfo[Email]")
	private WebElement email;
	
	@FindBy(name="billingInfo[Country]")
	private WebElement countryCombo;
	
	@FindBy(name="billingInfo[Postcode]")
	private WebElement zip;
	
	@FindBy(name="billingInfo[Statemenu]")
	private WebElement stateCombo;
	
	@FindBy(name="billingInfo[City]")
	private WebElement city;
	
	@FindBy(name="billingInfo[Streetline1]")
	private WebElement addl1;
	
	@FindBy(name="billingInfo[Streetline2]")
	private WebElement addl2;
	
	@FindBy(name="billingInfo[Phone]")
	private WebElement phone;
	
	@FindBy(name="checkbox_shipping_same_as_billing")
	private WebElement chkbx;
	
	@FindBy(xpath="//div/input[@value='Continue Checkout']")
	private WebElement chekotbtn;
	
	String url="http://localhost/Avactis/";
	
	public GuestDetailsPO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		  PageFactory.initElements(this.driver, this);
			get();
	}
	
  @Test
  public CheckoutPO guestDetails() {
	  System.out.println("in guest PO");
	  System.out.println(guestdataobj.getFname());
	  WebDriverWait wait= new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOf(firstname));
	  
	  firstname.sendKeys(guestdataobj.getFname());
	  lastname.sendKeys(guestdataobj.getLname());
	  email.sendKeys(guestdataobj.getEmail());
	  Select select = new Select(countryCombo);
	  select.selectByVisibleText(guestdataobj.getCountry());
	  zip.sendKeys(guestdataobj.getZip());
	  Select select1 = new Select(stateCombo);
	  select1.selectByVisibleText(guestdataobj.getState());
	  city.sendKeys(guestdataobj.getCity());
	  addl1.sendKeys(guestdataobj.getAddl1());
	  addl2.sendKeys(guestdataobj.getAddl2());
	  phone.sendKeys(guestdataobj.getPhone());
	  chkbx.click();
	  
	  try {
			screenshot.takeSnapShot(driver, "c:\\temp\\Checkout_page_success.png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
	  chekotbtn.click();	  
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
