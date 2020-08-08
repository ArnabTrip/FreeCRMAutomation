package com.CRMTesting.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRMTesting.qa.util.TestUtil;
import com.CRMTesting.qa.util.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;
	
	public TestBase()  
	{
		try {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\com.CRMTesting\\src\\main\\java\\com\\CRMTesting\\qa\\config\\config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void Initialization()
	{
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Selenium & Chrome Driver\\ChromeDriver Version 84\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browsername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\HP\\Desktop\\Selenium & Chrome Driver\\Firefox driver\\gecko.exe");
			driver=new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListner();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
