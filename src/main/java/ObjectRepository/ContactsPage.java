package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']") private WebElement CreateContactIcon;
	
	
	// Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Utilization
	public WebElement getCreateContactIcon() {
		return CreateContactIcon;
	}
	
	
	//Business Library 
	/*
	 * This method will click on create contact look up page
	 */
	public void clickOnCreateContactIcon()
	{
		CreateContactIcon.click();
	}
	

}
