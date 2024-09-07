package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;  //Log4j
import org.apache.logging.log4j.Logger;  //Log4j

public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		//get file in valriable
		FileReader file =  new FileReader("./src//test//resources//config.properties");
		// load
		p=new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) {
		case "chrome" : 
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver =  new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default : 
			System.out.println("Invalid Browser Name");
			return;  // here return means it will totally removed from execution
		}
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	
	public String randomString() {
		
//		import org.apache.commons.lang3.RandomStringUtils;   .randomAlphabetic(10) is static method which will return 10 character of string
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber() {
		String generateNumber =  RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	
	
	
	public String randomAlphaNumeric() {
		String generateString = RandomStringUtils.randomAlphabetic(3);
		String generateNumber = RandomStringUtils.randomNumeric(3);
		return (generateString+"@"+generateNumber);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
