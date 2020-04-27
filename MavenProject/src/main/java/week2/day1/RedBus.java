package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/?gclid=EAIaIQobChMIz8GwpP_Z5gIVDA4rCh1RfAmKEAAYASAAEgKC_fD_BwE");
        driver.manage().window().maximize();
        driver.findElementById("src").sendKeys("chennai");
        driver.findElementById("dest").sendKeys("Trichy");
        driver.findElementByClassName("db text-trans-uc").click();
        driver.findElementByClassName("current day").click();


	}

}
