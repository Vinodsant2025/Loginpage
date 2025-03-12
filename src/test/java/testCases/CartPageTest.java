package testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventorypage;
import pages.LoginPage;

public class CartPageTest  extends TestBase{

	
	LoginPage login;
	Inventorypage invent;
	CartPage Cart;
    CartPage Swag;
    
	
	@BeforeMethod(alwaysRun= true)
	public void setUp() throws InterruptedException, IOException
	{
		
		initialization();
		login=new LoginPage();
		invent=new Inventorypage();
		Cart=new CartPage();
		Swag=new CartPage();
		login.LoginToAppliction();
		invent.add6Product();
		invent.ClickOnCartIcon();
		
		
	}		
		
		
		
		@Test(groups="Regression")
		public void CartPageTitleTest()
		{
			String expTitle="Your Cart";
			String actTitle= Cart.CartPageTitle();
			Assert.assertEquals(expTitle,actTitle);
			Reporter.log("Title of Cart Page ="+actTitle);		
		}
		
		@Test(groups="Sanity")
		public void SwagLabsTitleTest()
		{
			String expTitle="Swag Labs";
			String actTitle= Swag.SwagLabsTitle();
			Assert.assertEquals(expTitle,actTitle);
			Reporter.log("Title of Swag Page ="+actTitle);		
		}
		
		
		@AfterMethod(alwaysRun= true)
		public void CloseBrowser()
		{
			driver.close();
		}
		
		
		
		
	

	
	}
	
	
	
	
	
	
	
	
	

