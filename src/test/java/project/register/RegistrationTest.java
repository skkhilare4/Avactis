package project.register;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class RegistrationTest {
	WebDriver driver;
	RegistrationPO registration;
  @Test
  public void register() {
	  System.out.println("in test");
	  registration.negativeTestregister();
	  registration.register();
  }

  @Parameters({ "browser" })
  @BeforeMethod
  public void beforeMethod(String browser) {
	  System.out.println("in before");
	  registration=new RegistrationPO(browser);
	  registration.get();
  }

 
  /*
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("in before");
	  registration=new RegistrationPO();
	  registration.get();
  }
   */
  @AfterMethod
  public void afterMethod() {
	  System.out.println("in after");
	 // driver.quit();
  }

}
