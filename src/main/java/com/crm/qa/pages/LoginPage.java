package com.crm.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repo
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginpage;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signuppage;
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]")
	WebElement loginbutton;
	
	@FindBy(xpath = "//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	//initiliaze the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() throws InterruptedException {
		Thread.sleep(3000);
		loginpage.click();
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String un , String pwd) throws InterruptedException {
		Thread.sleep(3000);
		loginpage.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage(); 
	}
	

}
