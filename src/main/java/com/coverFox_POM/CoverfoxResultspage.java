package com.coverFox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxResultspage {
	
	@FindBy(xpath="//div[contains(text(),'Health Insurance Plans')]")private WebElement matchingresult;
	@FindBy(className = "pcc-plan-detail") private List<WebElement> Planresult;
	
	
	public CoverfoxResultspage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void result() throws InterruptedException
	{
		Thread.sleep(3000);
		String results = matchingresult.getText();
		System.out.println(results);
		String[] res = results.split(" ");
		
	int resultInNo = Integer.parseInt(res[0]);
	System.out.println(resultInNo);
	
	if (resultInNo == Planresult.size()) 
	{
		System.out.println("tc is pass");
	}else
	{
		System.out.println("tc is fail");
	}
	
		
	}
	
	
	public int getPlanNumberFormText() throws InterruptedException
	{
		Thread.sleep(3000);
		Reporter.log("getting plan no form text",true);
		String resultss = matchingresult.getText();
		String[] result1 = resultss.split(" ");
		int planno = Integer.parseInt(result1[0]);
		return planno ;
		
	}
	public int getPlanNumberplancards() throws InterruptedException
	{
		Thread.sleep(3000);
		Reporter.log("getting plan no form plan cards",true);
		int results = Planresult.size();
		return results;
		
		
	}

}
