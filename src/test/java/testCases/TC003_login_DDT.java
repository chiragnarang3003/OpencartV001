package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
 * 1. Data is Valid -- Login success --> Test Pass -- logout 
 * 2. Data is valid -- login failed  --> Test Fail
 * 
 * 3. Data is invalid -- login success --> test Fail -- logout
 * 4. Data is invalid -- login failed -- Test Pass
 */


public class TC003_login_DDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven") //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		
		logger.info("************TC_003_Login_DDT_ Started****************");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
				
		//LoginPage
		loginPage lp = new loginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
		//MyAccountPage
		myAccountPage map = new myAccountPage(driver);
		boolean targetPageHeader = map.isMyAccountPageExists();
				
		//validations
		if(exp.equalsIgnoreCase("valid"))
		{
			if (targetPageHeader == true)
			{
				map.clickLogout();
				Assert.assertTrue(true);					
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
			{
				if (targetPageHeader == true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("********TC003_Login_DDT_ Complete************");
	}
}
