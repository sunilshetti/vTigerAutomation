package contactsTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.NewContactInfoPage;
import genericUtilities.BaseClass;

@Listeners(genericUtilities.ListenersImplemention.class)
public class CreateContactWithMandotaryFields extends BaseClass {

	@Test(groups = "RegressionSuite")
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
		
		System.out.println("S C M from junkins test ");

	}

}
