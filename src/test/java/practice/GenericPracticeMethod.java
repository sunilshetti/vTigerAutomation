package practice;

public class GenericPracticeMethod {

	public static void main(String[] args) 
	{
		int sum=add(80, 20);//calling
		System.out.println(sum+(70%sum));

	}
	
	
	public static int add(int a, int b) // Method //called
	{
		int c=a+b;
		return c;
		
	}

}
