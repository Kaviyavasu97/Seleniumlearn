package day1.week2;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zalando {
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
	driver.get("https://www.zalando.com/");
	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	String text = alert.getText();
	alert.accept();
	System.out.println(text);
	//select uk
	driver.findElementByXPath("//a[text()='Zalando.uk']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//span[text()='Women']").click();
	 driver.findElementByXPath("//span[text()='Clothing']").click();
	 Thread.sleep(2000);
	 driver.findElementByXPath("//a[@aria-label='Browse Coats by category']").click();
	 Thread.sleep(2000);
	 //select cotton
	 driver.findElementByXPath("//span[text()='Material']").click();
	 driver.findElementByXPath("//span[text()='Cotton']").click();
	 driver.findElementById("uc-btn-accept-banner").click();
	 Thread.sleep(2000);
	 driver.findElementByXPath("//button[text()='Save']").click();
	 Thread.sleep(2000);
	 driver.findElementByXPath("//span[text()='Length']").click();
	 driver.findElementByXPath("//span[text()='thigh-length']").click();
	 driver.findElementByXPath("//button[text()='Save']").click();
	 Thread.sleep(2000);
	 driver.findElementByXPath("//div[text()='MANTEL - Parka - navy']/../..").click();
	 Thread.sleep(2000);
	 driver.findElementByXPath("(//img[@alt='olive'])[2]").click();
	 //check out of stock
	 String text2 = driver.findElementByXPath("//div[@id='z-pdp-topSection']/div[1]/h2").getText();
	 if(text2.contains("Out of stock"))
	 {
		 driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
		 driver.findElementById("picker-trigger").click();
		 driver.findElementByXPath("//span[text()='M']").click();
	 }
	 String text3 = driver.findElementByXPath("(//button[@aria-label='Free'])[1]/span").getText();
	 if(text3.contains("Free"))
	 {
		 driver.findElementByXPath("//span[text()='Add to bag']").click();
	 }
	WebElement elesrc = driver.findElementByXPath("//span[text()='Your bag']");
	Actions act = new Actions(driver);
	act.moveToElement(elesrc).perform();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[text()='Go to bag']").click();
	String text4 = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText();
	System.out.println(text4);
	//Mouse over on free delivery
	WebElement ele2 = driver.findElementByXPath("//a[text()='Free delivery & returns*']");
	act.moveToElement(ele2).perform();
	String attribute = driver.findElementByXPath("//a[text()='Free delivery & returns*']//parent::span").getAttribute("title");
	System.out.println(attribute);
	Thread.sleep(3000);
	driver.findElementByXPath("//span[text()='Start chat']").click();
	Set<String> windows = driver.getWindowHandles();
	List<String> windowList = new ArrayList<String>(windows);
	driver.switchTo().window(windowList.get(1));
	
	//14 Enter you first name and a dummy email and click Start Chat
	driver.findElementById("prechat_customer_name_id").sendKeys("kaviya");
	driver.findElement(By.id("prechat_customer_email_id")).sendKeys("kaa@gmail.com");
	driver.findElement(By.id("prechat_submit")).click();
	
	//15 Type Hi, click Send and print thr reply message and close the chat window.
	Thread.sleep(3000);
	driver.findElementById("liveAgentChatTextArea").sendKeys("Hi");
	driver.findElement(By.xpath("//button[@title='Send']")).click();
	System.out.println(driver.findElement(By.xpath("(//span[@class='messageText'])[4]")).getText());
	driver.quit();
	
	

}
}
