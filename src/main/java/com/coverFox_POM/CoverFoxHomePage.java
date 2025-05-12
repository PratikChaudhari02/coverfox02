package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class CoverFoxHomePage {

		//1 initilize
		@FindBy(xpath= "//button[text()='Get Started']") private WebElement getStartedButton;
		
		//2	constactor
		
		public CoverFoxHomePage (WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//3 methods
		
		public void getStarted()
		{
			Reporter.log("CLicking on gender",true);
			getStartedButton.click();
		}
		
}

