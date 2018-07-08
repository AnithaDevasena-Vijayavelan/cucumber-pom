package com.qa.StepDefinition;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

import org.testng.ITestResult;

import com.qa.pages.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class homePageStepDefinition extends TestBase {

	loginPage loginPage;
	homePage homePage;
	NewcontactPage NewcontactPage;
	/*public ExtentReports extent;
	public ExtentTest extentTest;
	
	@Before
	public void setExtent(){
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Anitha Mac");
		extent.addSystemInfo("User Name", "Devasena Automations");
		extent.addSystemInfo("Environment", "QA");
		
	}
	
	@After
	public void tearDown(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = TestUtil.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
		extent.flush();
		extent.close();
	}
	*/
	@Given("^User launch browser$")
	public void user_launch_browser(){
		//extentTest = extent.startTest("launchbrowser");
		TestBase.initialization();
	}

	@Then("^user is on the login page$")
	public void user_is_on_the_login_page(){
		//extentTest = extent.startTest("User login page");
		loginPage = new loginPage();
	   String loginTitle = loginPage.validateLoginPageTitle();
	   Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", loginTitle);
	}

	@Then("^user enters Username and Password$")
	public void user_enters_Username_and_Password() {
		//extentTest = extent.startTest("Entering username and password");
		homePage = new homePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^Validate the title of the home page$")
	public void validate_the_title_of_the_home_page() {
		//extentTest = extent.startTest("homepage title");
		homePage = new homePage();
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);
	}

	@Then("^validate the login username$")
	public void validate_the_login_username() {
		//extentTest = extent.startTest("username verfifcation");
		Boolean username = homePage.verifyCorrectUserName();
		Assert.assertTrue(username);
	}

	@Then("^click on the new contact$")
	public void click_on_the_new_contact() {
		//extentTest = extent.startTest("clicking new contact");
		NewcontactPage = new NewcontactPage();
	   NewcontactPage = homePage.clickOnNewContactLink();
	   driver.close();
	   driver.quit();
	}

}
