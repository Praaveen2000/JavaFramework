package com.mindtree.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mindtree.exception.ApplicationException;
import com.mindtree.reusableComponents.DriverFunctions;
import com.mindtree.uistore.AppUI;
import com.mindtree.utility.ExcelUtility;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends AppUI {

	public static void titleCheck(Logger log, WebDriver driver, ExtentTest test) {
		try {
			if (driver.getTitle().equals("India's Best Online Store | Free Shipping | eLocalshop")) {
				Log.testLoggerInfo(log, " Navigated to the expected page");
				test.log(LogStatus.PASS, "Navigated to the expected page");
			}

			else
				throw new ApplicationException("Desired site is not opened");
		}

		catch (ApplicationException e) {
			Log.testLoggerError(log, e.toString());
			ExtentUtility.fail(test, driver, "TitleCheck");
		}
	}

	public static void bookSearch(Logger log, WebDriver driver, ExtentTest test) {
		try {

			DriverFunctions.sendkeys(driver, searchBox, ExcelUtility.Excelread(1, 0));
			DriverFunctions.sendkeys(driver, searchBox, Keys.ENTER);

			Log.testLoggerInfo(log, "The Values are accesed from the Excel sheet into SearchBox");
			ExtentUtility.pass(test, "The Values are accesed from the Excel sheet into SearchBox");
		}

		catch (IOException e) {
			Log.testLoggerError(log, "The Values could not be accesed from the Excel sheet");
			ExtentUtility.fail(test,driver, "The Values could not be accesed from the Excel sheet");
		}
	}
	
	public static void loginCheck(WebDriver driver,Logger log,ExtentTest test) {
		try {
		DriverFunctions.click(driver, login);
		Log.testLoggerInfo(log, "Login Page appears succesfully");
		ExtentUtility.pass(test, "Login Page appears succesfully");
		}
		catch(Exception e) {
			Log.testLoggerError(log, "Could not reach Login Page");
			ExtentUtility.fail(test,driver, "Could not reach Login Page");
		}
	}
}
