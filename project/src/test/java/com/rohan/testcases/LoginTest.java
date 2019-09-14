package com.rohan.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;
import com.rohan.pages.HomePage;
import com.rohan.pages.LoginPage;

public class LoginTest extends TestBase 
{
	static Logger log = LogManager.getLogger();

	@BeforeClass
	public static void initializeExtentTest()
	{
		test = report.startTest("LoginTest");
	}
	@Test
	public void logIn() throws IOException, InterruptedException 
	{
		HomePage h1= new HomePage();
		h1.navigateToLoginPage();
		LoginPage l1= new LoginPage();
		l1.Login();
		l1.checkLogin();
		log.info("Login Test Success");
		test.log(LogStatus.PASS, "Login Test Success");
		Thread.sleep(2000);
	}
	@AfterClass
	public void endExtentTest()
	{
		
	}
}
