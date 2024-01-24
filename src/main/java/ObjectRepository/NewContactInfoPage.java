package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactInfoPage 
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement ContactInfoHeaderTxt;
	
	// Initialization
	public NewContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactInfoHeaderTxt() {
		return ContactInfoHeaderTxt;
	}
	
	
	//Business Library/Logic 
	public String captureContactInfoHeaderTxt()
	{
		return ContactInfoHeaderTxt.getText();
	}
	

}
