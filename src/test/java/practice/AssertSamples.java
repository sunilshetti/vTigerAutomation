package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertSamples 
{
	
	@Test
	public void hardAssertSample()
	{
		String s="Sample";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(s, s); //pass
		Assert.assertEquals(1, 1); // Fail
		
		Assert.assertTrue(s.contains("S"));//pass
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}
	
	@Test
	public void softAssertSample()
	{
		String s="Sample";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		
		Assert.assertEquals(s, s); //pass
		Assert.assertEquals(1, 1); // Fail
		Assert.assertTrue(s.contains("S"));//pass
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
	}

}
