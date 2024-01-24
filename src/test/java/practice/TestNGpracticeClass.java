//package practice;
//
//import org.testng.annotations.Test;
//
//public class TestNGpracticeClass {
//	
//	@Test(priority = 1, invocationCount = 5, enabled = true)
//	public void one()
//	{
//		System.out.println("Number One");
//	}
//	
//	@Test(priority = 2, enabled = false)
//	public void two()
//	{
//		System.out.println("Number two");
//	}
//	// this will display based on ASCII value of alphabetic i order. CAPS 1st then comes smaller
//	// If set the priority it will execute the based on the priority set
//	@Test(priority = 3)
//	public void Three()
//	{
//		//Assert.fail();
//		System.out.println("Number three");
//	}
//
//	@Test(priority = 4, dependsOnMethods = "Three")
//	public void four( )
//	{
//		System.out.println("Number three");
//	}
//
//
//	//priority -- set the priority for methods
//	//invocationCount -- here we can sent the count that how many times we can run the same method
//	//enabled -- TRUE(default)/FALSE you want run or not
//	//dependsOnMethods -- will be depending on other method syntax dependsOnMethods = "Three"
//}
