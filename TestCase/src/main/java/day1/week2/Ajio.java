package day1.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {
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
		driver.get("https://www.ajio.com/shop/sale");
		driver.findElementByXPath("//input[@placeholder='Search AJIO']").sendKeys("Bags");
		Thread.sleep(2000);
		driver.findElementByXPath("(//span[text()='Bags in '])[1]").click();
		//select five grid
		driver.findElementByXPath("//div[@class='five-grid']").click();
		//select whats new
		WebElement elesrc = driver.findElementByXPath("//div[@class='filter-dropdown']/select");
		Select option = new Select(elesrc);
		option.selectByVisibleText("What's New");
		//select price
		driver.findElementByXPath("//span[text()='price']").click();
		driver.findElementById("minPrice").sendKeys("2500");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("(//button[@type='submit'])[2]").click();
		Thread.sleep(2000);
		//select  puma bag
		driver.findElementByXPath("//img[@alt='Puma Red Shoulder Ferrari LS Shoulder Bag']").click();
		//switch to new window
		Set<String> allWindows = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>();
		windows.addAll(allWindows);
		driver.switchTo().window(windows.get(1));
		//get price of product
		String prodPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText();
		String price = prodPrice.replaceAll("\\D", "");
		int finalPrice = Integer.parseInt(price);
		String couponCode = driver.findElementByXPath("//div[text()='Use Code']/br").getText();
		
		if(finalPrice>=2690)
		{
			String couponCode1 = driver.findElementByXPath("//div[text()='Use Code']/br").getText();
		}
			
		String offerPrice = driver.findElementByXPath("//div[text()='Get it for ']/span").getText();
		String pri = offerPrice.replaceAll("\\D", "");
		int finalPrice3 = Integer.parseInt(pri);
		int discountPrice =finalPrice - finalPrice3 ;
		System.out.println(discountPrice);
		Thread.sleep(2000);
		//check for pincode
		driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("560043");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		//other info
		driver.findElementByXPath("//div[@class='other-info-toggle']").click();
		String text = driver.findElementByXPath("(//span[@class='other-info'])[6]").getText();
		System.out.println(text);
		//add to bag
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(7000);
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
		//check order total
		String text2 = driver.findElementByXPath("//div[@class='net-price best-price-strip']").getText();
		String replaceAll = text2.replaceAll("\\D", "");
		int orderTotal = Integer.parseInt(replaceAll);
		//enter coupon
		driver.findElementById("couponCodeInput").sendKeys(couponCode);
		driver.findElementByXPath("//button[text()='Apply']").click();
		Thread.sleep(2000);
		String text3 = driver.findElementByXPath("(//span[@class='price-value discount-price'])[2]").getText();
		String replaceAll2 = text3.replaceAll("\\D", "");
		float f1 = Float.parseFloat(replaceAll2);
		int a = Math.round(f1);
		//to check
		if(a==discountPrice)
		{
			System.out.println("Matches");
		}
		//clik delete
		driver.findElementByXPath("//div[text()='Delete']").click();
		driver.quit();
		
		
		

}
}
