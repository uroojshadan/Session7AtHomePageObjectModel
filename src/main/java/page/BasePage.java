package page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public void asserting(WebElement element,String expected,String message) {
		Assert.assertEquals(element.getText(),expected,message);
	}
	public void clickElement(WebElement element) {
		element.click();
	}
	public void insert(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void selectDropdown(WebElement element,String visibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	public void explicitWait(WebDriver driver,int time,By byLocator) {
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	public int randomNumberGenerator(int boundaryNo){
		Random rn=new Random();
		int randomNumber=rn.nextInt(boundaryNo);
		return randomNumber;
	}
	
}
