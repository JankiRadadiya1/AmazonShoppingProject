package com.amazon.test;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class HomePageTest extends TestBase {
	HomePage homepage;
	public  Logger logger = Logger.getLogger(HomePageTest.class.getName());

	public HomePageTest() {
		super();                   
	}
	@BeforeSuite
	public void initializileReport() {
	      extent = new ExtentReports();
		  ExtentSparkReporter spark = new ExtentSparkReporter("AmazonTest.html");
	      extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void homePage() throws InterruptedException {	 
		Intialization();	
        homepage = new HomePage();
	}
	@Test
	public void homePageTitleTest() {
		
	        logger.info("Test Started: Verify Home Page Title");	
		    ExtentTest extTests = extent.createTest("Amazon HomePage Title");
		   String HomePageTitle = homepage.validateTitle();
		if(HomePageTitle.equals("Amazon.ca: Low Prices – Fast Shipping – Millions of Items")) {
			extTests.log(Status.PASS,"HomePageTitle Pass: expected and Actual are mataching " + HomePageTitle );
			logger.info("HomePageTitle Pass:Expected and Actual are same");
		}else {
			extTests.log(Status.FAIL, "ShoppingPageTitle Fail : Expected and actual Title are not same - " + HomePageTitle);
			logger.error("ShoppingPageTitle Fail : Expected and actual Title are not same - " + HomePageTitle);		
		}}
	@Test
	public void clickOnMenu() throws InterruptedException {
		homepage.homePageMenu();	
		homepage.homePagelink();
        homepage.homePageProduct();   	
    	ExtentTest extTests = extent.createTest("Test Amazo Home Links");  	
    	extTests.log(Status.PASS, "Clicking on Menu Pass");
    
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();	
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}	
}
