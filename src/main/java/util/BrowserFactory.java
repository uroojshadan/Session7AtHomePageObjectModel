package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {//this class contains the init() and teardown() and calling this class' methods in 
	//LoginTest class of test package by className.methodName
	static WebDriver driver;
	

	public static WebDriver init() {//making every method static(and web driver static so that it can be accessed inside static methods) 
		//here since we are going to access the methods
		//of this class in LoginPage class of page package without creating objects
		//returning web driver in the init() because we want to use the same web driver in LoginTest class of test package
		System.setProperty("webdriver.chrome.driver", "/Users/comet/SeleniumWorkspace/driver/chromedriver");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("HEADLESS");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
		return driver;
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
