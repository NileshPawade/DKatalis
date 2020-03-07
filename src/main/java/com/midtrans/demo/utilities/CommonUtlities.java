package com.midtrans.demo.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.midtrans.demo.BaseClass.TestBase;
import com.midtrans.demo.reports.LoggerHelper;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CommonUtlities extends TestBase{
	private final static Logger log=LoggerHelper.getLogger(CommonUtlities.class);
	public CommonUtlities() {
		super();
	}
	
	public static long PageLoadtimeOut=20;
	public static long implicitWait=20;	
	
	public static String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();

			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {

				for (int j = 0; j < totalNoOfCols; j++) {
					arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		log.info("Data from current row is:"+ arrayExcelData);
		return arrayExcelData;
		
	}

	public static long convertElementToNumber(WebElement element) {
		long number = (long) Double.parseDouble(element.getText().replaceAll("[,+-]", ""));
		return number;

	}
	
	public static String elementWithText(WebElement element)
	{
		log.info("Element After converting to Number"+element.getText());
		return element.getText();
	}

}
