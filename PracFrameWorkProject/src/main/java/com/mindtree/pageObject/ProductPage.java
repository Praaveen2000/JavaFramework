package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponents.DriverFunctions;
import com.mindtree.uistore.AppUI;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class ProductPage extends AppUI {
	
	public static void pickBook(WebDriver driver,Logger log,ExtentTest test) {
		try {
		DriverFunctions.click(driver, bookPick);
		Log.testLoggerInfo(log, "The Desired book is selected");
		ExtentUtility.pass(test, "The Desired book is selected");
		}
		
		catch(Exception e) {
			Log.testLoggerError(log, "The Desired book could not be selected");
			ExtentUtility.fail(test, driver, "The Desired book could not be selected");
		}
	}

}
