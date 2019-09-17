package com.rohan.pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import com.rohan.base.TestBase;

public class LoginPage extends TestBase
{
			
			By userName			=By.xpath(or.getProperty("userName"));
			By password			=By.xpath(or.getProperty("password"));
			By loginButton		=By.xpath(or.getProperty("loginButton"));
			
			
			public boolean Login() throws IOException
			{
				ArrayList<ArrayList<String>> data = readData(config.getProperty("loginDataSheet"));
				if(data.get(0).get(2).equalsIgnoreCase("valid"))
				{
				driver.findElement(userName).sendKeys(data.get(0).get(0));
				driver.findElement(password).sendKeys(data.get(0).get(1));
				}
				driver.findElement(loginButton).click();
				return true;
			}
			
			
			public boolean checkLogin()
			{
				if(driver.getTitle()=="My Account")	return true;
				return false;
			}

}
