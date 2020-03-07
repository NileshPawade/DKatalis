package com.midtrans.demo.BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	
	public TestBase() {
		
		
		prop = new Properties();
		
		File file = new File(System.getProperty("user.dir")+"/src/main/java/Properties/config.properties");

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
		}

		else if (prop.getProperty("browser").equals("firefox")&&prop.getProperty("os").equals("windows")) {

			System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir")+"/src/main/java/com/midtrans/demo/drivers/geckodriver.exe");
			
			driver = new FirefoxDriver();

		}
		if (prop.getProperty("browser").equals("chrome")&&prop.getProperty("os").equals("ubuntu")) {
			
			WebDriverManager.chromedriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equals("firefox")&&prop.getProperty("os").equals("ubuntu")) {
			WebDriverManager.firefoxdriver().operatingSystem(OperatingSystem.LINUX).setup();
			driver = new FirefoxDriver();

		}

		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}
	

}
