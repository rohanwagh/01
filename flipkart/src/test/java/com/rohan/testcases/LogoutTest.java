package com.rohan.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;
import com.rohan.pages.AccountPage;

public class LogoutTest extends TestBase
{
	static Logger log = LogManager.getLogger();
	
	@BeforeClass
	public static void initializeExtentTest()
	{
		test = report.startTest("LogoutTest");
	}
	@Test(dependsOnMethods = {"com.rohan.testcases.LoginTest.logIn"})
	public void logOut() throws IOException
	{
		AccountPage a1 = new AccountPage(); 
		a1.logOut();
		log.info("Logout Test Success");
		test.log(LogStatus.PASS, "Logout Test Success");
	}

	@AfterClass
	public void endExtentTest()
	{
		
	}
}
