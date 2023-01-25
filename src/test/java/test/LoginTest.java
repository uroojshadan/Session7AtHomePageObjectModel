package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;//importing class BrowserFactory from package util to use its methods

public class LoginTest {
	WebDriver driver;//this driver should be same as the driver returned from BrowserFactory class of package util 
	//and therefore assigning it to driver from LoginTest class of test package
	@Test
	public void validUserShouldBeAbleToLogin() {
		
		driver=BrowserFactory.init();
		
		//To access methods of LoginPage into LoginTest we create object of class Loginpage
		//LoginPage loginPage=new LoginPage();-->this will not work in PageObjectModel 
		//In Page Object Model we define objects using PageFactory class and using initElements(driver,nameOfClass.class)
		//creating object of LoginPage to call the methods in LoginTest class of test package
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		//we are using PageFactory to initialize WebElements by @FindBy in LoginPage 
		//and hence we are not using the new Keyword to create object
		
		//initElements() from PageFactory Class, takes 
		//LoginPage Class parameterized Constructor and initializing it with  the driver passed to initElements()
		
		//loginPage.callingMethods("demo@techfios.com","abc123");//when inheriting BaseClass in LoginPage Class
		
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSignInButton();
		
	
	
		DashboardPage dashBoardPage=PageFactory.initElements(driver, DashboardPage.class);
		//Asserting Dashboard page
		dashBoardPage.validatingDashboardPage("Dashboard");
		
		BrowserFactory.tearDown();
		
	}

}
