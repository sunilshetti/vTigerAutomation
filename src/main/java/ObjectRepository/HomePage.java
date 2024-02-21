package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
	
	@FindBy(linkText = "Contacts") 	private WebElement ContactsHeader;
	
	@FindBy(linkText = "Products")
	private WebElement ProductHeader;
	
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") 
	private WebElement ProfileImg;
	
	@FindBy(linkText = "Sign Out") 
	private WebElement SingOutBtn;

	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
// Getters 
	public WebElement getContactsHeader() {
		return ContactsHeader;
	}
	public WebElement getProfileImg()	{
		return ProfileImg;
	}
	public WebElement getSignout()
	{
		return SingOutBtn;
	}
	public WebElement getProductHeader()
	{
		return ProductHeader;
	}
	
	
	
	
	
	//Business Library

	/*
	 * This method will click contacts link
	 */
	
	public void ContactsHeaderClick()
	{
		ContactsHeader.click();
	}
	
	public void logOut(WebDriver driver) throws InterruptedException
	{
		mouseOverAction(driver, ProfileImg);
		Thread.sleep(2000);	
		//getSignout().click();
		SingOutBtn.click();
	}
	
	public void ProductHeaderClick()
	{
		ProductHeader.click();
	}
	

	

}
