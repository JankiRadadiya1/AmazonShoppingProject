package com.amazon.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.base.TestBase;


public class HomePage extends TestBase {
	
	 @FindBy(xpath="//input[@id='captchacharacters']/preceding::a")
	 WebElement verification;

	 @FindBy(xpath="//div[@id='nav-main']/descendant::i[1]")
	  WebElement homePageMenu ;
	 
	 @FindBy(linkText="Kindle")
	 WebElement homePagelink;
	 
	 @FindBy(linkText="All-new Kindle")
	 WebElement kindleEReader;

	 
	   public HomePage() {
		   PageFactory.initElements(driver, this);
		 
	   }
	  public String validateTitle() {
		 String title= driver.getTitle();
	     return title;
	  } 
	  public void homePageMenu() throws InterruptedException {
			Thread.sleep(5000);
	    homePageMenu.click();
	  }
	  public void  homePagelink() throws InterruptedException {
			Thread.sleep(5000);
		   homePagelink.click();
	}
	 public ShoppingPage homePageProduct() {
		  kindleEReader.click();
		  return new ShoppingPage();
	}
}


