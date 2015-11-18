package marketplace.Header.Footer;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.server.ApplicationRegistry;

import functions.Marketplace_BusinessFunctions;

public class Footer_5S_FooterMenuBar extends Marketplace_BusinessFunctions{

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
	
  //Step1: Log in with Valid Username and Password.
  Marketplace_BusinessFunctions.Marketplace_Login(driver,propCF.getProperty("Txt_Username"),propCF.getProperty("Txt_Password"));
  APPLICATION_LOGS.debug("Entered Valid Username and Password");
  
  // Expected Result
  if(driver.findElement(By.xpath(propS.getProperty("Txt_LoginUsername"))).getText().equalsIgnoreCase(propCF.getProperty("Txt_User")))
	     APPLICATION_LOGS .debug("1) User is able to login successfully.");
 else
 		APPLICATION_LOGS.debug("User Not logged into application successfully");
  
  if(driver.findElement(By.id("footer")).isEnabled() == true)
  APPLICATION_LOGS.debug("Footer menu bar is visible");
  else
	  APPLICATION_LOGS.debug("Footer menu bar is NOT visible");  

  List<String> FooterList_Retieve  = Arrays.asList(driver.findElement(By.id("footer")).getText());
   
  Calendar currentdate = Calendar.getInstance();
  String strdate = null;
  DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
  strdate = formatter.format(currentdate.getTime());
  TimeZone obj = TimeZone.getTimeZone("CST");

  formatter.setTimeZone(obj);
  strdate = formatter.format(currentdate.getTime());
  
  String date1= strdate + " CST";
    
  List<String> FooterList_Retieved = Arrays.asList("Hide","bindu","Quick Links",date1);
  	
  if (FooterList_Retieve == FooterList_Retieved)		  
     APPLICATION_LOGS.debug("Verified - Contents of the footer bar.. Difference in Seconds");
  else
	  APPLICATION_LOGS.debug("Verified - Contents of the footer bar are NOT visible..");
  
  //Step2: Click on the Footer menu bar Hide option.
  driver.findElement(By.className("bar-button")).click(); 
  Thread.sleep(500);
  if(driver.findElement(By.className("switch-button")).getText().equalsIgnoreCase("Show"))
	  APPLICATION_LOGS.debug("Footer menu bar gets hidden and status gets Show");
  else
	  APPLICATION_LOGS.debug("Footer menu bar Don't hide.. ");
  
  int responseCode = Marketplace_BusinessFunctions.getResponseCode("http://staging.morningstarcommodity.com/marketplace/account/publisher");
  if(responseCode==200)
	   APPLICATION_LOGS .debug("No Error : error saying javascript : void (0) in status bar.");
  else
     APPLICATION_LOGS .debug("Error : error saying javascript : void (0) in status bar.");
  
  //Step 3
  driver.findElement(By.className("switch-button")).click(); 
  Thread.sleep(500);
  if(driver.findElement(By.className("bar-button")).getText().equalsIgnoreCase("Hide"))
	  APPLICATION_LOGS.debug("Strip is visible");
  else
	  APPLICATION_LOGS.debug("Strip is NOT visible");
  
  
  //Step 4
  driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_LoginUsername"))).click();
 if(driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_Logout"))).getText().equalsIgnoreCase("Log out"))
	 APPLICATION_LOGS.debug(" It shows popup menu with Log Out option..");
 else
	 APPLICATION_LOGS.debug("No Popup is shown");
  
 //Step 5
 driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_QuickLink"))).click();
 Thread.sleep(500);
  
 if((driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_QaPortalHelp"))).getText().equalsIgnoreCase("QA Portal Help"))
	 && 
	 (driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_MorningsarCommodity"))).getText().equalsIgnoreCase("Morningstar Commodity")))
	 APPLICATION_LOGS.debug("Shows the following links in popup menu: 1) Morningstar Commodity 2) QA Portal Help");
  Thread.sleep(500);
 
   //Step 6
 driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_QuickLink"))).click();
 Thread.sleep(500);
 driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_MorningsarCommodity"))).click();
 
 if(driver.getCurrentUrl().equalsIgnoreCase("http://www.morningstarcommodity.com"))
	 APPLICATION_LOGS.debug("Opens the page : http://www.morningstarcommodity.com/");
     
 //Step 7 - Click on Back option from browser.
  driver.navigate().back();
  if(driver.getCurrentUrl().equalsIgnoreCase("http://staging.morningstarcommodity.com/marketplace/account/publisher"))
	  APPLICATION_LOGS.debug("The user is returned to the page: http://mpqa.morningstarcommodity.com/marketplace/");
  else
	  APPLICATION_LOGS.debug("The user is NOT returned to the page: http://mpqa.morningstarcommodity.com/marketplace/");
  
 
 //Step 8
  driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_QuickLink"))).click();
  Thread.sleep(500);
 driver.findElement(By.xpath(Marketplace_BusinessFunctions.propS.getProperty("Txt_QaPortalHelp"))).click();
 if(driver.getCurrentUrl().equalsIgnoreCase("http://www.morningstarcommodity.com/sites/default/files/QAPortal/QAHelp.html"))
	 APPLICATION_LOGS.debug("Opens the page : http://www.morningstarcommodity.com/sites/default/files/QAPortal/QAHelp.html");
 
 driver.navigate().back();
 Thread.sleep(500);
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
