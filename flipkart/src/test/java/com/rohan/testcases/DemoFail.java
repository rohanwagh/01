package com.rohan.testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rohan.base.TestBase;

public class DemoFail extends TestBase
{
	static Logger log = LogManager.getLogger();

	@BeforeClass
	public static void initializeExtentTest()
	{
		test = report.startTest("failTest");
	}
	@Test
	public void faliTest() throws IOException, InterruptedException 
	{
		
		test.log(LogStatus.ERROR, "DemoFail Test Failed");
		File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source_file, new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\extentReports\\DemoFail.png"));
		test.log(LogStatus.FAIL, test.addScreenCapture(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\extentReports\\DemoFail.png"));
		Assert.assertTrue(false);
	}
	@AfterClass
	public void endExtentTest()
	{
		
	}

}
