package com.coverFox_POM;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetails {
	
	
	@FindBy(id = "Age-You")private WebElement dropDown;
	@FindBy(xpath="//div[text()='Next']") private WebElement NextButton;
	
	public CoverFoxMemberDetails(WebDriver driver)
	{
		PageFactory .initElements(driver,this );
	}
	
	public void dropdown(String i)
	{
		Reporter.log("selecting drowdown for age",true);
		Select selectDropDown =new Select(dropDown);
		selectDropDown.selectByContainsVisibleText( i);			
			
	}
	public void clickNextButton()
	{
		Reporter.log(" clicking on Next Button member page", true);
		NextButton.click();
	}


		
	
	

}
