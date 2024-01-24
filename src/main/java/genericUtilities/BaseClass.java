package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

/**
 * @author sunil_Bhadrashetti
 */
public class BaseClass {
	
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	//For Listeners --ListenersImplemention
	public static WebDriver sDriver;
	
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("************* DB Connection Successfully *************");
		
	}
	
//	@Parameters("browser") // We use this only for Parallel cross browser execution
//	@BeforeTest
//	public void bcConfig(String BROWSER) throws IOException
//	{
		//Step 1: Launch Browser
//		String URL = pUtil.readDataFromFile("url");
		
		//this section is for Cross Browser Execution Test		
//		if(BROWSER.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
		
		
//		sUtil.implicitWait(driver);
//		sUtil.maximizeWindow(driver);
//		driver.get(URL);
//		System.out.println("************* Browser Launched Successfully *************");
//	    //For Listeners only -- ListenersImplemention class
//	    sDriver=driver;
//	}
		
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException
	{
		//Step 1: Launch Browser
		String URL = pUtil.readDataFromFile("url");
		
		driver=new ChromeDriver();
		sUtil.implicitWait(driver);
		sUtil.maximizeWindow(driver);
		driver.get(URL);
		System.out.println("************* Browser Launched Successfully *************");
		//For Listeners only -- ListenersImplemention class
		sDriver=driver;

	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		//Step 2: Login to APP
		String USERNAME = pUtil.readDataFromFile("username");
		String PASSWORD = pUtil.readDataFromFile("password");

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("************* Logged In Successfully *************");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logOut(driver);
		System.out.println("************* Logged Out Successfully *************");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("************* Browser Closed Successfully *************");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("************* DB Disconnected Successfully *************");
	}
	

}
