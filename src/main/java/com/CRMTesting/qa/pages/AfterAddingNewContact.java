package com.CRMTesting.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRMTesting.qa.base.TestBase;

public class AfterAddingNewContact extends TestBase{

	@FindBy(xpath="//i[@class=\"large user red icon\"]")
	WebElement Name;
	
	public AfterAddingNewContact() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String VerifyAddedName() {
		String name=Name.getText();
		System.out.println(name);
		return name;
		
		
	}
}
