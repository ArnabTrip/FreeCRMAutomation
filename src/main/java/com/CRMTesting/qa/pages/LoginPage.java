package com.CRMTesting.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRMTesting.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class=\"ui fluid large blue submit button\"]")
	WebElement loginbtn;

	//Initializing the Page objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);;
		// TODO Auto-generated constructor stub
	}

	//Actions to be performed on this page
	
public HomePage Login(String un, String pwd) {
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	return new HomePage();
	
	
}
}
