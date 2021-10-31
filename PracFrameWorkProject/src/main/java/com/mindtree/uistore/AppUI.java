package com.mindtree.uistore;

import org.openqa.selenium.By;

public class AppUI {
	public static By searchBox = By.xpath("//input[@name='q']");
	public static By links = By.tagName("a");
	public static By username = By.id("customer_email");
	public static By password = By.id("customer_password");
	public static By SignInButton = By.xpath("//button[contains(text(),'Sign in')]");
	public static By bookPick = By
			.xpath("//a[contains(text(),'Books Combo (Ikigai, Think Like A Monk, Sapiens)- Paperback')]");
	public static By cart = By.xpath("//*[@id=\"product_form_6578978095183\"]/div[1]/button");
	public static By checkout = By.xpath("(//*[@class='atc-banner--cart']//footer //button[@name='checkout'])[1]");
	public static By mobile = By.id("checkout_email_or_phone");
	public static By continueShop = By.id("continue_button");
	public static By productPrice = By.xpath("(//div[@class='price--main']//span[@class='money'])[1]");
	public static By login = By.xpath("(//li[@class='site-header-account-link']//a[@href='/account/login'])[1]");
	public static By checkoutLogin = By.xpath("//a[contains(text(),'Log in')]");
	public static By siteLogo = By.xpath("//img[@class='site-logo-image']");
}
