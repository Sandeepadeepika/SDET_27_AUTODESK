package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizatinInfoPage {
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrganizatinInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	//Business Library
	public String getOrgInfo()
	{
		return(orgHeaderText.getText());
	}
	

}
