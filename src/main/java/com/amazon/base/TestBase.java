package com.amazon.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
    public static ExtentReports extent;
    public static Logger logger = Logger.getLogger(TestBase.class.getName());

		public TestBase() {                              
		try { 
			PropertyConfigurator.configure("src/main/java/com/amazon/config/log.properties");
			String path = System.getProperty("user.dir")+"/src/main/java/com/amazon/config/config.properties";
			prop = new Properties();
			FileInputStream st = new FileInputStream(path);
			prop.load(st);	
			
		}catch(FileNotFoundException e){	
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
				  
		}}
		
		public static void Intialization() throws InterruptedException{
			
			String browserName = prop.getProperty("browser");
			logger.info("Browser select : " + browserName);
			if(browserName.equals("chrome")) {
				     WebDriverManager.chromedriver().setup();
			         driver = new ChromeDriver();
			         logger.info("chrome Browser Opened");
			    }else if(browserName.equals("Firefox")) {
				     WebDriverManager.firefoxdriver().setup();
				     driver = new FirefoxDriver();
				     logger.info("FireFox Browser Opened");
			   }else if(browserName.equals("Safari")) {
			         WebDriverManager.safaridriver().setup();
			         driver = new SafariDriver();
			         logger.info("Safari Browser Opened");
			    }else {
			         Assert.assertTrue(false,"No Browser opened");
			    }
				
		    
	      driver.manage().window().maximize();
	      logger.info("Window is Maximized");
		  driver.manage().deleteAllCookies();
		  logger.info("Delete All Cookies");;
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(prop.getProperty("url"));  
		  logger.info("Amazon Link is Opening");
	}	
}
 