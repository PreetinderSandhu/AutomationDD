package org.Automate.base;

import org.Automate.Utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DriverInstance {

	public WebDriver driver;

	@BeforeMethod
	public void initiateDriverInstance() throws Exception {

		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();

		} 

		else
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();

		}

		
		driver.get(Utility.fetchPropertyValue("applicationURL").toString());
	}

	
	@AfterMethod
	public void closeDriverInstance() {

        driver.quit();

	}

}
