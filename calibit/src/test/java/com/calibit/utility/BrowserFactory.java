package com.calibit.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BrowserFactory {
	WebDriver driver;

	public static WebDriver start_application(WebDriver driver,String browserName,String Url)
	{
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "./Webdriver/geckodriver.exe");
			driver= new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
		
			System.setProperty("webdriver.gecko.driver", "./Webdriver/chromedriver.exe");
		driver= new ChromeDriver();
		
	}
		else 
			System.out.println("Donot support to this browser");
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}
}
