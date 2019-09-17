package com.rohan.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	/*
	 * WebDriver Properties Logs ExtentReports DB Excel Mailing
	 * 
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static ExtentReports report;
	public static ExtentTest test;
	public static Logger log = LogManager.getLogger();
	
	@BeforeSuite
	public static void initializeExtentReports()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\extentReports\\ExtentReportResults.html");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\extent-config.xml"));
		
	}
	
	@BeforeSuite
	public static void setUp() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\java\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config file lodded");
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\java\\resources\\properties\\objectRepository.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				or.load(fis);
				log.info("Object Repository Lodded");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\resources\\executable\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Driver created");

		}
		else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\src\\java\\test\\resources\\executable\\operadriver.exe");
			driver = new OperaDriver();
		}
		else {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\java\\resources\\executable\\IEdriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(config.getProperty("testSiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.warn("Driver initialized");
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(3000);
		if (driver != null) {
			driver.close();
			driver = null;
		}
	}
	
	@AfterSuite
	public void endExtentReport()
	{
		report.endTest(test);
		report.flush();
	}
	
	public ArrayList<ArrayList<String>> readData(String sheetName) throws IOException
	{
		File file =    new File(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\excel\\testData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook testData = new XSSFWorkbook(inputStream);
		Sheet sheet = testData.getSheet(sheetName);
		Row row = null;
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		ArrayList<ArrayList<String>> loginData = new ArrayList<ArrayList<String>>();
		for(int i=0; i<rowCount; i++)
		{	
			loginData.add(new ArrayList<String>());
			row = sheet.getRow(i);
			int cellCount = row.getLastCellNum()-row.getFirstCellNum();
			for(int j=0; j<cellCount; j++)
				{				
					loginData.get(i).add(j, row.getCell(j).getStringCellValue());		
				}
		}
		testData.close();
		return loginData;
	}

}
