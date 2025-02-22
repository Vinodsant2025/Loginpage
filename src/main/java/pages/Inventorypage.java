package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDown;


public class Inventorypage  extends TestBase {

	
	
	@FindBy(xpath="//a[text()='Twitter']")private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedInLogo;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement  backpackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement bikeLighProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement boltTshirt;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement Fleecejacket;
	@FindBy(xpath=" //button[@id='add-to-cart-sauce-labs-onesie']") private WebElement Labsonesie;
	@FindBy(xpath=" //button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement Tshirtred;
	@FindBy(xpath="//select[@class='product_sort_container']")private WebElement dropdownlist;
    @FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement CartIcon;
    @FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement cartCount;
	@FindBy(xpath="//button[@id='remove-'sauce-labs-onesie']")private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removebikelightProduct;
	
	public Inventorypage ()
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean VerifyTwitterLogo()
	{
		return  twitterLogo.isDisplayed() ;
		
	}
	
	public boolean VerifyFbLogo()
	{
		return FacebookLogo.isDisplayed() ;
		
	}
	
	public boolean VerifyLinkedInLogo()
	{
		return LinkedInLogo.isDisplayed() ;
		
	}
	
	public String add6Product() throws InterruptedException
	{
		
		HandleDropDown.handleselect(dropdownlist, "Price(low to high)");
		
		backpackProduct.click();
		bikeLighProduct.click();
		boltTshirt.click();
		Fleecejacket.click();
		Labsonesie.click();
		Tshirtred.click();
		return cartCount.getText();
	}
	
	public String remove2product() throws InterruptedException
	
	{
		add6Product();
		Thread.sleep(8000);
		removebackpackProduct.click();
		//removebikelightProduct.click();
		return cartCount.getText();
		
		
		
	}
	
	
	
}
