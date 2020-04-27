package week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String[]  args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement eleSrc = driver.findElementById("dropdown1");
		Select obj = new Select(eleSrc);
		obj.selectByIndex(1);
		WebElement elesrc1 = driver.findElementByName("dropdown2");
		Select obj2 = new Select(elesrc1);
		obj2.selectByVisibleText("Appium");
		WebElement eleSrc2 = driver.findElementById("dropdown3");
		Select obj1 = new Select(eleSrc2);
		obj1.selectByValue("4");
		WebElement elesize = driver.findElementByClassName("dropdown");
		Select obj3 = new Select(elesize);
			List<WebElement> a = obj3.getOptions();
		System.out.println(a.size());
		WebElement eleSel = driver.findElementByXPath("(//div[@class='example'])[5]/select");
		eleSel.sendKeys("Appium");
		WebElement mulSel = driver.findElementByXPath("(//div[@class='example'])[6]/select");
		Select obj4 = new Select(mulSel);
		obj4.selectByValue("3");
		obj4.selectByValue("1");
		
		
		
     		
				
		
		
		
	}

}
