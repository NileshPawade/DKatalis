package com.midtrans.demo.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.midtrans.demo.reports.LoggerHelper;
import com.midtrans.demo.utilities.CommonUtlities;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	private final static Logger log=LoggerHelper.getLogger(TestBase.class);
	public TestBase() {
		
		
		
		prop = new Properties();
		
		File file = new File(System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialisation() {
		
		if (prop.getProperty("browser").equals("chrome")&&prop.getProperty("os").equals("windows")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/drivers/chromedriver.exe");
			
			driver = new ChromeDriver();
			log.info("Chrome browser launched for :"+prop.getProperty("os")+"Operating system");
		}

		else if (prop.getProperty("browser").equals("firefox")&&prop.getProperty("os").equals("windows")) {

			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();
			
			log.info("Firefox browser launched for :"+prop.getProperty("os")+"Operating system");

		}
		if (prop.getProperty("browser").equals("chrome")&&prop.getProperty("os").equals("ubuntu")) {
			
			//Not required for latest chrome browser so commented
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/drivers/chromedriver");
			
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new ChromeDriver();
			log.info("Chrome browser launched for :"+prop.getProperty("os")+"Operating system");
		}

		else if (prop.getProperty("browser").equals("firefox")&&prop.getProperty("os").equals("ubuntu")) {
			
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			//System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/drivers/geckodriver.exe");

			driver = new FirefoxDriver();
			log.info("firefox browser launched for :"+prop.getProperty("os")+"Operating system");

		}

		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		log.info("Browser window maximised");
		
		driver.manage().deleteAllCookies();
		log.info("All Browser cookies Cleared");
		
		driver.manage().timeouts().implicitlyWait(CommonUtlities.implicitWait, TimeUnit.SECONDS);
		log.info("Implicit wait set to"+CommonUtlities.implicitWait);
		
		driver.manage().timeouts().pageLoadTimeout(CommonUtlities.PageLoadtimeOut, TimeUnit.SECONDS);
		log.info("Page Load time Out set to:"+CommonUtlities.PageLoadtimeOut);
		
		driver.get(prop.getProperty("url"));
		log.info("URL hit:"+prop.getProperty("url"));
	}
	

}
