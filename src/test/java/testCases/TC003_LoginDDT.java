package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
 					login failed - test fail

Data is invalid - login success - test fail  - logout
 					login failed - test pass
*/


public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Master")// getting data provider from different class
	public void verify_loginDDT(String username, String password, String res) throws InterruptedException
	{
		logger.info("***** stating TC_003_LoginDDT ******");
		
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickOnLogin();
		Thread.sleep(3000);
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(username);
		Thread.sleep(2000);
		System.out.println(password);
		lp.setPassword(password);
		lp.clickLoginBtn();
		Thread.sleep(3000);
		
		//MyAccountPage
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isMyAccountExist();
				
		if(res.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{			
				ap.clickOnLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				ap.clickOnLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finished TC_003_LoginDDT ******");
		
	}
	
}









