package com.amazon.test;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.amazon.base.TestBase;
import com.amazon.pages.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ShoppingPageTest extends TestBase {
  public HomePage homepage;
  com.amazon.pages.ShoppingPage shoppingpage;
  public  Logger logger = Logger.getLogger(ShoppingPageTest.class.getName());

  public ShoppingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void homePage() throws InterruptedException {	 
		Intialization();	
        homepage = new HomePage();
       	 homepage.homePageMenu();  
       	logger.info("Click on Home page Menu");
         homepage.homePagelink();
         logger.info("Click on Home page Link");
        shoppingpage = homepage.homePageProduct();
        logger.info("Click on Home page product");
	}    
	@Test
	public void verifyShoppingPageTitle() throws InterruptedException{
	logger.info("Test Started : Verify Shopping Page Title");
	ExtentTest extTests = extent.createTest("Test Amazon Shopping Title");	
	
	String ShoppingTitle =	shoppingpage.verifyShoppingPageTitle();
	logger.info("Page title Captured as:  " + ShoppingTitle);
	if (ShoppingTitle.equals("All-new Kindle (2022 release) – The lightest and most compact Kindle, now with a 6” 300 ppi high-resolution display, and 2x the storage - Black : Amazon.ca: Everything Else")) {
		extTests.log(Status.PASS, "ShoppingPageTitle Pass : expected and Actual Title are same - " + ShoppingTitle);
		logger.info("ShoppingPageTitle Pass : expected and Actual Title are same - " + ShoppingTitle);
	} else {
		extTests.log(Status.FAIL, "ShoppingPageTitle Fail : Expected and actual Title are not same - " + ShoppingTitle);
		logger.error("ShoppingPageTitle Fail : Expected and actual Title are not same - " + ShoppingTitle);
	}
	
	}
		@Test
	public void ShoppingPage() throws InterruptedException {
     shoppingpage.clickOnBuyNow();	   
 	ExtentTest extTests = extent.createTest("Test Amazon Buy Now functionality");
 	extTests.log(Status.PASS, "Clicking on BuyNow Pass");	
	}
	
	@AfterMethod
	 public void teardown() {
		 driver.quit();

	}
}