package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase {
	@FindBy(xpath="//span[@class='title']") private WebElement cartTitle;
	@FindBy(xpath="//div[@class='app_logo']")private WebElement swagLabsTitle;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtnClick;
	
	public CartPage ()
	{
		PageFactory.initElements(driver,this);
	}
	public  void SwagPage ()
	{
		PageFactory.initElements(driver, this);
	}
	public String SwagLabsTitle()
	{
		return swagLabsTitle.getText();
	}
	
	public String CartPageTitle ()
	{
		return cartTitle.getText();
	}
	
	public void  CheckOutBtnClick()
	{
		checkoutBtnClick.click();
	}
	
	
}
