package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class List {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("(//a[text()='Go to Home Page'])[1]").click();
		driver.navigate().back();		
	    System.out.println(driver.findElementByXPath("//a[text()='Find where am supposed to go without clicking me?']").getAttribute("href"));
	   driver.findElementByXPath("//a[text()='Verify am I broken?']").click();
	   String text = driver.findElementByTagName("h1").getText();
	 
	   if(text.contains("HTTP"))
	   {
		   System.out.println("Its broken");
	   }
	   else
	   {
		   System.out.println("its not broken");
	   }
	   driver.navigate().back();
	   driver.findElementByXPath("(//a[text()='Go to Home Page'])[2]").click();
	   driver.navigate().back();
	   java.util.List<WebElement> elesLink = driver.findElementsByTagName("a");
	   System.out.println(elesLink.size());
	   
		
		
	}
}
