package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException 
	{
		//Create driver object and import from mySQL
		Driver driverRef= new Driver();
		
		//Step 1: register the Database/Driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2  get the connection with DB
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunildb", "root", "sunil");

		//step 3 : issue create statement
		Statement state = conn.createStatement();
		
		//step 4 : execute the query
		//executeQuery() is used for select queries
		ResultSet result = state.executeQuery("select * from customerinfo;");
		
		while(result.next())
		{
			System.out.println(result.getInt(2)+"-"+result.getString(1)+"-"+result.getString(3));
		}
		
		//step 5 close the DB
		conn.close();
	}

}
