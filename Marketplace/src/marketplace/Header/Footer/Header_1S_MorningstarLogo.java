package marketplace.Header.Footer;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import java.util.Properties;
import java.io.FileInputStream;
import functions.Marketplace_BusinessFunctions;
import java.util.NoSuchElementException;

public class Header_1S_MorningstarLogo extends Marketplace_BusinessFunctions{
      private StringBuffer verificationErrors = new StringBuffer();
	 
	  public Properties propCF; // Configuration File\
	  
	  @Before
	  public void setUp() throws Exception {
				
		propCF = new Properties();
		propCF.load(new FileInputStream("./Configuration/MP_Configuration.properties"));
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	  }

	  @Test
	  public void testLoginUI() throws Exception {
		  
				//Get start time
				long startTime = System.currentTimeMillis();
								
				//Precondition
				driver.get(propCF.getProperty("AppUrl"));
						
				APPLICATION_LOGS.debug("Opening Marketplace site..");
			   
				//Step 1
				Marketplace_BusinessFunctions.Marketplace_Login(driver,propCF.getProperty("Txt_Username"),propCF.getProperty("Txt_Password"));
				APPLICATION_LOGS.debug("Entered Valid Username and Password");
				
			    //Expected Result - Point 1
			    APPLICATION_LOGS .debug("Expected Result");
			    
			    if(driver.findElement(By.xpath(propS.getProperty("Txt_LoginUsername"))).getText().equalsIgnoreCase(propCF.getProperty("Txt_User")))
				     APPLICATION_LOGS .debug("1) User is able to login successfully.");
			    else
			    	APPLICATION_LOGS.debug("User Not logged into application successfully");

			    //Expected Result - Point 2
			    int responseCode = Marketplace_BusinessFunctions.getResponseCode("http://staging.morningstarcommodity.com");
			    if(responseCode==200)
				   APPLICATION_LOGS .debug("2) User page is visible and no error or exception found.");
			    else
			       APPLICATION_LOGS .debug("2) User page is NOT visible and no error or exception found.");
			      
			    //Step 2 - Description
			    driver.findElement(By.className("site-logo")).click();
			    APPLICATION_LOGS .debug("Clicking on the Morningstar logo at the right side on the top of  the page.");
			    driver.navigate().back();
			    APPLICATION_LOGS .debug("Navigating back to morningstar.com");
			   
			    			   
			    //Step 2 - Expected Result
			    APPLICATION_LOGS .debug("Expected Result");
			     if(driver.findElement(By.className("site-logo")).getAttribute("href").equalsIgnoreCase("https://www.morningstar.com"))
				  APPLICATION_LOGS .debug("Step 2: Expected Result - Navigates to http://www.morningstarcommodity.com.");
			     else
			      APPLICATION_LOGS .debug("Step 2:*** Expected Result - Navigates to http://www.morningstarcommodity.com.");
			    	   	
			    
				//Get End Time
				long endTime = System.currentTimeMillis();
				long totalTimeMilliSeconds = endTime-startTime;
				double totalTime = totalTimeMilliSeconds/1000;
				APPLICATION_LOGS .debug("Total Execution time: " +totalTime + " Seconds");
			   		
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

