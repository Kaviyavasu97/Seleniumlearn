package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("yes").click();
		
		boolean sel2 = driver.findElementByXPath("//label[@for='Checked']").isSelected();
		if(sel2==true)
		{
			String text1 = driver.findElementByXPath("//label[@for='Checked']/input").getText();
			System.out.println(text1);
		}
		
	}

}
