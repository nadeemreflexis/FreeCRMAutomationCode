package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath="//td[contains(text(),'Nadeem Z')]")
	WebElement UsernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TaskLink;
	
	// Initializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePage() {
		return driver.getTitle();
	}
	
	public boolean verifyHomePageUsernameLabel() {
		return UsernameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		newContactLink.click();
	}
	

	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickOnTaskLink() {
		TaskLink.click();
		return new TaskPage();
	}
	

}
