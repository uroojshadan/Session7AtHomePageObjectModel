package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProfilePage {

	WebDriver driver;
	
	/*
	 * @FindBy(how = How.XPATH, using = "//a[@id='summary']") WebElement
	 * SUMMARY_BUTTON_ELEMENT;
	 */
	@FindBy(how=How.XPATH, using="//div[@class='ibox-title']/h5") WebElement NAME_DISPLAYED_ELEMENT;

	public ProfilePage(WebDriver driver) {

		this.driver=driver;
	}
	public void validatingProfilePage(String name) throws InterruptedException {
		Thread.sleep(2000);
		
		Assert.assertEquals(NAME_DISPLAYED_ELEMENT.getText(),name,"Profile page not found");
	}
	/*
	 * public void validatingSummaryButton() {
	 * Assert.assertEquals(SUMMARY_BUTTON_ELEMENT.getText(), "Summary",
	 * "Profile not created"); }
	 */

	
}
