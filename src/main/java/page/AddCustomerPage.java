package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{

	WebDriver driver;
	String insertedName;//-->using getter setter to get value
	
	

	@FindBy(how = How.XPATH, using = "//h5[text()='Add Contact']")
	WebElement ADDCONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@class='navbar-minimalize minimalize-styl-2 btn btn-primary btn-flat']")
	WebElement BUTTON_CLICK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement FULLNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANYDROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	WebElement COUNTRYDROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']")
	WebElement TAGSDROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SAVEBUTTON_ELEMENT;
	/*
	 * @FindBy(how = How.XPATH, using = "//a[@id='summary']") WebElement
	 * SUMMARY_BUTTON_ELEMENT;
	 * 
	 * @FindBy(how = How.XPATH, using = "//a[text()='List Customers']") WebElement
	 * LIST_CUSTOMER_ELEMENT;
	 * 
	 * @FindBy(how = How.XPATH, using =
	 * "//div[@id='page-wrapper']/div[3]/descendant::table/tbody/descendant::td[3]/a")
	 * WebElement NAME_ELEMENT;
	 */

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validatingAddContactHeader(String validationText) {
//		WebDriverWait wait=new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOf(ADDCONTACT_HEADER_ELEMENT));
		BUTTON_CLICK_ELEMENT.click();//due to error in page load
		Assert.assertEquals(ADDCONTACT_HEADER_ELEMENT.getText(), validationText, "Add Contact page not found");
		
	}
	//static String insertedName;
	public void insertingFullName(String fullName) {
		int random=randomNumberGenerator(999);
		insertedName=fullName+random;
		FULLNAME_ELEMENT.sendKeys(insertedName);
		
	}
	//getter setter to access insertedName in other classes
	public String getInsertedName() {
		return insertedName;
	}

	public void setInsertedName(String insertedName) {
		this.insertedName = insertedName;
	}

	public void selectCompanyName(String visibleTextCompany) {
		Select sel = new Select(COMPANYDROPDOWN_ELEMENT);
		sel.selectByVisibleText(visibleTextCompany);
	}


	public void insertingEmail(String firstpart_email,String lastpart_email) {
		int random=randomNumberGenerator(999);
		EMAIL_ELEMENT.sendKeys(firstpart_email+random+lastpart_email);
	}
	public void insertingPhone(String phone) {
		int random=randomNumberGenerator(999);
		PHONE_ELEMENT.sendKeys(phone+random);
	}

	public void insertingAddress(String address) {
		ADDRESS_ELEMENT.sendKeys(address);
	}

	public void insertingCity(String city) {
		CITY_ELEMENT.sendKeys(city);
	}

	public void insertingState(String state) {
		STATE_ELEMENT.sendKeys(state);
	}

	public void insertingZip(String zip) {
		ZIP_ELEMENT.sendKeys(zip);
	}

	public void selectCountry(String visibleTextCountry) {
		Select sel = new Select(COUNTRYDROPDOWN_ELEMENT);
		sel.selectByVisibleText(visibleTextCountry);
	}

	public void selectTags(String visibleTextTag) {
		Select sel = new Select(TAGSDROPDOWN_ELEMENT);
		sel.selectByVisibleText(visibleTextTag);
	}

	public void clickSaveButton() {
		SAVEBUTTON_ELEMENT.click();
	}



}
