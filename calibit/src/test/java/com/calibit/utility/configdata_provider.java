package com.calibit.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configdata_provider {
	Properties pro;

	public configdata_provider() {
		File src = new File("./config/configration.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Unable to load the file " + e.getMessage());
		}

	}

	public String  getbrowser() {
		return pro.getProperty("Browser");

	}
	public String getURL() {
		return pro.getProperty("URL");

	}

}