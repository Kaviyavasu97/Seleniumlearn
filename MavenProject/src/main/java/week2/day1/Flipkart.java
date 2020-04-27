package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElementByClassName("_2zrpKA _1dBPDZ").sendKeys("9840816684");
		Actions action = new Actions(driver);
		WebElement element = driver.findElementById("_1QZ6fC _3Lgyp8");
		action.moveToElement(element).perform();
		


	}

}
