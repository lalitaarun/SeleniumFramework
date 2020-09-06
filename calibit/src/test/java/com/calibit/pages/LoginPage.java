package com.calibit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//driver
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "//input[@ng-reflect-name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@ng-reflect-name='password']")
	WebElement paswd;

	@FindBy(xpath = "//button//b[text()='login']")
	WebElement loginButton;

	public void login_CallibitApp(String uname, String passwd) throws Exception {
		Thread.sleep(3000);
		userName.sendKeys(uname);

		paswd.sendKeys(passwd);

		loginButton.click();
	}
}
