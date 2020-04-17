package day1.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nykaapp {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");
		Actions builder = new Actions(driver);
		WebElement elesrc = driver.findElementByXPath("//a[text()='brands']");
		builder.moveToElement(elesrc)
		.pause(2000)
		.perform();
		WebElement elesrc1 = driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(elesrc1)
		.perform();
		driver.findElementByXPath("(//li[@class='brand-logo menu-links'])[5]/a").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>();
		allWindows.addAll(windowHandles);
		driver.switchTo().window(allWindows.get(1));
		String title = driver.getTitle();
		if(title.contains("L'Oreal "))
		{
			System.out.println("The title is"+ title);
		}
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='filter-sidebar__filter-title pull-left'])[1]").click();
		driver.findElementByXPath("//span[text()='Shampoo (21)']").click();
		String text = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']/li").getText();
		if(text.contains("Shampoo"))
		{
			System.out.println("Filter is applied");
		}
		driver.findElementByXPath("(//div[@class='card-img'])[4]/div/img").click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> allWindows1 = new ArrayList<String>();
		allWindows1.addAll(windowHandles1);
		driver.switchTo().window(allWindows1.get(2));
		driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
		String text2 = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println(text2);
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='pull-left'])[1]/div/button").click();
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		String text3 = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		System.out.println(text3);
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		String text4 = driver.findElementByXPath("//div[@class='message']").getText();
		System.out.println(text4);
		driver.quit();
		
		
		
	}

}
