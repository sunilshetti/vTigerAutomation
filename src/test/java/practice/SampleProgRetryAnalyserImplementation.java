package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(genericUtilities.ListenersImplemention.class)
public class SampleProgRetryAnalyserImplementation 
{
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sunilTest()
	{
		//Assert.fail();
		System.out.println("Sunil");
	}

}
