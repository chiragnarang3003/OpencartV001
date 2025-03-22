package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("**********Starting TC_002_loginTest**************");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		loginPage lp = new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		myAccountPage map = new myAccountPage(driver);
		boolean targetPageHeader = map.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPageHeader, true, "Login Failed");
		Assert.assertTrue(targetPageHeader);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**********TC002_finished***************");
	}

}
