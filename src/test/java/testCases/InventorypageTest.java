package testCases;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventorypage;
import pages.LoginPage;

public class InventorypageTest extends TestBase {

	
	
	

	LoginPage login;
	Inventorypage invent;
	
	
	@BeforeTest
	public void setUp() throws InterruptedException, IOException
	{
		
		initialization();
		login=new LoginPage();
		invent=new Inventorypage();
		login.LoginToAppliction();
	}
	
	@Test
	public void VerifyTwitterLogoTest()
	{
		boolean result= invent.VerifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter Logo is present ="+ result);
	}
	
	
	@Test
	public void add6ProductTest() throws InterruptedException
	{
		String expCount="6";
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product add to  "+ actCount);
	}
	
	@Test
	public void  remove2productTest() throws InterruptedException
	{
		String expC="4";
		String actC=invent.remove2product();
		Assert.assertEquals(expC, actC);
		Reporter.log("Remove Product Count ="+actC);
				
	}
	
	@Test
	
	public void VerifyFbLogoTest()
	{
		boolean result= invent.VerifyFbLogo();
		Assert.assertEquals(result, true);
		Reporter.log("FbLogo is present="+ result);
	}
	@Test
	public void VerifyLinkedInLogoTest()
	{
		boolean result= invent.VerifyFbLogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedInLogo is present="+ result);
	}
	
	
	@AfterTest
	
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
	
	
	
}
