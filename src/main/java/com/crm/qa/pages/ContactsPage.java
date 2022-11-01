package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//a[@href='/contacts/new']")
	WebElement createcontact;
	
	@FindBy(name = "first_name")
	WebElement fn;
	
	@FindBy(name = "last_name")
	WebElement ln;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebtn;
	
		//initialize the Page Objects
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyContactsLabel() throws InterruptedException {
			Thread.sleep(2000);
			return contactsLabel.isDisplayed();
		}
		
		public void  clickOnNewContactLink() {
			createcontact.click();
		}
		
		public void createNewContact(String ftname, String ltname) {
			fn.sendKeys(ftname);
			ln.sendKeys(ltname);
			savebtn.click();
		}

}
