package com.CRMTesting.qa.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRMTesting.qa.base.TestBase;
import com.CRMTesting.qa.pages.AfterAddingNewContact;
import com.CRMTesting.qa.pages.ContactsPage;
import com.CRMTesting.qa.pages.HomePage;
import com.CRMTesting.qa.pages.LoginPage;
import com.CRMTesting.qa.util.TestUtil;

public class LoginpageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	AfterAddingNewContact afteraddnew;
	TestUtil testUtil;
	
	String sheetName="contacts";
	
	public LoginpageTest(){
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup(){
		Initialization();
		loginpage= new LoginPage();
		
	}
	
	@Test(enabled=false)
	public void loginTest() {
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals("Cogmento CRM", homepage.VerifyTitle(), "Homepage Title not as expected");
		
	}
	
	@Test(enabled=false)
	public void VerifyContactsPageTest() {
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.ClickonContactsBtn();
		Assert.assertTrue(contactspage.Verifylogoisdisplayed());
	}
	
	@Test(priority=1)
	public void VerifyAddingNewContacts() {
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.ClickonContactsBtn();
		afteraddnew=contactspage.CreateNewContact("Arnab200", "Trip", "Contact");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(enabled=false, dataProvider="getCRMTestData")
	public void VerifyAddingNewContactsfromExcelsheet(String firstname, String lastname, String category) {
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.ClickonContactsBtn();
		afteraddnew=contactspage.CreateNewContact(firstname, lastname, category);
		
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
