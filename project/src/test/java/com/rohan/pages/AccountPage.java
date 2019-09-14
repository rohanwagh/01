package com.rohan.pages;

import org.openqa.selenium.By;

import com.rohan.base.TestBase;

public class AccountPage extends TestBase
{
	By logout 		= By.xpath(or.getProperty("logout"));
	By myAccDropDown= By.xpath(or.getProperty("myAccDropDown"));
	By homePage = By.xpath(or.getProperty("homePage"));

	public boolean logOut()
	{
		driver.findElement(myAccDropDown).click();
		driver.findElement(logout).click();
		return true;	
	}
	
	public void navigateToHomePage()
	{
		driver.findElement(homePage).click();
	}
}
