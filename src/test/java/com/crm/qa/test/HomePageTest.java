package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	DealsPage dealspage;
	TaskPage taskpage;
	TestUtil testutil;
	
	public HomePageTest()
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
		dealspage = new DealsPage();
		taskpage = new TaskPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homepage.verifyHomePage();
		Assert.assertEquals(homepageTitle, "CRMPRO","Homepage title not matched");
	}
	
	@Test(priority = 2)
	public void homepageUsernameTest() {
		testutil.switchToFrame();
		boolean flag = homepage.verifyHomePageUsernameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void contactsTest() {
		testutil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
	}
	
	@Test(priority = 4)
	public void dealsTest() {
		testutil.switchToFrame();
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority = 5)
	public void taskTest() {
		testutil.switchToFrame();
		taskpage = homepage.clickOnTaskLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
