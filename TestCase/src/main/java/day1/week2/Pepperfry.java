package day1.week2;


//import java.awt.image.BufferedImage;
import java.io.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graphbuilder.curve.Point;
import com.mongodb.MapReduceCommand.OutputType;


public class Pepperfry {
	public static void main(String[] args) throws InterruptedException, IOException
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
		//go to honda.com
		driver.get("https://www.pepperfry.com/");
		Thread.sleep(2000);
		//Mouse over on furniture
		WebElement ele1 = driver.findElementByXPath("(//a[text()='Furniture'])[1]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele1)
		.perform();
		//click office chairs
		driver.findElementByXPath("//a[text()='Office Chairs']").click();
		Thread.sleep(2000);
		//click executive chairs
		driver.findElementByXPath("(//div[@class='clip-cat-wrap'])[2]").click();
		//set dimension 50
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").clear();
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys("50");
		driver.findElementByXPath("(//input[@class='clipFilterDimensionHeightValue'])[1]").sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		try {
			driver.findElementByXPath("//div[@id='regPopUp']//a[@class='popup-close']").click(); 
			System.out.println("Login popup closed.");
		} catch (Exception e) {
			System.out.println("Login popup not found.");
			e.printStackTrace();
		}
		
		// Adding to Wishlist 
		driver.findElementByXPath("//a[contains(@data-productname,'Poise Executive Chair in Black Colour')]").click(); 
		//mouse over on homeware
		WebElement ele3 = driver.findElementByXPath("//a[text()='Homeware']");
		Actions builder1 = new Actions(driver);
		builder.moveToElement(ele3)
		.perform();
		//click on pressure cookers
		driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
		Thread.sleep(2000);
		//select  brand as prestige
		driver.findElementByXPath("//label[@for='brandsnamePrestige']").click();
		Thread.sleep(2000);
		//select litre
		driver.findElementByXPath("//label[@for='capacity_db1_Ltr_-_3_Ltr']").click();
		Thread.sleep(2000);
		//add to cooker to wishlist
		driver.findElementByXPath("//a[@data-productname='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']").click();
	   //click wishlist
		driver.findElementByXPath("//a[@data-tooltip='Wishlist']").click();
		Thread.sleep(2000);
		//get list no
		String text = driver.findElementByXPath("//a[@id='mini-userwishlist-tab']/span").getText();
		System.out.println(text);
		//add cooker to cart
		driver.findElementByXPath("(//a[@unbxdattr='AddToCart'])[2]").click();
		driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600052");
		driver.findElementByXPath("//a[text()='Check']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
		//16) Capture the screenshot of the item under Order Item 
		File src = driver.findElementByXPath("//a[@class='ck-pro-img-link']/img").getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		File dsc = new File("./screenshot.png");
		FileUtils.copyFile(src, dsc);
		driver.close();
		

}
}
