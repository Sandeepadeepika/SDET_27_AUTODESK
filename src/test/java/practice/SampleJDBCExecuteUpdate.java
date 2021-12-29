package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws Throwable{
		//step 1: Register the driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		//step 2:get connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		//step 3:issue creat statement
		Statement state = con.createStatement();
		//step: execute a quary
		int result = state.executeUpdate("insert into employeeinfo values(2,'Rock','Bombay');");
		if(result==1)
		{
			System.out.println("Data Added Successfully");
			}
		else
		{
			System.out.println("Failed to add");
		}
		con.close();
	}
	}
