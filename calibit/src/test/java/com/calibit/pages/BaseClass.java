package com.calibit.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.calibit.utility.BrowserFactory;
import com.calibit.utility.ExcelDataProvider;
import com.calibit.utility.Helper;
import com.calibit.utility.configdata_provider;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public configdata_provider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting the reports and Test is getting Ready", true);
		excel = new ExcelDataProvider();
		config = new configdata_provider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/Calibit" + Helper.current_Date_time() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeClass
	public void setup_browser() {
		Reporter.log("Trying to start Browser and getting Application Ready", true);
		driver = BrowserFactory.start_application(driver, config.getbrowser(), config.getURL());
		Reporter.log("Application is Up and running");

	}

	@AfterClass
	public void teardown() {

		BrowserFactory.quitBrowser(driver);
		Reporter.log("Browser closed", true);

	}

	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);;
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.capture_screenshot(driver);
			logger.fail("Test Faileed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.capture_screenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			Helper.capture_screenshot(driver);
			logger.pass("Test passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.capture_screenshot(driver)).build());

		}
		report.flush();
		Reporter.log("Test completed >>> Report generated", true);
	}

}
