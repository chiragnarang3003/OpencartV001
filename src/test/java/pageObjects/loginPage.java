package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{
	
	//Constructor
	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//input[@id = 'input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath = "//input[@id = 'input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value = 'Login']")
	WebElement btnLogin;
	
	//Action Methods
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String Pwd)
	{
		txtPassword.sendKeys(Pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}

}
