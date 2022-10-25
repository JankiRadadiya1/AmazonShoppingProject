package com.amazon.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class ShoppingPage extends TestBase {
	 
	 @FindBy(xpath="//input[@id='buy-now-button']")
         WebElement buynow;
	 
	 @FindBy(xpath="//label[@contains(text(),'E-mail address')]")
		 WebElement verifySigninEmail;
	 
	 public ShoppingPage() {
		 PageFactory.initElements(driver, this);
	 }
	 public String verifyShoppingPageTitle() {
		 return driver.getTitle();
	 }
	 public void clickOnBuyNow() throws InterruptedException {
		 Thread.sleep(5000);
		  buynow.click();
	 }
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 



