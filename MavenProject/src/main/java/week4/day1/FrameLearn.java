package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameLearn {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver  = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Kaviya");
		alert.accept();
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		if(text.contains("Kaviya"))
		{
			System.out.println("Yes its contains my name");
		}
		
		
		
		
	}

}
