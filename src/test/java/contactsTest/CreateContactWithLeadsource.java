package contactsTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.NewContactInfoPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplemention.class)
public class CreateContactWithLeadsource extends BaseClass {


	@Test(groups = "SmokeSuite")
	public void createContactWithLeadsource() throws IOException, InterruptedException
	{
		String LASTNAME = pUtil.readDataFromExcelFile("Contacts",2,2);
		String LEADSOURCE = pUtil.readDataFromExcelFile("Contacts", 2, 3);
		
		//Step 1: Click on contacts Link		
		HomePage hp=new HomePage(driver);
		hp.ContactsHeaderClick();
		
		//Step 2: Click on contacts + image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactIcon();
		
		//Step 3 : Enter contact with leadsource Fields
		CreateContactsPage ccp=new CreateContactsPage(driver);		
		ccp.createNewContact(LASTNAME, LEADSOURCE);
		
		
		//Step 4 : Save
		ccp.ClickOnSaveButton();
		
		//Validate 		//Create a contact with mandatory fields 		//Contact is successfully created or not
		NewContactInfoPage newContInfo=new NewContactInfoPage(driver);
		String contactName = newContInfo.captureContactInfoHeaderTxt();
		Assert.assertTrue(contactName.contains(LASTNAME));
		System.out.println(contactName);	
	}
	
	
	@Test(groups = "SmokeSuite")
	public void createContactWithMandotaryFields() throws IOException, InterruptedException
	{
		
		String LASTNAME = pUtil.readDataFromExcelFile("Contacts",2,2);
				
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
	}
		
}
