package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	    	 usernameTxtBox.sendKeys (ReadData.readpropertyFile("Username")) ;
			 passwordBox.sendKeys(ReadData.readpropertyFile("Password"));
			 loginBtn.click(); 
			return driver.getCurrentUrl();
	    	
	    }
		
		    
		    
			public String VerifyTitleOfApplication()
			{
				return driver.getTitle();
				
			}
	
    
	
    
  
	
	
}
