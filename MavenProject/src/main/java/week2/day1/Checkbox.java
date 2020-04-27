package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		boolean sel = driver.findElementByXPath("(//input[@type='checkbox'])[6]").isSelected();
		if(sel)
		{
			System.out.println("selected");
			String text = driver.findElementByXPath("(//div[@class='example'])[2]").getText();
			System.out.println(text);
		}
	}

}
