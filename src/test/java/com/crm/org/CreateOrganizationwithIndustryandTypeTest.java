package com.crm.org;


import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizatinInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;

public class CreateOrganizationwithIndustryandTypeTest extends BaseClass {
	
	@Test
	public void CreateOrganizationWithIndustryandTypeTest() throws Throwable
//private static final WebDriver driver = null;

{
	//JavaUtility jLib=new JavaUtility();
	//FileUtility fLib=new FileUtility();
	
	/*FileInputStream fis=new FileInputStream("./Data/Data.properties");
	 properties pobj=new properties();*/
	/*String URL =fLib.getPropertyKeyValue("url");
	String USERNAME =fLib.getPropertyKeyValue("username");
	String PASSWORD =fLib.getPropertyKeyValue("password");
	String BROWSER =fLib.getPropertyKeyValue("browser");
	String NAME=fLib.getPropertyKeyValue("name");*/
	//get random num
	int randNum=jLib.getRanDomNumber();
	String cname=fLib.getPropertyKeyValue("contactName")+randNum;
	
	//Random ran = new Random();
	//int randomnum = ran.nextInt(10000); 
	//read test data from excel file
	String OrgName=eLib.getDataFromExcel("org",1,2)+randNum;
	String indus=eLib.getDataFromExcel("org",4,3);
	String type=eLib.getDataFromExcel("org",4,4);
	
	/*FileInputStream fis_e=new FileInputStream("Testdata.xlsx");
    Workbook Wb = WorkbookFactory.create(fis_e); 
	Sheet sh = Wb.getSheet("org");
	Row row = sh.getRow(1);
	String orgName=row.getCell(2).getStringCellValue()+ randomnum;*/
	//WebDriver driver;
	/*if(BROWSER.equals("firefox")) 
	{
		driver=new FirefoxDriver();
	}else if(BROWSER.equals("ie"))
	{
		driver=new InternetExplorerDriver();
	}
	else 
	{
		driver=new ChromeDriver();
	}*/
	//step 1: login
	/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();*/
	
	HomePage hp=new HomePage(driver);
	hp.clickonOrganizationsLink();
	
	
	
	

	//step 2:navigate to organization module
	//driver.findElement(By.linkText("Organizations")).click();
	//step 3: click on "create organization" Button
	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrg();
	
	
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//step 4:enter all the details and create new organization
	
	CreateOrganizationPage cp=new CreateOrganizationPage(driver);
	cp.createOrgWithIndustry(OrgName,indus);
	
	OrganizatinInfoPage oip=new OrganizatinInfoPage(driver);
	String actMsg=oip.getOrgInfo();
	
	/*driver.findElement(By.name("accountname")).sendKeys(orgName);
	 WebElement ind=(WebElement)driver.findElement(By.name("industry")); 
	 Select s1=new Select(ind);
	 s1.selectByvisibleText(indus);*/
	 
	 //To select Press type
	/* WebElement typ=(WebElement)driver.findElement(By.className("accounttype"));
	 Select s2=new Select(typ);
	 s2.SelectByVisibleText(type);
	 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	 String msg=driver.findElement(By.className("")).getText();
	 String msgindtype=driver.findElement(By.xpath("")).getText();
	  String msgtype=driver.findElement(By.xpath("")).getText();*/
	  
	  if(actMsg.contains(OrgName))
	  {
		  System.out.println(OrgName+"is created......PASS");
	  }
	  else
	  {
		  System.out.println(OrgName+"is Not created......FAIL");  
	  }
	  }
      }
