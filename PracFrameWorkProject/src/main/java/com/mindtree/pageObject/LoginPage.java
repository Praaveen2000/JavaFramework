package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exception.PageObjectException;
import com.mindtree.reusableComponents.DriverFunctions;
import com.mindtree.uistore.AppUI;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends AppUI {

	public static void enterLoginCredentials(WebDriver driver, Logger log, ExtentTest test, String uName, String pWord)
			throws PageObjectException {
		try {
			if (driver.getTitle().equals("Account– eLocalshop")) {
				DriverFunctions.sendkeys(driver, username, uName);
				DriverFunctions.sendkeys(driver, password, pWord);
				DriverFunctions.click(driver, SignInButton);
				DriverFunctions.click(driver, siteLogo);
				Log.testLoggerInfo(log, "Login Successful");
				ExtentUtility.pass(test, "Login Successful");
			} else
				throw new PageObjectException("Login not Successful");
		} 
		
		catch (Exception e) {
			Log.testLoggerError(log, "Login not successful");
			ExtentUtility.fail(test, driver, "Login not Successful");
		}
	}

}
