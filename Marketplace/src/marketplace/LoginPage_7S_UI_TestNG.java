package marketplace;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.apache.log4j.Logger;

public class LoginPage_7S_UI_TestNG {
	private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeMethod
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://staging.morningstarcommodity.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLoginUI() throws Exception {
		
		try{
			
		//Get start time
		long startTime = System.currentTimeMillis();
		
		//Logger declaration
		Logger log = Logger.getLogger("devpinoyLogger");
		
	    //Test script - Step1
		driver.get(baseUrl + "/marketplace/loginPage");
		log.debug("Opening Marketplace site..");
	    	    
	    driver.findElement(By.className("logo-product")).getClass().equals("logo-product");
	    log.debug("Image/Banner: Mornignstar Marketplace is displayed");
	    
	    if(driver.findElement(By.xpath("//*[@class='logo-site']")).getAttribute("href").equalsIgnoreCase("http://www.morningstarcommodity.com/"))
	    	log.debug("Image/Banner: Morningstar logo site is displayed");
	    else
	    	log.debug("Image/Banner: Morningstar logo site is NOT displayed");
	    
	    if(driver.findElement(By.id("email_field")).getAttribute("class").equalsIgnoreCase("text"))
	    	log.debug("Verified - Username text field");
	    else
	    	log.debug("NOT Verified - Username text field");
	    
	    if(driver.findElement(By.id("password")).getAttribute("class").equalsIgnoreCase("text"))
	    	log.debug("Verified - Password text field");
	    else
	    	log.debug("NOT Verified - Password text field");
	    
	    if(driver.findElement(By.xpath("//span")).getText().equalsIgnoreCase("The Morningstar Commodity Data Marketplace provides users with direct access to the Morningstar commodity data. By utilizing an API delivery, you can eliminate the need to download and process large data files. Your applications and tools can benefit from the most up to date data that Morningstar Commodity Data has to offer. In addition, you can simplify implementation and reduce the amount of time needed to integrate Morningstar data into your tools and applications."))
	    	log.debug("Verified - Statement");
	    else
	    	log.debug("NOT Verified - Statement");
	    
	    if(driver.findElement(By.id("loginStatus")).getText().equalsIgnoreCase("Forgot Password?"))
	    	log.debug("Verified - Forgot Password? link");
	    else
	    	log.debug("NOT Verified - Forgot Password? link");
	    
	    if(driver.findElement(By.className("container")).getText().equalsIgnoreCase("For assistance please contact your client manager, or email us at commoditydata-support@morningstar.com" + "\n" + "©2012 Morningstar, Inc. All rights reserved."))
	    	log.debug("Verified - Footer Message");
	    else
	    	log.debug("NOT Verified - Footer Message");
	    
	    //Get End Time
	    long endTime = System.currentTimeMillis();
	    
	    long totalTimeMilliSeconds = endTime-startTime;
	    double totalTime = totalTimeMilliSeconds/1000;
	    
	    System.out.println("Total Execution time: " +totalTime + " Seconds");
	    log.debug("Total Execution time: " +totalTime + " Seconds");
	    
		}
		catch(Error e)
		{
			verificationErrors.append(e.toString());	
		}
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	  }
 
	}

