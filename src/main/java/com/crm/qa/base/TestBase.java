package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;

	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		    } 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static void initialize()
    {
    	String browserName = prop.getProperty("Browser");
    	if(browserName.equals("chrome"))
    	{
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    	}
    	else if(browserName.equals("firefox"))
    	{
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();
    	}
    	else
    	{
    		WebDriverManager.iedriver().setup();
    		driver = new InternetExplorerDriver();
    	}
    	
        e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListener
        eventlistener= new WebEventListener();
        //Handler to register it with EventFiringWebDriver
        e_driver.register(eventlistener);
        driver = e_driver;
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
    	driver.get(prop.getProperty("URL"));
    }

}
