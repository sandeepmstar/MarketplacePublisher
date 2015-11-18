package marketplace.Header.Footer;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import functions.Marketplace_BusinessFunctions;

public class Header_3S_LogOut extends Marketplace_BusinessFunctions{

	private StringBuffer verificationErrors = new StringBuffer();
	public Properties propCF; // Configuration File

@Before
public void setUp() throws Exception {
	
	propCF = new Properties();
	propCF.load(new FileInputStream("./Configuration/MP_Configuration.properties"));

  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
public void test() throws Exception {
	
  //Pre-Condition	
  driver.get(propCF.getProperty("AppUrl"));
	
  //Login into application
  Marketplace_BusinessFunctions.Marketplace_Login(driver,propCF.getProperty("Txt_Username"),propCF.getProperty("Txt_Password"));
  APPLICATION_LOGS.debug("Entered Valid Username and Password");
  
  //Step1: Hover mouse on the Man Icon.
    driver.findElement(By.id("topUser")).click();
    
    if(driver.findElement(By.xpath("(//a[@name='accinfo'])[2]")).getText().equalsIgnoreCase("Account Information") && driver.findElement(By.xpath("(//a[@name='logout'])[6]")).getText().equalsIgnoreCase("Log out"))
    {
    	APPLICATION_LOGS.debug("Drop down shows two options:User Account Information and Log Out");
    }
  
    //Step2: Click on Log out option
    driver.findElement(By.xpath("(//a[@name='logout'])[6]")).click();
      
    if(driver.getCurrentUrl().equalsIgnoreCase("http://stagings.morningstarcommodity.com/marketplace/loginPage"))
		 APPLICATION_LOGS.debug("The user is logged out and Log-in page (Main page) is being displayed. ");	
		  

}

@After
public void tearDown() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    fail(verificationErrorString);
  }
}
  
}
