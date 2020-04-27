package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
	    driver.findElementByLinkText("Leads").click();
	    driver.findElementByXPath("//a[text()='Merge Leads']").click();
	    driver.findElementByXPath("//img[@src='/images/fieldlookup.gif']").click();
	    Set<String> allWindows = driver.getWindowHandles();
	    List<String> listOfWindows = new ArrayList<>();
	    listOfWindows.addAll(allWindows);
	    driver.switchTo().window(listOfWindows.get(1));
	    driver.findElementByXPath("//input[@name='firstName']").sendKeys("Babu");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(2000);
	    //driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	    driver.switchTo().window(listOf)
	    
	    	
	    		
	    		
	    
	   

		

	}

}
