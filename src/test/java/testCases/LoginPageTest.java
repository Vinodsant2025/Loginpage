package testCases;




import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import base.TestBase;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

	
	
	LoginPage login;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException, IOException
	{
		
		initialization();
		login=new LoginPage();
		
	}
	
	@Test
	public void VerifyURLOfApplicationTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL= login.VerifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("SWag Labs URL ="+actURL);		
	}
	
	
	
	@Test
 
	
	public void LoginToAppliction() throws IOException 
	{
	String expectedURL= "https://www.saucedemo.com/inventory.html";
	String actualURL= login.LoginToAppliction();
	Assert.assertEquals(expectedURL, actualURL);
	Reporter.log("Login Successful ="+actualURL);
	}
	

	@Test
	public void VerifyTitleOfApplicationTest()
	{
		String expTitle="Swag Labs";
	    String actTitle= login.VerifyTitleOfApplication();
	    Assert.assertEquals(expTitle, actTitle);
	    Reporter.log("Swag labs Title="+actTitle);
	}
	
	
	
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
	
	
}