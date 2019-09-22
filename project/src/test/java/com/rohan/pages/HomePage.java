package com.rohan.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rohan.base.TestBase;

public class HomePage extends TestBase
{
	By mainFrame= By.xpath(or.getProperty("mainFrame"));
	By myAccDropDown= By.xpath(or.getProperty("myAccDropDown"));
	By userLogin	= By.xpath(or.getProperty("userLogin"));
	By searchFlightDrop = By.xpath(or.getProperty("searchFlightDrop"));
	By searchFlightCityList = By.xpath(or.getProperty("searchFlightCityList"));
	
	
	public void searchFlightCity()
	{
		driver.findElement(searchFlightDrop).sendKeys("lon");
		List<WebElement> cities =driver.findElements(searchFlightCityList); 
		for(WebElement city: cities)
		{
			if(city.getText().equalsIgnoreCase("london")) {
				city.click();
				break;
			}	
		}
	}
	
		
	public void navigateToLoginPage()
	{
		driver.findElement(myAccDropDown).click();
		driver.findElement(userLogin).click();
		
	}
}
