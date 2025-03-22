package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{
	
	
	//constructor
	public myAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator
	@FindBy(xpath="//h2[text()='My Account']") //MyAccount page Headingf2
	WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") //added in step 6
	WebElement lnkLogout;
	
	//action method
	
	public boolean isMyAccountPageExists()
	{
		try {
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
		
	
	public void clickLogout()
	{
		lnkLogout.click();
		}
	
}
