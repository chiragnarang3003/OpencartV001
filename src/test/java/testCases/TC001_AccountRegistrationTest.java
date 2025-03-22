package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {


	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		
		try {
		logger.info("*******Starting TC001_AccountRegistrationTest *********");
		
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("********* Click on MyAccount Link *******");
		
		hp.clickRegister();
		logger.info("********* Click on Register/Login link  *******");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("******* Providing customer details ********");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("******* Validating expected Message ********");
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
		Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed......");
			logger.debug("Debug logs.......");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("********Finished TC001_AccountRegistrationTest ***********");
	}
	

	
}
