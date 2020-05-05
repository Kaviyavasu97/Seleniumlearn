package day1.week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Justdial {
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
		WebDriverWait wait = new WebDriverWait(driver,50);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//go to  justdial.com
		driver.get("https://www.justdial.com/");
		//to set city chennai
		driver.findElementByXPath("//input[@id='city']").click();
		driver.findElementByXPath("//a[@id='Chennai']").click();
		//cick auto care
		driver.findElementByXPath("//a[@title='Auto Care in Chennai']").click();
		Thread.sleep(2000);
		//click car repair
		driver.findElementByXPath("//span[text()='Car Repair']").click();
		Thread.sleep(2000);
		//click hyundai
		driver.findElementByXPath("(//span[text()='Hyundai'])[1]").click();
		Thread.sleep(2000);
		//click hyundai accent
	    driver.findElementByXPath("(//span[text()='Hyundai Accent'])[1]").click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Location']")));
	    driver.findElementByXPath("//a[text()='Location']").click();
	    Thread.sleep(2000);
	    driver.findElementById("sortbydist").clear();
	    driver.findElementById("sortbydist").sendKeys("porur");
	    driver.findElementById("sortbydistbtn").click();
	    driver.findElementByXPath("//span[text()='Distance ']").click();
	    driver.findElementByXPath("//a[text()='1 km']").click();
		
 }
}
