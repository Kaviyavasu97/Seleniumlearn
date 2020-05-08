package day1.week2;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Azure {
	public static void main(String[] args) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaviy\\Downloads\\chromedriver_win32 (1)/chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
	options.merge(cap);
	ChromeDriver driver = new ChromeDriver(options);
	WebDriverWait wait = new WebDriverWait(driver,30);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://azure.microsoft.com/en-in/");
	//click pricing
	driver.findElementByXPath("//a[text()='Pricing']").click();
	//click pricing calculator
	driver.findElementByXPath("(//a[@data-bi-id='global-navigation-secondarynav-clicked-topmenu'])[2]").click();
	//click containers
	driver.findElementByXPath("//button[text()='Containers']").click();
	//click container instances
	driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@id='new-module-loc']").click();
	//select region
	WebElement elesrc = driver.findElementByXPath("(//select[@aria-label='Region'])");
	Select option = new Select(elesrc);
	option.selectByVisibleText("South India");
	//set seconds
	driver.findElementByXPath("//input[@aria-label='Seconds']").clear();
	driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys(Keys.ARROW_LEFT);
	driver.findElementByXPath("//input[@aria-label='Seconds']").sendKeys("18000");
	//Memory 4 gb
	WebElement elesrc1 = driver.findElementByXPath("(//select[@aria-label='Memory'])[1]");
	Select option1 = new Select(elesrc1);
	option1.selectByVisibleText("4 GB");
	//click show dev
	driver.findElementByXPath("//button[@id='devtest-toggler']").click();
	WebElement elesrc2 = driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
	Select option2 = new Select(elesrc2);
	option2.selectByValue("INR");
	String text = driver.findElementByXPath("(//span[@class='numeric'])[6]/span").getText();
	System.out.println("The Estimated price is" + text);
	driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("plugins.always_open_pdf_externally", true);
	chromePrefs.put("download.default_directory", "C:\\Users\\kaviy\\Downloads");
	options.setExperimentalOption("prefs", chromePrefs);
	String downloadPath = "C:\\Users\\kaviy\\Downloads";
	File getLatestFile = getLatestFilefromDir(downloadPath);
	String fileName = getLatestFile.getName();	
	System.out.println("The downloaded file name is: "+fileName);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,document.body.scrollTop)");
	Thread.sleep(2000);
	driver.findElementByXPath("//li[@id='solution-architectures-picker']/a").click();
	driver.findElementByXPath("//button[@title='CI/CD for Containers']").click();
	driver.findElementByXPath("//button[text()='Add to estimate']").click();
	WebElement elesrc3 = driver.findElementByXPath("(//select[@aria-label='Currency'])[1]");
	Select option3 = new Select(elesrc2);
	option3.selectByValue("INR");
	Thread.sleep(4000);
	driver.findElementByXPath("//button[@id='devtest-toggler']").click();
	driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
	String downloadPath1 = "C:\\Users\\kaviy\\Downloads";
	File getLatestFile1 = getLatestFilefromDir(downloadPath);
	String fileName1 = getLatestFile.getName();	
	System.out.println("The downloaded file name is: "+fileName);
	
	
	

}

	private static File getLatestFilefromDir(String downloadPath) {
		// TODO Auto-generated method stub
		return null;
	}
}
