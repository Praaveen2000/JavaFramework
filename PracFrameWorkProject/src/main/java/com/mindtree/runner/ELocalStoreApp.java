package com.mindtree.runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.exception.PageObjectException;
import com.mindtree.pageObject.HomePage;
import com.mindtree.pageObject.LoginPage;
import com.mindtree.pageObject.ProductDescription;
import com.mindtree.pageObject.ProductPage;
import com.mindtree.reusableComponents.WebDriverHelper;
import com.mindtree.utility.OpenCloseChrome;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ELocalStoreApp extends WebDriverHelper {

	public static Logger log;
	public static ExtentTest extentTest;
	public static ExtentReports extent;

	@BeforeTest
	public void set() {
		driver = DriverSetUp();
	}

	@Test(priority = 1)
	void titleCheck() {
		log = Logger.getLogger(ELocalStoreApp.class.getName());
		extent = new ExtentReports(System.getProperty("user.dir") + "\\Testreports\\" + date + "_ExtendReport.html",
				false);
		extentTest = extent.startTest("titleCheck");
		HomePage.titleCheck(log, driver, extentTest);
	}

	@Test(priority = 3)
	void bookCheckout() {
		extentTest = extent.startTest("bookCheckOut");
		HomePage.bookSearch(log, driver, extentTest);
		ProductPage.pickBook(driver, log, extentTest);
		ProductDescription.checkProductPrice(driver, log, extentTest);
		ProductDescription.checkOutProduct(driver, log, extentTest);
	}

	@Test(dataProvider = "Logindatas", priority = 2)
	void loginCheck(String username, String password) throws PageObjectException {
		extentTest = extent.startTest("bookCheckOut");
		HomePage.loginCheck(driver, log, extentTest);
		LoginPage.enterLoginCredentials(driver, log, extentTest, username, password);
	}

	@DataProvider
	Object[][] Logindatas() {
		Object[][] obj = new Object[1][2];
		obj[0][0] = "asasas@gmail.com";
		obj[0][1] = "asasas123";
		return obj;
	}

	@AfterMethod
	void meth() {
		extent.endTest(extentTest); // ending test and ends the current test and prepare to create html report

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		extent.flush();
		extent.close();
		OpenCloseChrome.quitDriver(driver);
	}

}
