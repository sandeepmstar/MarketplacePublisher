package marketplace.Header.Footer;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import functions.Marketplace_BusinessFunctions;

public class Header_2S_UserAccountInformation extends Marketplace_BusinessFunctions{

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
  
  //Step1: Description
  driver.findElement(By.id("topUser")).click();
  driver.findElement(By.xpath("html/body/div[4]/div/ul/li[1]/a")).click();
  System.out.println(driver.findElement(By.xpath("html/body/div[4]/div/ul/li[1]/a")).getText());
  Thread.sleep(500);
  
      if(driver.findElement(By.xpath(propCF.getProperty("Txt_Login_Label"))).getText().equalsIgnoreCase("Login") &&
         driver.findElement(By.xpath(propCF.getProperty("Txt_Name_Label"))).getText().equalsIgnoreCase("Name") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Phone_Label"))).getText().equalsIgnoreCase("Phone") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Company_Label"))).getText().equalsIgnoreCase("Company") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Login_Input"))).getAttribute("value").equalsIgnoreCase("bindu@lim.com") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Name_Input"))).getAttribute("value").equalsIgnoreCase("bindu bindu1") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Phone_Input"))).getAttribute("value").equalsIgnoreCase("09090909090") &&
    	 driver.findElement(By.xpath(propCF.getProperty("Txt_Company_Input"))).getAttribute("value").equalsIgnoreCase("Morningstar Commodity Data Inc."))
    	  APPLICATION_LOGS.debug("Entries respective to Log-in, Name, Phone and Company is given.");
      else
    	  APPLICATION_LOGS.debug("NO - Entries respective to Log-in, Name, Phone and Company is given.");
    	
 //Step 2
      
      
 // Step 3 - Click on Close button     
        
      Thread.sleep(300);
      driver.findElement(By.xpath("//input[@value='Close']")).click();
      Thread.sleep(5000);
     if(driver.findElement(By.id("acc_info_box")).isDisplayed() == false)	
    	 APPLICATION_LOGS.debug("The Account Information window is closed. ");
     else
    	 APPLICATION_LOGS.debug("The Account Information window is NOT closed. ");
    
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

