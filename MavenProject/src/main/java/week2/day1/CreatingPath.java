package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingPath {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementByXPath("//input[@id='username']").sendKeys("DemoSalesManager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Amazon");
		driver.findElementByXPath("//span[text()='First name']/following::input").sendKeys("kaviya");
		
		
		
			
		

	}

}
