package com.CRMTesting.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.CRMTesting.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//div[@class=\"ui header item mb5 light-black\"]")
	WebElement Contactslogo;
	
	@FindBy(xpath="//a[@href=\"/contacts/new\"]")
	WebElement NewContactbutton;
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@name=\"last_name\"]")
	WebElement Lastname;
	
	@FindBy(xpath="//div[@name=\"category\"]")
	WebElement Category;
	
	@FindBy(xpath="//i[@class=\"save icon\"]")
	WebElement SaveBtn;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]")
	WebElement LastAddedName;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean Verifylogoisdisplayed() {
		boolean logo= Contactslogo.isDisplayed();
		return logo;
	}
	
	public AfterAddingNewContact CreateNewContact(String fn, String ln, String role) {
		NewContactbutton.click();
		Firstname.sendKeys(fn);
		Lastname.sendKeys(ln);
		
		Category.click();
		List <WebElement> list=driver.findElements(By.xpath("//div[@class=\"visible menu transition\"]/descendant::div[@class=\"item\"]"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++)
		{
			String text=list.get(i).getText();
			System.out.println(text);
			
			
			  if(text.equals(role)){ 
				  list.get(i).click(); 
				  break;
			  }
			  
			  
			 
		}	
		
		SaveBtn.click();
		
		return new AfterAddingNewContact();
	}
	
	
	
	
	
}
