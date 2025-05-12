package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlan {
	
	@FindBy(xpath="//div[text()=' Next '] ") private WebElement nextButton;
	
	public CoverFoxHealthPlan(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void nextButton()
	{
		Reporter.log("clicking on next button for health page ",true);
		nextButton.click();
	}

}
