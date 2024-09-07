package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage  extends BasePage{
	
	
	//constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtBFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtBLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtBEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtBTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtBPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtBConfirmPassword;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chekBoxElement;
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg;
	
	
	//Actions
	
	public void enterFirstName(String firstName) {
		
		txtBFirstName.sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		txtBLastName.sendKeys(lastName);
	}
	public void enterEmail(String email) {
		txtBEmail.sendKeys(email);
	}
	public void enterTelephone(String number) {
		txtBTelephone.sendKeys(number);
	}
	public void enterPassword(String pwd) {
		txtBPassword.sendKeys(pwd);
	}
	public void enterConfirmPassword(String pwd) {
		txtBConfirmPassword.sendKeys(pwd);
	}
	public void clickOnCheckbox() {
		chekBoxElement.click();
	}
	public void clickOnContinueButton() {
		//Sol1
		btnContinue.click();
		
		//Sol2
	/*	Actions act =  new Actions(driver);
		act.moveToElement(btnContinue).click().perform();  */
		
		//sol3
	//	btnContinue.submit();
		
		
		//sol4
	/*	JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
		
		//sol5
		btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click(); */
		
	}
	
	public String getConfirmationMsg() {
		try {
			return (msg.getText());
		}
		catch(Exception e) {
			return e.getMessage();
		}
		
		
	}
	
}
	
	

	