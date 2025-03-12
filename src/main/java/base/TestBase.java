package  base;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Extent_Reports;
import utility.ReadData;

public class TestBase {
    public ExtentReports report= Extent_Reports.getReportInstance(); 
    
	public static WebDriver  driver;
	public ExtentTest logger;
	
	public void initialization() throws InterruptedException, IOException
	{
		
		String Browser=ReadData.readpropertyFile("Browser");
		if(Browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver();
			driver=new ChromeDriver();
		}
		else if(Browser.equals("edge"))
		
		{
			WebDriverManager.edgedriver();
			driver= new EdgeDriver();
		}
		else if(Browser.equals("safari"))
		{
			WebDriverManager.safaridriver();
			driver=new SafariDriver();
		}
		
		else if(Browser.equals("firfox"))
		{
	
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
			
			
		}
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.get(ReadData.readpropertyFile("URL"));
}
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}
	
	
	
	
	
	
	
	

