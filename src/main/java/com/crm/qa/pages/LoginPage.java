package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	// Page factory - Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(xpath="//div[@class='navbar-header']/a/img")
	WebElement CRMLogo;
	
	// Initializing Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	// Actions/Methods
	
	public String validateloginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}

}
