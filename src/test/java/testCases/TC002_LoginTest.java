package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	//@Test(groups="Regression")
	@Test(groups= {"Sanity","Master"})
	public void verifyLogin()
	{	
		logger.info("***** Starting C002_LoginTest ****");
		try {
			
	
		//HomePage
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickOnLogin();
	
	//LoginPage
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	System.out.println(p.getProperty("password"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLoginBtn();
	
	//MyAccountPage
	MyAccountPage ap = new MyAccountPage(driver);
	boolean targetPage = ap.isMyAccountExist();
	
	//Assert.assertEquals(targetPage, true, "Login Failed");
	Assert.assertTrue(targetPage);
	Thread.sleep(5000);
	}catch(Exception e) {
		Assert.fail();
	}
	logger.info(" ******* Finished TC002_LoginTest *******");
	
	}

}
