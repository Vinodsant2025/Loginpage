package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;


public class CheckOutStep_OnePage extends TestBase {

	
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstnameTxtBox;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastnameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postalcodeTxtBox;
	@FindBy (xpath="//input[@id='continue']")private WebElement continueBtn;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	
	public CheckOutStep_OnePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String information()
	
    {
	    firstnameTxtBox.sendKeys("Vinod");
		lastnameTxtBox.sendKeys("Sant");
		postalcodeTxtBox.sendKeys("444506");
		continueBtn.click();
		finishBtn.click();
		return driver.getCurrentUrl();
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
