package Products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreatingCustomFilterWithStandardFilters {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Data.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		//get random num
		Random ran = new Random();
		int randomnum = ran.nextInt(10000); 
		//read test data from excel file
		FileInputStream fis_e=new FileInputStream("./Data/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e); 
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName=row.getCell(2).getStringCellValue()+randomnum;
		String viewName = row.getCell(5).getStringCellValue()+randomnum;
		
		WebDriver driver;
		if(BROWSER.equals("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		//step 1: login
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.id("qccombo")).click();
		driver.findElement(By.linkText("Create Filter")).click();
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(viewName);
		driver.findElement(By.name("setMetrics")).click();
		WebElement list = driver.findElement(By.id("column1"));
		Select s1=new Select(list);
		s1.selectByValue("vtiger_products:sales_start_date:sales_start_date:Products_Sales_Start_Date:D");
		driver.findElement(By.className("dvtSelectedCell")).click();
		WebElement list1 = driver.findElement(By.className("select small"));
		Select s2=new Select(list1);
		s2.deselectByVisibleText("Sales start Date");
		driver.findElement(By.id("stdDateFilter")).click();
		driver.findElement(By.xpath("//input[@name='startdate']/following-sibling::img")).click();
		driver.findElement(By.xpath("//input[@name='enddate']/following-sibling::img")).click();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//step 6: logout
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

		
		

	}

}
