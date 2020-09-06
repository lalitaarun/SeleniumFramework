package com.calibit.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.calibit.pages.BaseClass;
import com.calibit.pages.LoginPage;
import com.calibit.utility.BrowserFactory;
import com.calibit.utility.ExcelDataProvider;
import com.calibit.utility.Helper;

@Test

public class LoginTestCallibit extends BaseClass {

	public void login_CaliBitApp() throws Exception {

		logger = report.createTest("Login to Calibit Application");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		login.login_CallibitApp(excel.get_logindata("calibit_login", 0, 0), excel.get_logindata("calibit_login", 0, 1));
		logger.pass("Login Success");

	}

}
