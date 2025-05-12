package com.coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import org.testng.Reporter;


public class Utility {
	
	//readData From Excel
	
	public static String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream File= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\TestData\\testDataForCoverFox.xlsx");
		Sheet mySheet = WorkbookFactory.create(File).getSheet(sheetName);
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel",true);
		return data;
		
	}
	//screen short
	public static void screenShort(WebDriver driver, String screenShortName ) throws IOException
	{
	
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+"\\screenshot"+screenShortName+".png");
		FileHandler.copy(scr, destination);
		Reporter.log("taking screenshort saved at "+destination,true);
	}
	//scroll into view
	public static void scrollIntoView(WebDriver driver,WebElement element) 
	{
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("agruments[0].scrollIntoView(true)", element);
		 Reporter.log("scrolling into view",true);
		 
		
	}
	//properties file
	
	public static String readDataFromProperties(String key) throws IOException 
	{

		Properties prop=new Properties();
		//C:\\Users\\prati\\eclipse-workspace\\Nov23Morning_Selenium\\coverFox.properties
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\TestData\\coverFox.properties");
		prop.load(myfile);
		String value = prop.getProperty(key);
		Reporter.log("reading data from properties file",true);
		return value;
		
	}

}
