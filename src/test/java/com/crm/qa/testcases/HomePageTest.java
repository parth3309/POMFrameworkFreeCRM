package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated - - No dependencies
	//before each test case launch browser and login
	//execute test case
	//after each test case quit browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		intialization();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() throws InterruptedException {
		String homepagetitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "Cogmento CRM" , "Home Page Title not matched"); 
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() throws InterruptedException {
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() throws InterruptedException {
		contactspage = homepage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
