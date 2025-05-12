package com.coverFox_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import com.coverFox_Utility.Utility;

public class Base {

	protected WebDriver driver;
	public void openBrowser() throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notification");
		
		driver = new ChromeDriver(option);
		driver.get(Utility.readDataFromProperties("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		Reporter.log("Launching Browser",true);
		
	}
	public void closeBrowserWindow()
	{
		Reporter.log("closing Browser",true);
		driver.quit();
	}

}
