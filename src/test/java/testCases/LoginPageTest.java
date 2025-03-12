package testCases;




import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase {

	
	
	LoginPage login;
	
	
	@BeforeMethod(alwaysRun= true)
	public void setUp() throws InterruptedException, IOException
	{
		
		initialization();
		login=new LoginPage();
		
	}
	
	@Test(groups="Sanity")    //(invocationCount=10, timeOut=1000)
	public void VerifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0, 0);//"https://www.saucedemo.com/";(0,0)
		String actURL= login.VerifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("SWag Labs URL ="+actURL);		
	}
	
	
	
	
	
	
	@DataProvider(name="CredsForLogin")
	public Object [][] getData()
	{
	
	return  new Object [][]
			{
		{"standard_user" ,"secret_sauce"},
		{"locked_out_user","secret_sauce"},
		{"problem_user",   "secret_sauce"},
		{"performance_glitch_user", "secret_sauce"},
		{"error_user" ,  "secret_sauce"},
		{"visual_user" , "secret_sauce"},
		
			};
}
	
	   @Test(dataProvider ="CredsForLogin")
		public void LoginToApplicationWithMultiCredsTest(String un, String Password)
		{
		SoftAssert SA= new SoftAssert();
	    String expUrl="https://www.saucedemo.com/inventory.html";
	    String actUrl=login.LoginToApplicationWithMultiCreds(un, Password);
	    SA.assertEquals(expUrl, actUrl);
	    SA.assertAll();
		}
	   
		
	
	
	
	@Test      //(groups= {"Sanity","Retest"})                         //(dependsOnMethods ="VerifyURLOfApplicationTest")
	public void LoginToAppliction() throws IOException 
	{
	String expectedURL= ReadData.readExcel(0, 1);//"https://www.saucedemo.com/inventory.html";(0,1)
	String actualURL= login.LoginToAppliction();
	Assert.assertEquals(expectedURL, actualURL);
	Reporter.log("Login Successful ="+actualURL);
	}
	

	@Test (groups="Retest")                              //(dependsOnMethods ="VerifyURLOfApplicationTest")
	public void VerifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,2);//"Swag Labs";(0,2)
	    String actTitle= login.VerifyTitleOfApplication();
	    Assert.assertEquals(expTitle, actTitle);
	    Reporter.log("Swag labs Title="+actTitle);
	}
	
	
	
	
	@AfterMethod(alwaysRun= true)
	public void CloseBrowser(ITestResult it) throws IOException
	{

	if (it.FAILURE==it.getStatus())
	{
		Screenshot.SC(it.getName());
	}
	report.flush();
	
		driver.close();
	}
	
}	
	
	
