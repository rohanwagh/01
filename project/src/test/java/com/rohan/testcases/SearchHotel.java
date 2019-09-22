package com.rohan.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;

public class SearchHotel extends TestBase
{
	static Logger log = LogManager.getLogger();
	@BeforeClass
	public static void initializeExtentTest()
	{
		test= report.startTest("Search Hotel Test");
	}
//	@Test
	public void searchHotel()
	{
		log.info("Hotel Searched successfully");
		test.log(LogStatus.PASS, "Hotel Searched successfully");
	}
}
