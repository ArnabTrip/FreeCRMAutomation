package com.CRMTesting.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRMTesting.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[@href=\"/contacts\"]")
	WebElement contactsbtn;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	

	public ContactsPage ClickonContactsBtn() {
		// TODO Auto-generated method stub
		contactsbtn.click();
		return new ContactsPage();
		
	}
	
	public String VerifyTitle() {
		String Title=driver.getTitle();
		return Title;
		
	}
	
}
