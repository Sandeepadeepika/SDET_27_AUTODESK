package com.crm.contacts;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.ContactsinfoPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.ExcelUtility;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;
@Listeners(com.crm.genericutility.ListnerImplementation.class)
public class createcontactTest extends BaseClass
{
	private static final String CNAME = null;

	@Test(groups="regressionSuite")

	public void CreateContactTest() throws Throwable 
	{
		//Create Objects
		/*JavaUtility jLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();*/
		
		
		//To property File
		/*FileInputStream fis=new FileInputStream("./Data/Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);*/
	
		int randNum=jLib.getRanDomNumber();
		jLib.getRanDomNumber();
		String contactName=eLib.getDataFromExcel("Org",4,6)+ randNum;
		
				
		/*String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String CNAME=fLib.getPropertyKeyValue("name")+randNum;
		
		WebDriver driver;
		if(BROWSER.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome"))
		{
				driver=new ChromeDriver();
		}
		else if(BROWSER.equals("IE")) 
		{
			driver=new InternetExplorerDriver();
		}else 
		{
			driver=new ChromeDriver();
		}
		//step 1: login
		///driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();*/
		
		/*LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);*/
		
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLink();
		
		Assert.fail();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(CNAME);
		
		ContactsinfoPage cip=new ContactsinfoPage(driver);
		String a = cip.getContactInfo();
		
		Assert.assertTrue(a.contains(CNAME));
		System.out.println("Contact created successfully");
		
		
		//driver.findElement(By.linkText("Contacts")).click();
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//driver.findElement(By.name("lastname")).sendKeys(CNAME);
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		//String a=driver.findElement(By.className("dvHeaderText")).getText();
		/*if(a.contains(CNAME))
		{
			System.out.println("create contact successfully");
		}
		else 
		{
			System.out.println("not created");
		}*/
		
		hp.logout(driver);
		driver.close();
		
	}
		
}