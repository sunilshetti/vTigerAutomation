package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/*
 * this class consist of all the reusable methods related to Selenium
 * @author SunilDB
 */
public class SeleniumUtility 
{
	
	/*
	 * this method will maximize the browser window 
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/*
	 * this method will minimize the browser window 
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/*
	 * this method is for implicitlyWait 
	 */	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/*
	 * this method will for 10sec for element to be visible
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * This method is for handling the drop down based on the selectByIndex
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/*
	 * This method is for handling the drop down based on the index selectByValue
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);		
	}
	
	/*
	 * This method is for handling the drop down based on the index Visible Text
	 */
	public void handleDropDown(String text, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/*
	 *this method will perform mouse hovering action on the web element
	 * 
	 */
	public void mouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
	//	act.contextClick(element).perform();
		act.moveToElement(element).build().perform();
	}
	
	/*
	 * this method will perform right click action on the web element
	 * 
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/*
	 * this method will perform scrollAction
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript("Window.scrollBy(0,500);","");
	}
	
	/*
	 *  this method will perform scrollToElement
	 */
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		WebElement we = driver.findElement(By.xpath(""));
		//Thread.sleep(2000);		
		//act.scrollToElement(we).perform();
		try 
		{
			act.scrollToElement(we).perform();

		} 
		catch (Exception e) 
		{
			System.out.println("Scrolled");
		}
		
	}

	
	/*
	 *  This method will perform getTextFromAlertPopup
	 */
	public static String getAlertText(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String altText = alt.getText();
		return altText;
	}
	//OR
	
	public String getAlertpopUpText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	/*
	 * This method will perform getTextFromAlertPopup clickOnAlertPopUpAccept
	 */
	public void clickOnAlertPopUpAccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}

	/*
	 * This method will perform getTextFromAlertPopup clickOnAlertPopUpDismiss
	 */
	public void clickOnAlertPopUpDismiss(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	
	}
	
	
	/**
	 * This method will handle the frame based on the index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/*
	 * This method will handle the frame based on the Name or ID
	 */
	public void hadleFrame(WebDriver driver, String NameID)
	{
		driver.switchTo().frame(NameID);
	}
	
	/*
	 * This method will handle the frame based on the WebElement/element
	 */
	public void hadleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
	/*
	 * This method will capture the screenshot and return  the path to caller
	 */
	
	public String captureScreenShot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dist=new File(".\\Screenshots\\"+screenshotName+".png");
		
		Files.copy(src, dist);
		
		return dist.getAbsolutePath(); // Extended reports
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}


