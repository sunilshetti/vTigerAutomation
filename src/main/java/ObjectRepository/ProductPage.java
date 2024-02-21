package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement CreateProductIcon;
	
	

	// Initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}


	//Utilization
	public WebElement getCreateProductIcon() {
		return CreateProductIcon;
	}
	
	
	
	//Business Library 
	public void clickOnCreateProductIcon()
	{
		CreateProductIcon.click();
	}
	
	

}
