package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutStep_OnePage;
import pages.Inventorypage;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOutStep_OnePageTest extends TestBase{

	LoginPage login;
	Inventorypage invent;
	CartPage Cart;
    CartPage Swag;
    CheckOutStep_OnePage check1;
	
	@BeforeMethod(alwaysRun= true)
	public void setUp() throws InterruptedException, IOException
	{
	
		
		initialization();
		login=new LoginPage();
		invent=new Inventorypage();
		Cart=new CartPage();
		Swag=new CartPage();
		check1=new  CheckOutStep_OnePage();
		login.LoginToAppliction();
		invent.add6Product();
		invent.ClickOnCartIcon();
		Cart.CheckOutBtnClick();
		
		
	}		
		
		
		
		@Test(groups="Sanity")
		public void informationTest()
		{
			String expTitle="https://www.saucedemo.com/checkout-complete.html";
			String actTitle= check1.information();
			Assert.assertEquals(expTitle,actTitle);
			Reporter.log("Checkout step 1 page ="+actTitle);		
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
