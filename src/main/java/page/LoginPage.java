package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;//we need to make this driver the same driver as in BrowserFactory Class and LoginTest class 
	//and for that we are going to use parameterized constructor of class LoginPage 
	//which will take driver as parameter and will be invoked in LoginTest class of test package by passing 
	//the driver of LoginTest class which ultimately is same driver as in BrowserFactory
	//(since we are returning the driver from BrowserFactory class to LoginTest class in init())
	
	//In Page Object Model instead of declaring and assigning the elements using WebElement or By class we do it using @FindBy annotation
	//@FindBy(how=How.WebLocator, using="eg: xpath or css" WebElement varName;
	//The @FindBy annotation is used to declare and initialize web element variables using the desired web locators in Selenium. 
	//Hence, you can find the web elements using popular locators like ID, Name, Link Text, Class Name, etc.
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@name='login']") WebElement SIGNIN_BUTTON_ELEMENT;

	
	  public LoginPage(WebDriver driver) {//parameterized constructor with
	  //argument as WebDriver to refer to the driver in BrowserFactory and LoginTest class 
		  this.driver=driver;//referring to global driver in LoginPageclass 
		  }
	 	
	//Now we have to make interactable methods 
	//these can be made 1. individually in separate methods or 2. all in one method
	/*public void callingMethods(String userName,String password) {
		insert(USERNAME_ELEMENT,userName);
		insert(PASSWORD_ELEMENT,password);
		clickElement(SIGNIN_BUTTON_ELEMENT);
	}*/
	//method 1:making individual methods
	public void insertUserName(String username) {
		USERNAME_ELEMENT.sendKeys(username);
	}
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	public void clickSignInButton()
	{
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	//method2 : one method with all functionality
//	public void performLogin(String username, String password) {
//		USERNAME_ELEMENT.sendKeys(username);
//		PASSWORD_ELEMENT.sendKeys(password);
//		SIGNIN_BUTTON_ELEMENT.click();
//	}
	
	
}
