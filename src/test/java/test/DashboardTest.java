package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class DashboardTest{

	WebDriver driver;
	
	@Test
	public void customerShouldBeAbleToClickCustomerAndAddCustomerButton() {
		driver=BrowserFactory.init();
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSignInButton();
	
		DashboardPage dashBoardPage=PageFactory.initElements(driver, DashboardPage.class);
		//Asserting and clicking customer button and addcust button to go to add contact pageS
		dashBoardPage.validatingDashboardPage("Dashboard");
		dashBoardPage.clickCustomers();
		dashBoardPage.clickAddCustomers();
		
		BrowserFactory.tearDown();
	}
	
}
