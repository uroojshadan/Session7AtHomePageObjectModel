package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import page.ProfilePage;
import util.BrowserFactory;

public class AddCustomerTest {
	//separate class for AddCustomerTest

	WebDriver driver;
	
	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException {
		driver=BrowserFactory.init();
		
		//login into application
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName("demo@techfios.com");
		loginPage.insertPassword("abc123");
		loginPage.clickSignInButton();
	
		DashboardPage dashBoardPage=PageFactory.initElements(driver, DashboardPage.class);
		//Asserting and going to add contact
		dashBoardPage.validatingDashboardPage("Dashboard");
		dashBoardPage.clickCustomers();
		dashBoardPage.clickAddCustomers();
		
		//Add Contact page and adding a new contact
		AddCustomerPage addCustomerPage=PageFactory.initElements(driver, AddCustomerPage.class);
		
		//addContactPage.callingmethods();//when inheriting BaseClass in LoginPage Class
		addCustomerPage.validatingAddContactHeader("Add Contact");
		addCustomerPage.insertingFullName("US");//getting the finalNameText as 
		//fullName+random(since insertingFullname() returns string fullName_random to make it unique) and passing it to validatingCustomer to assert
		addCustomerPage.selectCompanyName("Amazon");
		addCustomerPage.insertingEmail("US","@gmail.com");
		addCustomerPage.insertingPhone("123");
		addCustomerPage.insertingAddress("10-2-9-8/asdh/hhh");
		addCustomerPage.insertingCity("Allen");
		addCustomerPage.insertingState("TX");
		addCustomerPage.insertingZip("24444");
		addCustomerPage.selectCountry("United States");
		addCustomerPage.selectTags("Enrico");
		addCustomerPage.clickSaveButton();
		Thread.sleep(2000);
		
		String insertedname=addCustomerPage.getInsertedName();
		
		//ProfilePage and validating it using insertedName on it
		ProfilePage profilePage=PageFactory.initElements(driver, ProfilePage.class);
		profilePage.validatingProfilePage(insertedname);
		//ProfilePage and validating it using summary button on that page
		//profilePage.validatingSummaryButton();
		

		dashBoardPage.clickListCustomer();//since ListCustomers is on DahboardPage
		
		ListCustomerPage listCustomerPage=PageFactory.initElements(driver, ListCustomerPage.class);
	
		listCustomerPage.validatingImportButton();//to validate that we are on listcustomerpage
		//to validate that the customer we added is showing in the table
		listCustomerPage.validatingAddedCustomer(insertedname);//-->when not using dynamic table method(see session 9 at home)
		//listCustomerPage.validatingAddedCustomers();//from table on list customer page
		
		BrowserFactory.tearDown();
		
	}
	
}
