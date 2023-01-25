package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ListCustomerPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),' Import')]")
	WebElement IMPORT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]/a")
	WebElement NAME_DISPLAYEDINTABLE_ELEMENT;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validatingImportButton() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertEquals(IMPORT_BUTTON_ELEMENT.getText(), "Import", "List customer page not found");
	}

	public void validatingAddedCustomer(String name) {
	
		Assert.assertEquals(NAME_DISPLAYEDINTABLE_ELEMENT.getText(),name , "Entry not created");
	}

	/*
	 * Dealing with Dynamic table Xpath for names in table on List Customer Page
	 * //tbody/tr[1]/td[3] //tbody/tr[2]/td[3] //tbody/tr[3]/td[3] Here everything
	 * is same except for row no which is changing it can also be written as:
	 * //tbody/tr[i]/td[3] To make this as actual xpath we can store first part and
	 * last part of this xpath in string variables
	 */

	/*
	 * String firstPart_xpath="//tbody/tr["; String lastPart_xpath="]/td[3]"; public
	 * void validatingAddedCustomers() { for(int i=1;i<=10;i++) {//getting ten names
	 * from table(i is 1-10) String
	 * namesFromList=driver.findElement(By.xpath(firstPart_xpath+i+lastPart_xpath)).
	 * getText();//storing the String we get from the xpath
	 * //System.out.println(namesFromList);
	 * Assert.assertEquals(namesFromList,AddCustomerPage.
	 * insertedName,"name not found"); break;//as soon as we get a match between
	 * inserted name and actual name break out of loop and assert it }
	 */
}
