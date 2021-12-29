package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {//step 1:create a seperate class for home page
	//step 2:Declaration 
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement oppotunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//step 3: initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//step 4: utilization

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppotunitiesLnk() {
		return oppotunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return troubleTicketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	//step 5:business Library to click on contacts
	public void clickonOrganizationsLink()
	{
		organizationLnk.click();
	}
	//Business library to click on contacts
	public void clickonContactsLink()
	{
		contactsLnk.click();
	}
	//Business library for logout
	public void logout(WebDriver driver)
	{
	mouseOveronElement(driver, administratorImg);
		signOutLnk.click();
	}
	}
	
	
	
	
	


