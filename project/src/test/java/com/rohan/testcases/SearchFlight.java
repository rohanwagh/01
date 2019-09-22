package com.rohan.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;
import com.rohan.pages.HomePage;

public class SearchFlight extends TestBase
{
	static Logger log = LogManager.getLogger();
	@BeforeClass
	public static void initializeExtentTest()
	{
		test= report.startTest("Search Flight Test");
	}
	@Test
	public void searchFlight()
	{
		
		HomePage h1 = new HomePage();
		h1.searchFlightCity();
		log.info("Flight Searched successfully");
		test.log(LogStatus.PASS, "Flight Searched successfully");
	}
}
