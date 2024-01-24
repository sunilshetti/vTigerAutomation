package contactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NewContactInfoPage;
import genericUtilities.BaseClass;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class CreateContactWithMandotaryFieldsTWO {

	@Test
	public static void createContactWithMandotaryFields() throws IOException, InterruptedException 
	{
		JavaUtility jUtil=new JavaUtility();
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String URL = pUtil.readDataFromFile("url");
		String USERNAME = pUtil.readDataFromFile("username");
		String PASSWORD = pUtil.readDataFromFile("password");
		String LASTNAME = pUtil.readDataFromExcelFile("Contacts",2,2);
		String LEADSOURCE = pUtil.readDataFromExcelFile("Contacts", 2, 3);
		
		SeleniumUtility sUtil=new SeleniumUtility();

		
		//Step 1: Launch Browser
		WebDriver driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.implicitWait(driver);
		
		//Step 2: Load the URL
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		//Step 4: Click on contacts Link		
		HomePage hp=new HomePage(driver);
		hp.ContactsHeaderClick();
		
		//Step 5: Click on contacts + image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactIcon();
		
		//Step 6 : Enter Mandatory Fields
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.getLastNemeTxt().sendKeys(LASTNAME);
				
		//Step 7 : Save
		ccp.ClickOnSaveButton();
		
		//Validate 	//Create a contact with mandatory fields 	//Contact is successfully created or not
		NewContactInfoPage newContInfo=new NewContactInfoPage(driver);
		String contactName = newContInfo.captureContactInfoHeaderTxt();
		
		
		if(contactName.contains(LASTNAME))
		{
			System.out.println("PASS");
			
		}else
		{
			System.out.println("FAIL");
		}
		
		//Step 8 : Logout
	
		hp.logOut(driver);
		System.out.println("Sign Out");
		
		driver.close();
		

	}

}
