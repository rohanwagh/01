package com.rohan.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import com.rohan.base.TestBase;

public class Rough extends TestBase
{
//	public void readLoginData(String filePath,String fileName,String sheetName) throws IOException{
//
//    //Create an object of File class to open xlsx file
//
//    File file =    new File(filePath+"\\"+fileName);
//
//    //Create an object of FileInputStream class to read excel file
//
//    FileInputStream inputStream = new FileInputStream(file);
//
//    Workbook TestData = null;
//
//    //Find the file extension by splitting file name in substring  and getting only extension name
//
//    String fileExtensionName = fileName.substring(fileName.indexOf("."));
//
//    //Check condition if the file is xlsx file
//
//    if(fileExtensionName.equals(".xlsx")){
//
//    //If it is xlsx file then create object of XSSFWorkbook class
//
//    TestData = new XSSFWorkbook(inputStream);
//
//    }
//
//    //Check condition if the file is xls file
//
//    else if(fileExtensionName.equals(".xls")){
//
//        //If it is xls file then create object of HSSFWorkbook class
//
//        TestData = new HSSFWorkbook(inputStream);
//
//    }
//
//    //Read sheet inside the workbook by its name
//
//    Sheet loginSheet = TestData.getSheet(sheetName);
//
//    //Find number of rows in excel file
//
//    int rowCount = loginSheet.getLastRowNum()-loginSheet.getFirstRowNum();
//
//    //Create a loop over all the rows of excel file to read it
//
//    for (int i = 0; i < rowCount+1; i++) {
//
//        Row row = loginSheet.getRow(i);
//
//        //Create a loop to print cell values in a row
//
//        for (int j = 0; j < row.getLastCellNum(); j++) {
//
//            //Print Excel data in console
//
//            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
//
//        }
//
//        System.out.println();
//    } 
//
//    }  

	public ArrayList<ArrayList<String>> readLoginData(String filePath,String fileName,String sheetName) throws IOException
	{
		File file =    new File(filePath+"\\"+fileName);
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
	
    //Main function is calling readExcel function to read data from excel file

    public static void main(String...strings) throws IOException{

    //Create an object of ReadGuru99ExcelFile class

    Rough objRough = new Rough();

    //Prepare the path of excel file

    String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\excel\\";

    //Call read file method of the class to read data

    ArrayList<ArrayList<String>> a = objRough.readLoginData(filePath,"Testdata.xlsx","loginDetails");
    System.out.println(a);

    }

}



