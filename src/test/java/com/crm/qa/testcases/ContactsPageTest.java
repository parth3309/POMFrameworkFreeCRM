package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	String SheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		intialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickOnContactsLink();
		}
	
	@Test(priority = 1)
	public void verifyContactsPageLabel() throws InterruptedException {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider="getCRMTestData")
	public void ValidateCreateNewContact(String firstname, String lastname) {
		contactspage.clickOnNewContactLink();
		contactspage.createNewContact(firstname, lastname);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
