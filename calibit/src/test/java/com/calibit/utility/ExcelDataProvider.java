package com.calibit.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (IOException e) {
			System.out.println("Unable to read the file " + e.getMessage());
		}

	}

	public String get_logindata(String sheetname, int row_no, int col_no) {
		String login_detail = wb.getSheet(sheetname).getRow(row_no).getCell(col_no).getStringCellValue();

		return login_detail;

	}

	public double get_numeric_loginData(int sheetnumber, int row_no, int col_no) {
		double login_detail = wb.getSheetAt(sheetnumber).getRow(row_no).getCell(col_no).getNumericCellValue();

		return login_detail;

	}
}