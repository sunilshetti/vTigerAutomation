package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Step 1: Launch Browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//Step 2: Load the URL
				driver.get("http://localhost:8889/");
				
				//Step 3: Login to the application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				
				//Step 4: Click on contacts Link
				driver.findElement(By.linkText("Leads")).click();
				
				driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
				
				//Step 6 : Enter Mandatory Fields
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sunil");
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shetti");
				driver.findElement(By.xpath("//input[@name='company']")).sendKeys("S and S");
				
				//Step 7 : Save
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				
				
				//Validate
				//Create a contact with mandatory fields
				//Contact is successfully created or not
				String leadHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(leadHeader.contains("Shetti"))
				{
					System.out.println("PASS");
					
				}else
				{
					System.out.println("FAIL");
				}
				
				//Step 8 : Logout
				Thread.sleep(2000);
					
				
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.linkText("Sign Out")).click();

				
				System.out.println("Sign Out");


				driver.close();

	}
	
}
