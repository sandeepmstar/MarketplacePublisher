package functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Marketplace_BusinessFunctions {
	public static Properties propS; // Shared Map UI File
	
	public int expectedWaitTime = 1800000;
	
	public static void header_Logout()
	{
		driver.findElement(By.id("topUser")).click();
		driver.findElement(By.xpath("(//a[@name='logout'])[6]")).click();
	}
	
	//Login function
	public static void Marketplace_Login(WebDriver drivcer, String sUsername, String sPassword) throws FileNotFoundException, IOException
	{
		propS = new Properties();
		propS.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
		
		driver.findElement(By.xpath(propS.getProperty("Txt_Login_Field"))).sendKeys(sUsername);
		driver.findElement(By.xpath(propS.getProperty("Txt_Password_Field"))).sendKeys(sPassword);
		driver.findElement(By.xpath(propS.getProperty("Txt_Login_Button"))).click();
	}
	
	// to check response code of the web page
	public static int getResponseCode(String urlString) throws MalformedURLException, IOException{
	    URL url = new URL(urlString);
	    HttpURLConnection huc = (HttpURLConnection)url.openConnection();
	    huc.setRequestMethod("GET");
	    huc.connect();
	    return huc.getResponseCode();
	}
	
	// Applicationloggers
	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	
	// Browser
	public static WebDriver driver;
	{
	//Firefox
	driver = new FirefoxDriver();
	
	//Internet Explorer
	//  Note: while working with IE add the following URL's in Tools > Internet Options > Security > Trusted Sites
			//  1) http://staging.morningstarcommodity.com/marketplace/loginPage
			//  2) http://www.morningstarcommodity.com/
		
		//  64-bit IE 
		/*System.setProperty("webdriver.ie.driver","./driver/IEDriverServer_x64_2.47.0/IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		
		
		//  32-bit IE 
	   	/*System.setProperty("webdriver.ie.driver","./driver/IEDriverServer_Win32_2.47.0/IEDriverServer.exe");
		driver = new InternetExplorerDriver();	*/
	
		// Google Chrome	
		/*System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();*/
	
	}
}
