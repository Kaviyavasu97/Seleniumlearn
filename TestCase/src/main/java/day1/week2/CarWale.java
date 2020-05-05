package day1.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarWale {
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
		Actions action = new Actions(driver);
		//go to carwale.com
		driver.get("https://www.carwale.com/");
		//click used
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
		//select city
		WebElement eleSrc = driver.findElementByXPath("//input[@id='usedCarsList']");
		eleSrc.sendKeys("chennai");
		Thread.sleep(2000);
		eleSrc.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//select budget
		WebElement elesrc1= driver.findElementByXPath("//input[@id='minInput']");
		elesrc1.sendKeys("8");
		Thread.sleep(2000);
		elesrc1.sendKeys(Keys.ENTER);
		WebElement elesrc2 = driver.findElementByXPath("//input[@id='maxInput']");
		elesrc2.sendKeys("12");
		Thread.sleep(2000);
		elesrc2.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//click on search
		driver.findElementById("btnFindCar").click();
		Thread.sleep(2000);
		driver.findElementById("closeLocIcon").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//li[@name='CarsWithPhotos']").click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        driver.findElementByXPath("//input[@id='tags']").sendKeys("hyundai");
		//select hyundai
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[text()=' Hyundai ']")));
		driver.findElementByXPath("//span[text()=' Hyundai ']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Creta']").click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@name='fuel']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//li[@name='Petrol']").click();
		WebElement selOpt = driver.findElementById("sort");
		Select option = new Select(selOpt);
	    option.selectByVisibleText("Price: Low to High");
	    JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
	    List<WebElement> carList = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
	    List<Integer> kmList = new ArrayList<Integer>();
	    int size = carList.size();
	    System.out.println(size);
	    for(int i=0;i<size;i++)
	    {
	    	String text = carList.get(i).getText();
	    	String replaceAll = text.replaceAll("\\D", "");
	    	int kms = Integer.parseInt(replaceAll);
	    	kmList.add(kms);
	    }
	    Collections.sort(kmList);
	    Integer first = kmList.get(0);
	    System.out.println(first);
	    JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,6000)", "");
	    for(int i=0;i<size;i++)
	    {
	    	String text = carList.get(i).getText();
	    	String replaceAll = text.replaceAll("\\D", "");
	    	int kms = Integer.parseInt(replaceAll);
	    	if(kms==first)
	    	{
	    		Thread.sleep(2000);
	    		WebElement element = driver
						.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[" + (i + 1) + "]");
				action.moveToElement(element).perform();
				js.executeScript("arguments[0].click();", element);
	    	}
	    }
	    	driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']").click();
	    	Thread.sleep(2000);
	    	driver.findElementByXPath("//a[text()='More details »']").click();
	    	Set<String> allWindows = driver.getWindowHandles();
	    	List<String> windows = new ArrayList<String>();
	    	windows.addAll(allWindows);
	    	driver.switchTo().window(windows.get(1));
	    	Thread.sleep(2000);
	    	List<WebElement> elements = driver.findElementsByXPath("//div[@id='overview']/div/ul/li");
		    Map<String,String> map = new HashMap<String,String>();
	    	int size2 = elements.size();
	    	for(int i=0;i<size2;i++)
	    	{
	    		String key = driver.findElementByXPath("(//div[@id='overview']/div/ul/li)[" + (i+1) + "]/div[1]").getText();
	    		String value = driver.findElementByXPath("(//div[@id='overview']/div/ul/li)[" + (i+1) + "]/div[2]").getText();
	    		
	    		map.put(key, value);
	    	}
	    	
	    	 for(Entry<String,String> eachMap:map.entrySet())
	 	    {
	 	    	System.out.println(eachMap.getKey()+"    "+eachMap.getValue());
	 	    	System.out.println();
	 	    }
	 	    driver.quit();
	    	
	    
		
		
		
	

}
}