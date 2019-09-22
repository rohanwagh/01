package com.rohan.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rohan.base.TestBase;

public class LoginPage extends TestBase
{
			
			By userName			=By.xpath(or.getProperty("userName"));
			By password			=By.xpath(or.getProperty("password"));
			By loginButton		=By.xpath(or.getProperty("loginButton"));
			
			
			public boolean Login() throws IOException, InterruptedException
			{
				ArrayList<ArrayList<String>> data = readData(config.getProperty("loginDataSheet"));
				if(data.get(0).get(2).equalsIgnoreCase("valid"))
				{
				driver.findElement(userName).sendKeys(data.get(0).get(0));
				driver.findElement(password).sendKeys(data.get(0).get(1));
				}
				Thread.sleep(5000);
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.until(ExpectedConditions.elementToBeClickable(loginButton));
				driver.findElement(loginButton).click();
				return true;
			}
			
			
			public boolean checkLogin()
			{
				if(driver.getTitle()=="My Account")	return true;
				return false;
			}

}
