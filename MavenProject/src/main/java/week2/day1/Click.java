package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Click {
	public static void main(String[] args)
			{
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/");
	driver.manage().window().maximize();
	driver.findElementByXPath("//h5[text()='Selectable']").click();
	Actions builder = new Actions(driver);
	builder.clickAndHold(driver.findElementByXPath("//li[text()='Item 1']")).perform();
	builder.release();
	builder.clickAndHold(driver.findElementByXPath("//li[text()='Item 1']")).perform();
	builder.release();
	
	

			}
	
	

}
