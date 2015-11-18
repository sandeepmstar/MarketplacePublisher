package marketplace.Header.Footer;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import functions.Marketplace_BusinessFunctions;

public class Header_4S_MorningstarMarketPlaceLogo extends Marketplace_BusinessFunctions{

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
  
  //Step1: Click on the Morningstar Market Place (sm) logo
    driver.findElement(By.id("header_image")).click();
    APPLICATION_LOGS.debug("Click on the Morningstar Market Place (sm) logo");
    Thread.sleep(500);
    
    if(driver.getCurrentUrl().equalsIgnoreCase("http://staging.morningstarcommodity.com/marketplace/account/publisher"))
    APPLICATION_LOGS.debug("The same page gets reload - Successfully.");
    
    
    //Step2: Leave the application idle for the 30 min. 
    Thread.sleep(expectedWaitTime);  
    APPLICATION_LOGS.debug("Leave the application idle for the 30 min...");
    
    driver.findElement(By.id("header_image")).click();
    Thread.sleep(500);
    APPLICATION_LOGS.debug("Click on the on the Morningstar Market Place (sm) logo ");
    
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
