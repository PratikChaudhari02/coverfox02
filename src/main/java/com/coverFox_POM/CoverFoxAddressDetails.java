package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetails {
	
	@FindBy(xpath="(//input[@type='number'])[1]") private WebElement pin;
	@FindBy(xpath="(//input[@type='number'])[2]") private WebElement mobileNo;
	@FindBy(xpath="//div[text()='Continue']") private WebElement continueButton;
	
	public CoverFoxAddressDetails(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Enterpin(String pincode) 
	{
		Reporter.log("entering pin code",true);
		pin.sendKeys(pincode);
	}
	public void EnterMobileNo(String EnterMobileNos)
	{
		Reporter.log("entering mobile no ",true);
		mobileNo.sendKeys(EnterMobileNos);
	}
	public void ContinueButtonClick()
	{
		continueButton.click();
	}
	

}
