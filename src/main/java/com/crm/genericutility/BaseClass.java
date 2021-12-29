package com.crm.genericutility;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.mysql.jdbc.Driver;

public class BaseClass {
	public  WebDriver driver;
	
	  /*Object Creation for Lib*/
	    public DataBaseUtility  dLib=new DataBaseUtility();
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smokeSuite","regressionSuite"})
	public void dbConnection() 
	{
		dLib.connectToDB();
		System.out.println("========================Database connection successful========================");
    }
	
	//@Parameters("browser")	
	@BeforeClass(groups={"smokeSuite","regressionSuite"})
	public void launchBrowser() throws Throwable {
		//read the data
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid Browser");
		}
		sdriver=driver;
		
		wLib.waitForPageToLoad(driver);
		wLib.maximiseWindow(driver);
		driver.get(URL);
		System.out.println("========Browser launched========");
		
	}
	
	@BeforeMethod(groups={"smokeSuite","regressionSuite"})
	public void loginToApp() throws Throwable {
		//read the data
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
	         LoginPage lp = new LoginPage(driver);
	        lp.login(USERNAME, PASSWORD);
	        System.out.println("=======Login Successfull======");
	}
	
	
	@AfterMethod(groups={"smokeSuite","regressionSuite"})
	public void logoutofApp() {
         HomePage hp = new HomePage(driver);
      hp.logout(driver);
      System.out.println("========logout successful========");
	}
	
	@AfterClass(groups={"smokeSuite","regressionSuite"})
	public void closeBrowser() 
	{
		driver.quit();
		System.out.println("=============browser closed=======");
	}
	
	@AfterSuite(groups={"smokeSuite","regressionSuite"})
	public void closeDbConnection() 
	{
		dLib.closeDB();
		System.out.println("========================Database connection closed========================");
	}
}





