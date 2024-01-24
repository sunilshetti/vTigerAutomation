package genericUtilities;

import java.util.Date;

public class JavaUtility 
{
	/**
	 * This will return the current date and time in particular format
	 * @author sunil
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":", "-");
		return currentDate;
		
		//Tue Dec 19 07:58:17 IST 2023  --> this date from system
		//19-Dec-2023_08-03-44   --> the date we converted to this format


	}

}
