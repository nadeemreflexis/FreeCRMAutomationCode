package com.crm.qa.test;

import java.io.IOException;

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

public class ContactsPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtil testutil;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest()
	{
		super();
	}

	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactpage = new ContactsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		

	}
	
	@Test(priority = 1)
	public void verifyContactsPageLableTest() {
		contactpage=homepage.clickOnContactsLink();
		Assert.assertTrue(contactpage.verifycontactpage(), "contacts label is missing on the page");
	}
	
	@Test(priority = 2)
	public void selectSingleContactsTest() throws InterruptedException {
		contactpage=homepage.clickOnContactsLink();
		Assert.assertTrue(contactpage.selectContactsByName("Nadeem Zaya"),"Name is not selected");

	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() throws InterruptedException {
		contactpage=homepage.clickOnContactsLink();
		Assert.assertTrue(contactpage.selectContactsByName("Nadeem Zaya"),"Name is not selected");
		Assert.assertTrue(contactpage.selectContactsByName("Shalini Soni"),"Name is not selected"); 
	}
	
	@DataProvider
	public Object[][] getContactsData() throws IOException{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	

	@Test(priority = 4, dataProvider = "getContactsData")
	public void validateCreateNewContact(String Title,String FirstName,String LastName,String Company){
		homepage.clickOnNewContactLink();
		contactpage.createNewContact(Title, FirstName, LastName, Company);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
