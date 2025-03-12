package testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventorypage;
import pages.LoginPage;
import utility.Screenshot;

public class InventorypageTest extends TestBase {

	
	
	

	LoginPage login;
	Inventorypage invent;
	
	
	@BeforeMethod(alwaysRun= true)
	public void setUp() throws InterruptedException, IOException
	{
		
		initialization();
		login=new LoginPage();
		invent=new Inventorypage();
		login.LoginToAppliction();
	}
	
	@Test (groups="Sanity")            // (priority=1 , enabled=true)
	public void VerifyTwitterLogoTest()
	{
		boolean result= invent.VerifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter Logo is present ="+ result);
	}
	
	
	@Test(groups="Retest")
	public void add6ProductTest() throws InterruptedException
	{
		String expCount="6";//6
		String actCount=invent.add6Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Product add to  "+ actCount);
	}
	
	@Test(groups="Regression")             // (priority=4, enabled=true)
	public void  remove2productTest() throws InterruptedException
	{
		String expC= "4";//4
		String actC=invent.remove2product();
		Assert.assertEquals(expC,actC);
		Reporter.log("Remove Product cunt ="+actC);
				
	}
	
	@Test (groups="ReTest")               //(priority=3, enabled=true)
	public void  VerifyFooterTest() 
	
	{
		
		String expText	="© 2025 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String actText =invent.VerifyFooter();
		Assert.assertEquals(expText, actText);
		Reporter.log("Total product add to "+actText);
	}
	
	
	
	
	
	
	@Test(groups="Retest")           //(priority=5,enabled=false)
	
	public void VerifyFbLogoTest()
	{
		boolean result= invent.VerifyFbLogo();
		Assert.assertEquals(result, true);
		Reporter.log("FbLogo is present="+ result);
	}
	@Test  (groups="Sanity") 
	                  //(priority=6 , enabled=false)
	public void VerifyLinkedInLogoTest()
	{
		boolean result= invent.VerifyFbLogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedInLogo is present="+ result);
	}
	
	
	@AfterMethod(alwaysRun= true)
	
	public void CloseBrowser(ITestResult it) throws IOException
	{

	if (it.FAILURE==it.getStatus())
	{
		Screenshot.SC(it.getName());
	}
	
		driver.close();
	}
	
	
	
	
	
	
}
