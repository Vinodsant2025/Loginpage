package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	//objectRepositry
		//driver.findelements[By.xpath="//input[@id='user-name']")
		@FindBy(xpath="//input[@id='user-name']")private WebElement usernameTxtBox;
		@FindBy(xpath="//input[@id='password']") private WebElement passwordBox;
		@FindBy(xpath="//input[@name=\'login-button\']") private WebElement loginBtn;

		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		}
	
		
		  public String VerifyURLOfApplication()
			{
				return driver.getCurrentUrl();
				
			}
			

	      public String LoginToAppliction() throws IOException
	    {
	    	 logger=report.createTest("Login To Sauce Lab Application");
	    	 usernameTxtBox.sendKeys (ReadData.readpropertyFile("Username")) ;
	    	 logger.log(Status.INFO," User Name is Entered");
			 passwordBox.sendKeys(ReadData.readpropertyFile("Password"));
			 logger.log(Status.INFO, "Password Is Entered");
			 loginBtn.click(); 
			 logger.log(Status.INFO,"Login Button is Clicked");
			 logger.log(Status.PASS,"Login Sucessfull" );
			return driver.getCurrentUrl();
	    	
	    }
		public  String LoginToApplicationWithMultiCreds(String un, String Password)
		{
			usernameTxtBox.sendKeys(un);
			passwordBox.sendKeys(Password);
			loginBtn.click();
			return driver.getCurrentUrl();
		}
		    
		    
			public String VerifyTitleOfApplication()
			{
				return driver.getTitle();
				
			}
	
    
	
    
  
	
	
}
