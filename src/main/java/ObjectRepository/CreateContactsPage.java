package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateContactsPage extends SeleniumUtility
{
	//Declaration
	@FindBy(xpath = "//input[@name='lastname']") private WebElement LastNemeTxt;
	@FindBy(xpath = "//input[@type='submit']") private WebElement SaveBtn;
	@FindBy(xpath = "//select[@name='leadsource']") private WebElement LeadsourceDrp;
	
	
	// Initialization
	public CreateContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getLastNemeTxt() {
		return LastNemeTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getLeadsourceDrp() {
		return LeadsourceDrp;
	}
	
	
	
	//Business Library/Logic 

	public void createNewContact(String LASTNAME)
	{
		LastNemeTxt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	public void createNewContact(String LASTNAME, String LEADSOURCE) throws InterruptedException
	{
		LastNemeTxt.sendKeys(LASTNAME);
		Thread.sleep(2000);
		handleDropDown(LeadsourceDrp, LEADSOURCE);
	}
	
	/*
	 * This method will click on save button	
	 */
	public void ClickOnSaveButton()
	{
		SaveBtn.click();
	}
	

}
