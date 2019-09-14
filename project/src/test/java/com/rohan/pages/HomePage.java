package com.rohan.pages;

import org.openqa.selenium.By;
import com.rohan.base.TestBase;

public class HomePage extends TestBase
{
	
	By myAccDropDown= By.xpath(or.getProperty("myAccDropDown"));
	By userLogin	= By.xpath(or.getProperty("userLogin"));
		
	public void navigateToLoginPage()
	{
		driver.findElement(myAccDropDown).click();
		driver.findElement(userLogin).click();
		
	}

	
}
