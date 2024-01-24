package practice;

import java.io.IOException;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilities {

	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtility=new PropertyFileUtility();
		String url = pUtility.readDataFromFile("url");
		System.out.println(url);
		String value1 =pUtility.readDataFromExcelFile("Contacts", 1, 2);
		System.out.println(value1);
			
		
		JavaUtility ju=new JavaUtility();
		String date=ju.getSystemDate();
		System.out.println(date);
		
	}

}
