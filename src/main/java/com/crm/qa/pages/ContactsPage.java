package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement Contactslabel;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	// Initializing the page objects:
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontactpage() {
		return Contactslabel.isDisplayed();
	}
	
	public boolean selectContactsByName(String name) {
		driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();
		return driver.findElement(By.xpath("//td/a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']")).isSelected();
	}
	
	public void createNewContact(String Title, String ftName, String ltName, String Comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		// It is not compulsory that we only use page factory, we can use findElement method too
		select.selectByValue(Title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(Comp);
		saveBtn.click();
		
	}
  
}
