package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//Business library for create organization
	public void createOrg(String orgName)
	{
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	//Business library for creat organization with industry drop drown
	public void createOrgWithIndustry(String orgName,String industryType)
	{
		organizationNameEdt.sendKeys(orgName);
		select(industryDropDown,industryType);
		saveBtn.click();
	}

}
