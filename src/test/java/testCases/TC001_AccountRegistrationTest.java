package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
//	public WebDriver driver;
//	
//	
//	@BeforeClass
//	public void setup() {
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://tutorialsninja.com/demo/");
//		driver.manage().window().maximize();
//		
//		
//	}
//	
//	@AfterClass
//	public void teardown() {
//		driver.quit();
//	}
//	
	//@Test(groups="Sanity")
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		logger.info("***** Starting TC001_accountRegistrationTest *****");
		try {
		HomePage homePage = new HomePage(driver);
		
		homePage.clickMyAccount();
		logger.info("****** Clicked on MyAccountLink *****");
		homePage.clickRegister();
		logger.info("****** Clicked on  Register Link *****");
		
		AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
		logger.info(" Providing Customer Details ....");
		accountRegistrationPage.enterFirstName(randomString().toUpperCase());
		accountRegistrationPage.enterLastName(randomString().toUpperCase());
		accountRegistrationPage.enterEmail(randomString()+"@gmail.com");
		accountRegistrationPage.enterTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		accountRegistrationPage.enterPassword(password);
		accountRegistrationPage.enterConfirmPassword(password);
		accountRegistrationPage.clickOnCheckbox();
		accountRegistrationPage.clickOnContinueButton();
		logger.info("Validating Expected Message ...");
	
		String actualmsg =accountRegistrationPage.getConfirmationMsg();
		if(actualmsg.equals("Your Account Has Been Created!")) {
			
			
			AssertJUnit.assertTrue(true);
		}
		else {
			logger.error("Test Failed...");
			logger.debug("Defbug logs...");
			AssertJUnit.assertFalse(true);
		}
		//Assert.assertEquals(actualmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			AssertJUnit.fail();
		}
		
		
		logger.info("**** Finished TC001_accountRegistrationTest *****");
		
	}
	

	
	
	
	
	
}
