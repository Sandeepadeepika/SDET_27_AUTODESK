package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.ContactsinfoPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.genericutility.BaseClass;
import com.crm.genericutility.FileUtility;
import com.crm.genericutility.JavaUtility;
import com.crm.genericutility.WebDriverUtility;

public class CreateContactwithOrganizationTest extends BaseClass
{
	@Test
        public void CreateContactwithOrganizationTest() throws Throwable {
		
		/*JavaUtility jLib=new JavaUtility();
		FileUtility fLib=new FileUtility();
		WebDriverUtility wLib=new WebDriverUtility();*/
		int randNum=jLib.getRanDomNumber();
		
		String contactName=fLib.getPropertyKeyValue("contactName")+ randNum;
		
		String orgName=eLib.getDataFromExcel("org",1,2)+randNum;
		
		/*FileInputStream fis=new FileInputStream("./Data/Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);*/
		/*String URL = fLib.getPropertyKeyValue("url");
		String USERNAME =fLib.getPropertyKeyValue("username");
		String PASSWORD =fLib.getPropertyKeyValue("password");
		String BROWSER =fLib.getPropertyKeyValue("browser");
		String NAME=fLib.getPropertyKeyValue("name");*/
		//get random num
		/*Random ran = new Random();
		int randomnum = ran.nextInt(10000);*/
		//read test data from excel file
		/*FileInputStream fis_e=new FileInputStream("Testdata.xlsx");
	    Workbook Wb = WorkbookFactory.create(fis_e); */
		/*Sheet sh = Wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName=row.getCell(2).getStringCellValue()+randomnum;
		
		WebDriver driver;
		if(BROWSER.equals("firefox")) 
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
		/*driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);*/
		/*wLib.waitForPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		//To click on organization link
		HomePage hp=new HomePage(driver);
		hp.clickonOrganizationsLink();
		
		//To create Organization
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		//To enter details of organization
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		

		//step 2:navigate to organization module
		//driver.findElement(By.linkText("Organizations")).click();
		//step 3: click on "create organization" Button
		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//step 4:enter all the details and create new organization
		/*driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();*/
		
		//wait for Element to be active
		/*WebDriverWait Wait=new WebDriverWait(driver,20);*/
		
	
		WebElement msg = driver.findElement(By.className("dvHeaderText"));
		
		//explicity wait
		wLib.waitForElementToBeClickable(driver,msg);
		
		// step 5: navigate to contact madule
		hp.clickonContactsLink();
		
		
		//step 5:navigate to contact module
		//driver.findElement(By.linkText("Contacts")).click();
		
		//step 6:click on "create Contact" Button
		//driver.findElement(By.xpath("//img[@alt='Create Contact...'].")).click(); 
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		
		//step 7:enter all the details & create new Contact
		/*driver.findElement(By.name("lastname")).sendKeys("NAME");
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();*/
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContactWithOrg(driver, contactName, orgName);
		
		ContactsinfoPage cip=new ContactsinfoPage(driver);
		String actMsg=cip.getContactInfo();
		
		/*if(actMsg.contains(contactName)) {
			System.out.println(contactName+"is Successfully created...PASS");
		}
		else
		{
			System.out.println(contactName+"is Not Created....FAIl");
		}*/
		
		Assert.assertTrue(actMsg.contains(contactName));
		System.out.println("Contact Created Successfull");
	}
}
		
		/*while(it.hasNext()) {
			String currentID=it.next();
			driver.switchTo().window(currentID);
			String cPageTitle = driver.getTitle();
			if(cPageTitle.contains("Accounts")) {
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys();
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it.hasNext()) {
			String currentID=it1.next();
			driver.switchTo().window(currentID);
			String cPageTitle = driver.getTitle();
			if(cPageTitle.contains("Contacts")) 
			{
				break;
			}
		}
	}
		
}*/
