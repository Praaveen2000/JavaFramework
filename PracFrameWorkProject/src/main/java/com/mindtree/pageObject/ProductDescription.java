package com.mindtree.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponents.DriverFunctions;
import com.mindtree.uistore.AppUI;
import com.mindtree.utility.ExcelUtility;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;

public class ProductDescription extends AppUI{
	
	public static void checkProductPrice(WebDriver driver , Logger log, ExtentTest test) {
		
		try {
			String price = DriverFunctions.getText(driver, productPrice); 
			Log.testLoggerInfo(log, "Price of product is " + price);
			ExtentUtility.pass(test,  "Price of product is " + price);
		}
		catch(Exception e) {
			Log.testLoggerError(log, "Price of product is stored using the locator");
			ExtentUtility.fail(test,driver,  "Price of product is stored using the locator");
		}
	}
	public static void checkOutProduct(WebDriver driver , Logger log, ExtentTest test) {
		try {
			DriverFunctions.click(driver, cart);
			Thread.sleep(2000);
			DriverFunctions.click(driver, checkout);
			Thread.sleep(2000);
			DriverFunctions.sendkeys(driver, mobile, ExcelUtility.Excelread(1, 1));
			Thread.sleep(2000);
			DriverFunctions.click(driver, continueShop);
			Thread.sleep(2000);
			DriverFunctions.click(driver, checkoutLogin);
			Thread.sleep(2000);
			DriverFunctions.click(driver, siteLogo);
			Log.testLoggerInfo(log, "Checkout done with partial information and returned to homepage");
			ExtentUtility.pass(test,  "Checkout done with partial information and returned to homepage");
			
		}
		catch(Exception e) {
			Log.testLoggerError(log, "Checkout could not be done");
			ExtentUtility.fail(test,driver, "Checkout could not be done");
		}
	}

}
