package marketplace;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;

import functions.Marketplace_BusinessFunctions;

public class LoginPage_7S_UI extends Marketplace_BusinessFunctions{
	
	  private StringBuffer verificationErrors = new StringBuffer();
	  public Properties propS; // Shared Map UI File
	  public Properties propCF; // Configuration File 
	  
	  @Before
	  public void setUp() throws Exception {
		 	
		propS = new Properties();
		propS.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
		
		propCF = new Properties();
		propCF.load(new FileInputStream("./Configuration/MP_Configuration.properties"));
		  
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLoginUI() throws Exception {
		  				
				//Get start time
				long startTime = System.currentTimeMillis();
										
			    //Test script - Step1
				driver.get(propCF.getProperty("AppUrl"));
				APPLICATION_LOGS.debug("Opening Marketplace site..");
			    	    
				//Step 1 - Expected Result
			    driver.findElement(By.className("logo-product")).getClass().equals("logo-product");
			    APPLICATION_LOGS.debug("Image/Banner: Mornignstar Marketplace is displayed");
			    
			    try{
			    if(driver.findElement(By.xpath(propS.getProperty("SiteLogo"))).getAttribute("href").equalsIgnoreCase(propCF.getProperty("MarketplaceSite")))
			    	APPLICATION_LOGS.debug("Image/Banner: Morningstar logo site is displayed");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    try{
			    if(driver.findElement(By.xpath(propS.getProperty("Txt_LoginUsernamne"))).getAttribute("class").equalsIgnoreCase(propCF.getProperty("Txt_Field")));
			    	APPLICATION_LOGS.debug("Verified - Username text field");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    try{
			    if(driver.findElement(By.xpath(propS.getProperty("Txt_Password_Field"))).getAttribute("class").equalsIgnoreCase(propCF.getProperty("Txt_Field")));
			    	APPLICATION_LOGS.debug("Verified - Password text field");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    try{
			    if(driver.findElement(By.xpath("//span")).getText().equalsIgnoreCase("The Morningstar Commodity Data Marketplace provides users with direct access to the Morningstar commodity data. By utilizing an API delivery, you can eliminate the need to download and process large data files. Your applications and tools can benefit from the most up to date data that Morningstar Commodity Data has to offer. In addition, you can simplify implementation and reduce the amount of time needed to integrate Morningstar data into your tools and applications."))
			    	APPLICATION_LOGS.debug("Verified - Statement");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    try{
			    if(driver.findElement(By.id("loginStatus")).getText().equalsIgnoreCase("Forgot Password?"))
			    	APPLICATION_LOGS.debug("Verified - Forgot Password? link");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    try{
			    if(driver.findElement(By.className("container")).getText().equalsIgnoreCase("For assistance please contact your client manager, or email us at commoditydata-support@morningstar.com" + "\n" + "©2012 Morningstar, Inc. All rights reserved."))
			    	APPLICATION_LOGS.debug("Verified - Footer Message");}
			    catch(Error e)			    
			    {verificationErrors.append(e.toString());}
			    
			    //Get End Time
			    long endTime = System.currentTimeMillis();
			    
			    long totalTimeMilliSeconds = endTime-startTime;
			    double totalTime = totalTimeMilliSeconds/1000;
			    
			    System.out.println("Total Execution time: " +totalTime + " Seconds");
			    APPLICATION_LOGS.debug("Total Execution time: " +totalTime + " Seconds");
			    			
				
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

