package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("one plus 7 pro mobiles");
		driver.findElementByClassName("nav-input").click();
		String text = driver.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText();
		System.out.println("Price of the mobile" +text);
		driver.findElementByXPath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> listOfWindows  = new ArrayList<>();
		listOfWindows.addAll(allWindows);
		driver.switchTo().window(listOfWindows.get(1));
		String text2 = driver.findElementByXPath("//span[@id='acrCustomerReviewText']").getText();
		System.out.println("Customer ratings" +text2);
		driver.findElementById("add-to-cart-button").click();
		String text3 = driver.findElementByXPath("//h1[@class='a-size-medium a-text-bold']").getText();
		if(text3.contains("Added"))
		{
			System.out.println("Its confirmed that it is added to cart");
		}
		else
		{
			System.out.println("Not added");
		}
	    driver.findElementByLinkText("Proceed to Buy (1 item)").click();
		String title = driver.getTitle();
		System.out.println("Title is" +title);
		driver.findElementById("continue").click();
		String text4 = driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText();
		System.out.println(text4);
		driver.quit();
		
		
		
	}

}
