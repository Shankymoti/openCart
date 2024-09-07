package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	//constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement headermsg;
	
	@FindBy(xpath="//div[@class='list-group']//a[contains(text(),'Logout')]")
	WebElement lnkLogout;
	
	
	public boolean isMyAccountExist() {
		try {
			return (headermsg.isDisplayed());
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickOnLogout() {
		lnkLogout.click();
	}

}
