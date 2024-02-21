package productsTest;

import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;
import genericUtilities.BaseClass;

public class CreateProductwithMandotaryFields extends BaseClass
{
	
	@Test
	public void createProcuctwithMandotaryFields()
	{
		HomePage hp=new HomePage(driver);
		hp.ProductHeaderClick();
		
		ProductPage pp=new ProductPage(driver);
		pp.clickOnCreateProductIcon();
	}

}
