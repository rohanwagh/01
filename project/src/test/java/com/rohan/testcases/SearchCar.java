package com.rohan.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;

public class SearchCar extends TestBase
{
	static Logger log = LogManager.getLogger();
	
	
	@BeforeClass
	public static void initializeExtentTest()
	{
		test= report.startTest("Search Car Test");
	}
	
	@Test
	public void searchCar()
	{
		log.info("Car Searched successfully");
		test.log(LogStatus.PASS, "Car Searched successfully");
	}
	
	public void endExtentTest()
	{
		
	}

}
