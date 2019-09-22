package com.rohan.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;

public class SearchTour extends TestBase
{
	static Logger log = LogManager.getLogger();
	@BeforeClass
	public static void initializeExtentTest()
	{
		test= report.startTest("Search Tour Test");
	}
	@Test
	public void searchTour()
	{
		log.info("Tour Searched successfully");
		test.log(LogStatus.PASS, "Tour Searched successfully");
	}
}
