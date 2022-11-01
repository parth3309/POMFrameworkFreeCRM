package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[@class='user-display']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath="//i[@class='money icon']")
	WebElement dealsLink;
	
	@FindBy(xpath="//i[@class='tasks icon']")
	WebElement tasksLink;
	
	//initialize the Page Objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle() throws InterruptedException {
			Thread.sleep(3000);
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() throws InterruptedException {
		Thread.sleep(3000);	
		return	userNameLabel.isDisplayed();
			
		}
		
		public ContactsPage clickOnContactsLink() throws InterruptedException {
			
			Thread.sleep(2000);
			contactsLink.click();
			Thread.sleep(3000);
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink() {
			
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink() {
			
			tasksLink.click();
			return new TasksPage();
		}
	

}
