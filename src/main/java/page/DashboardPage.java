package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement DASHBOARDHEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']")
	WebElement CUSTOMERS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Add Customer']")
	WebElement ADDCUSTOMER_ELEMENT;
//	@FindBy(how = How.XPATH, using = "//a[@class='navbar-minimalize minimalize-styl-2 btn btn-primary btn-flat']")
//	WebElement BUTTON_CLICK_ELEMENT;
//	
	@FindBy(how = How.XPATH, using = "//a[text()='List Customers']")
	WebElement LIST_CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[@id='page-wrapper']/div[3]/descendant::table/tbody/descendant::td[3]/a")
	WebElement NAME_ELEMENT;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validatingDashboardPage(String validationText) {
		Assert.assertEquals(DASHBOARDHEADER_ELEMENT.getText(), validationText, "Dashboard Page not found");
	}

	public void clickCustomers() {
		CUSTOMERS_ELEMENT.click();
	}

	public void clickAddCustomers() {
		ADDCUSTOMER_ELEMENT.click();
		//BUTTON_CLICK_ELEMENT.click();// can comment this when page loads properly
	}
	public void clickListCustomer() throws InterruptedException {
		Thread.sleep(2000);
		LIST_CUSTOMER_ELEMENT.click();
	}

	public void validatingCustomer(String visibleTextCustomer) {
		
		Assert.assertEquals(NAME_ELEMENT.getText(), visibleTextCustomer, "Customer not found");
	}

}
