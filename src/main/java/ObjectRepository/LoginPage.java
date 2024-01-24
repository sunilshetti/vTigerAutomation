package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 01
{
	
	//Rule 2 : Declaration	
	@FindBy(name="user_name") private WebElement userNameEdt;
	@FindBy(name="user_password") private WebElement userPasswordEdt;
	@FindBy(id="submitButton") private WebElement LoginBtn;
	
	
	//Rule 3: Declaration
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	
	//Rule 4: Utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}


	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	
	
	//Rule 5: Business Library
	
	public void loginToApp(String USERNAME, String PASSWORD) 
	{
		userNameEdt.sendKeys(USERNAME);
		userPasswordEdt.sendKeys(PASSWORD);
		LoginBtn.click();
		
	}
	
	
	
	
}
