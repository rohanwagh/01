package com.rohan.listeners;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.rohan.base.TestBase;

public class TestListener extends TestBase implements ITestListener 
{
	static Logger log = LogManager.getLogger();
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");
		log.info(result.getName()+" test case started");
		
	}
	
	public void onTestSuccess(ITestResult result) {
		log.info(result.getName()+" test case completed successfully");
		
	}
	
	public void onTestFailure(ITestResult result) {
		log.fatal(result.getName()+" test case failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		log.info(result.getName()+" test case skiipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
