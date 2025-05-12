package com.coverFox_TestNG;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_POM.CoverFoxAddressDetails;
import com.coverFox_POM.CoverFoxHealthPlan;
import com.coverFox_POM.CoverFoxHomePage;
import com.coverFox_POM.CoverFoxMemberDetails;
import com.coverFox_POM.CoverfoxResultspage;
import com.coverFox_Utility.Utility;



public class CoverFoxUsingTestNG extends Base {
  
	public static Logger logger;

		CoverFoxHomePage coverFoxHomePage;
		CoverFoxMemberDetails coverFoxMemberDetails;
		CoverFoxAddressDetails coverFoxAddressDetails;
		CoverFoxHealthPlan coverFoxHealthPlan;
		CoverfoxResultspage coverfoxResultspage;
		
		@BeforeClass
		public void launchBrowser() throws EncryptedDocumentException, IOException
		{
			{
				  logger= Logger.getLogger("23rdNov24_CoverFox");
				  PropertyConfigurator.configure("log4j.properties");
				  logger.info("Welcome To CoverFoxTesting ");
			  }

			 openBrowser();
			 logger.info("launching Browser");
			 coverFoxHomePage = new CoverFoxHomePage(driver);
			 coverFoxMemberDetails=new CoverFoxMemberDetails(driver);
			 coverFoxAddressDetails=new CoverFoxAddressDetails(driver);
			 coverFoxHealthPlan =new CoverFoxHealthPlan(driver);
			 coverfoxResultspage = new CoverfoxResultspage(driver);
			  
	  }
	  @BeforeMethod
	  public void coverFoxPrecondition() throws InterruptedException, EncryptedDocumentException, IOException
	  {
		  
		  coverFoxHomePage.getStarted();
		  logger.info("Clicking On Gender");
		  coverFoxHealthPlan.nextButton();
		  logger.info("Click In Next Button Health Page");
		  coverFoxMemberDetails.dropdown(Utility.readDataFromExcel("Sheet3",1,0));
		  logger.info("HandleAgeDropDown");
		  coverFoxMemberDetails.clickNextButton();
		  logger.info("click on coverFox Member Details ");
		  coverFoxAddressDetails.Enterpin(Utility.readDataFromExcel("Sheet3", 1, 1));
		  logger.info("enter pin code");
		  coverFoxAddressDetails.EnterMobileNo(Utility.readDataFromExcel("Sheet3", 1, 2));
		  logger.info("enter mobile no");
		  coverFoxAddressDetails.ContinueButtonClick();
		  logger.info("Clicking on coverFox address details");
		  Thread.sleep(3000);
		  
 }
	  @Test
	  public void validatePlancardAndText() throws InterruptedException, IOException 
	  {

		  int test = coverfoxResultspage.getPlanNumberFormText();
		  int test2 = coverfoxResultspage.getPlanNumberplancards();
	
		  Assert.assertEquals(test,test2,"tc is faild if record is not match");
		  
		  Reporter.log("plan no are matching Tc is passed",true);
		  Utility.screenShort(driver,"validatePlancardAndText");
		  logger.warn("if test case is failed");
		
		  
	  }
	  @AfterClass
	  public void Closebrowsers() throws InterruptedException {
	  
		closeBrowserWindow();
	  }
}
