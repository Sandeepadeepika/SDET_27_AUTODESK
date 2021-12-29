package practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset.Concurrency;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable {
		/*step 1: Register the Driver*/
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		/*step 2: get connection with database - provide db name*/
		Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root","root");
		/*step 3: issue create statement*/
		Statement state = Con.createStatement();
		/*step 4: execute a query - provide table name*/
		ResultSet result=state.executeQuery("select * from employeeinfo;");
		
		while(result.next())
		{
			System.out.println(result.getString(2)+"   "+result.getString(3));
		}
		Con.close();
	}
}
	
		
	
