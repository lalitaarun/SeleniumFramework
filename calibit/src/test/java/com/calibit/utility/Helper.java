package com.calibit.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	// capture screenshot,alerts,frame,multiple windows,syc issue,java script
	// executor
	public static String capture_screenshot(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath = System.getProperty("user.dir")+"./ScreenShots/"+Helper.current_Date_time()+".png";
		try {
			FileHandler.copy(src, new File(screenshotpath));
			System.out.println("Screen captured");
		} catch (IOException e) {
			System.out.println("==Unable to capture Screen Shot== " + e.getMessage());
		}

		return screenshotpath;
	}

	public static String current_Date_time() {
		DateFormat custom_date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return custom_date.format(date);

	}
}
