package day1.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapDeal {
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
		//go to snapdeal.com
		driver.get("https://www.snapdeal.com/");
		//Mouse over on toys
		Actions builder = new Actions(driver);
		WebElement ele1 = driver.findElementByXPath("(//span[@class='catText'])[8]");
		builder.moveToElement(ele1)
		.perform();
		//click educational toys 
		driver.findElementByXPath("//span[text()='Educational Toys']").click();
		//click customer rating above 4
		driver.findElementByXPath("//div[@data-name='avgRating']/div[1]").click();
		Thread.sleep(2000);
		//discount as 40-50
		driver.findElementByXPath("//div[@data-name='discount']/div[5]").click();
		//enter the pincode
		driver.findElementByXPath("//input[@placeholder='Enter your pincode']").sendKeys("600018");
		//click on check button
		driver.findElementByXPath("//button[text()='Check']").click();
		//click on quick view
		WebElement elesrc = driver.findElementByXPath("//div[@class='product-row js-product-list centerCardAfterLoadWidgets dp-click-widgets']/section[1]/div[1]");
		Actions act = new Actions(driver);
		act.moveToElement(elesrc)
		.perform();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='product-tuple-image ']/div)[1]/div").click();
		Thread.sleep(2000);
		//click view details
		driver.findElementByXPath("//a[@class=' btn btn-theme-secondary prodDetailBtn']").click();
		//capture price
		String text = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		int price = Integer.parseInt(text);
		//get delivery charge
		String delchg = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText().trim();
		String delivery = delchg.replaceAll("\\D", "");
        int deliverycharge = Integer.parseInt(delivery);
        int total = price + deliverycharge;
        System.out.println(total);
        //add to cart
        driver.findElementByXPath("//span[text()='add to cart']").click();
        Thread.sleep(2000);
		String text2 = driver.findElementByXPath("//div[@class='you-pay']/span").getText();
		String str1 = text2.replaceAll("\\D", "");
		int a = Integer.parseInt(str1);
		if(a==total)
		{
			System.out.println("The price matches");
		}
		else
		{
			System.out.println("The price is not matching");
		}
		//search for sanitizer
		driver.findElementById("inputValEnter").sendKeys("Sanitizer");
		driver.findElementByXPath("//span[@class='searchTextSpan']").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
		Thread.sleep(2000);
		//click  BioAyurveda Neem Power Hand Sanitizer
		driver.findElementByXPath("//p[text()='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>();
		windows.addAll(allWindows);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(2000);
		//get product price
		String text3 = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		int d = Integer.parseInt(text3);
		String text4 = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText();
		String str2 = text4.replaceAll("\\D", "");
		int b = Integer.parseInt(str2);
		int sanprice =  d + b;
		System.out.println(sanprice);
		driver.findElementByXPath("//span[text()='ADD TO CART']").click();
		driver.findElementByXPath("//span[text()='Cart']").click();
		//get total value
		String attribute = driver.findElementByXPath("//input[@class='btn btn-xl rippleWhite cart-button']").getAttribute("value");
		String finalPrice = attribute.replaceAll("\\D", "");
		int finalAmount = Integer.parseInt(finalPrice);
		System.out.println(finalAmount);
		int finalAmt = sanprice + total;
		if(finalAmount==finalAmt)
		{
			System.out.println("The amount is equal to total sum of two products");
		}
		else
		{
			System.out.println("There is an error");
		}
		driver.quit();
		
		
		
	}

}
